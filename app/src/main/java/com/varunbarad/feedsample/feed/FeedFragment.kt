package com.varunbarad.feedsample.feed

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.varunbarad.feedsample.databinding.FragmentFeedBinding
import com.varunbarad.feedsample.listener.FragmentInteractionListener

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FeedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FeedFragment : Fragment() {
  private lateinit var message: String

  private lateinit var dataBinding: FragmentFeedBinding
  private var fragmentInteractionListener: FragmentInteractionListener? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (arguments != null) {
      message = arguments!!.getString(ARG_MESSAGE)
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    this.dataBinding = FragmentFeedBinding.inflate(inflater, container, false)
    this.dataBinding.textView.text = message
    return this.dataBinding.root
  }

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    if (context is FragmentInteractionListener) {
      fragmentInteractionListener = context
    } else {
      throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
    }
  }

  override fun onDetach() {
    super.onDetach()
    fragmentInteractionListener = null
  }

  companion object {
    private const val ARG_MESSAGE = "message"

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
      args.putString(ARG_MESSAGE, message)
      fragment.arguments = args
      return fragment
    }
  }
}