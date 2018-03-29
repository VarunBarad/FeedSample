package com.varunbarad.feedsample.feed

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.varunbarad.feedsample.databinding.FragmentFeedBinding
import com.varunbarad.feedsample.listener.FragmentInteractionListener
import com.varunbarad.feedsample.model.Post
import com.varunbarad.feedsample.remote.FeedServiceHelper
import com.varunbarad.feedsample.remote.parsePosts
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FeedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FeedFragment : Fragment() {
  private lateinit var category: String

  private var totalPages = 0
  private var currentPage = 0
  private val posts = mutableListOf<Post>()

  private lateinit var dataBinding: FragmentFeedBinding
  private var fragmentInteractionListener: FragmentInteractionListener? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (arguments != null) {
      category = arguments!!.getString(ARG_CATEGORY)
    }
  }

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    if (context is FragmentInteractionListener) {
      fragmentInteractionListener = context
    } else {
      throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    this.dataBinding = FragmentFeedBinding.inflate(inflater, container, false)
    this.dataBinding.textView.text = category

    this.fetchPostsFromNetwork()

    return this.dataBinding.root
  }

  override fun onDetach() {
    super.onDetach()
    fragmentInteractionListener = null
  }

  private fun fetchPostsFromNetwork() {
    val service = FeedServiceHelper
        .create()

    val retrofitCallback = object : Callback<ResponseBody> {
      override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
        if (response != null) {
          val postsResponse = JSONObject(response.body()?.string()).getJSONObject("data")

          totalPages = postsResponse.getInt("totalPages")
          currentPage = postsResponse.getInt("current_page")
          posts.addAll(parsePosts(postsResponse.getJSONArray("feeds")))
          dataBinding.textView.text = posts.size.toString()
        } else {
          Log.e("SERVICE", "Response was null")
        }
      }

      override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
        Log.e("NETWORK", t?.message)
      }

    }

    when (category) {
      "ALL" -> service.getAllPosts(currentPage).enqueue(retrofitCallback)
      "PHOTO" -> service.getPhotoPosts(currentPage).enqueue(retrofitCallback)
      "LINK" -> service.getLinkPosts(currentPage).enqueue(retrofitCallback)
      "VIDEO" -> service.getVideoPosts(currentPage).enqueue(retrofitCallback)
      "INTRODUCE" -> service.getIntroPosts(currentPage).enqueue(retrofitCallback)
    }
  }

  companion object {
    private const val ARG_CATEGORY = "category"

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param message Parameter 1.
     * @return A new instance of fragment FeedFragment.
     */
    fun newInstance(message: String): FeedFragment {
      val fragment = FeedFragment()
      val args = Bundle()
      args.putString(ARG_CATEGORY, message)
      fragment.arguments = args
      return fragment
    }
  }
}