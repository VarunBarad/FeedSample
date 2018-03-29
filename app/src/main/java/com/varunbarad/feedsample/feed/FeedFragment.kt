package com.varunbarad.feedsample.feed

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.varunbarad.feedsample.databinding.FragmentFeedBinding
import com.varunbarad.feedsample.feed.list.PostsAdapter
import com.varunbarad.feedsample.listener.FragmentInteractionListener
import com.varunbarad.feedsample.model.Post

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FeedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FeedFragment : Fragment(), FeedView {
  private lateinit var category: String

  override lateinit var presenter: FeedPresenter
  private var postsAdapter: PostsAdapter = PostsAdapter(mutableListOf())

  private var totalPages = 0
  private var currentPage = 0

  private lateinit var dataBinding: FragmentFeedBinding
  private var fragmentInteractionListener: FragmentInteractionListener? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (arguments != null) {
      category = arguments!!.getString(ARG_CATEGORY)
    }
    this.presenter = Presenter(this, category)
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

    dataBinding
        .recyclerViewPosts.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    dataBinding
        .recyclerViewPosts
        .adapter = postsAdapter
    presenter.loadPostsFromNetwork(currentPage)

    return this.dataBinding.root
  }

  override fun onDetach() {
    super.onDetach()
    fragmentInteractionListener = null
  }

  override fun showPosts(posts: MutableList<Post>, currentPage: Int, totalPages: Int) {
    postsAdapter
        .addPosts(posts)

    dataBinding
        .errorContainer
        .visibility = View.GONE
    dataBinding
        .progressContainer
        .visibility = View.GONE
    dataBinding
        .outputContainer
        .visibility = View.VISIBLE

    this.totalPages = totalPages
    this.currentPage = currentPage
  }

  override fun showError() {
    dataBinding
        .outputContainer
        .visibility = View.GONE
    dataBinding
        .progressContainer
        .visibility = View.GONE
    dataBinding
        .errorContainer
        .visibility = View.VISIBLE
  }

  override fun showProgress() {
    dataBinding
        .outputContainer
        .visibility = View.GONE
    dataBinding
        .errorContainer
        .visibility = View.GONE
    dataBinding
        .progressContainer
        .visibility = View.VISIBLE
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