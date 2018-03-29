package com.varunbarad.feedsample.feed.list.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.varunbarad.feedsample.databinding.PostFooterBinding
import com.varunbarad.feedsample.feed.FeedPresenter

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
class FooterViewHolder(private val itemViewBinding: PostFooterBinding, private val presenter: FeedPresenter) : BaseViewHolder(itemViewBinding.root) {
  fun bind(totalPages: Int, currentPage: Int) {
    if ((totalPages - currentPage) > 1) {
      itemViewBinding
          .root
          .visibility = View.VISIBLE
      itemViewBinding
          .root
          .layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
      presenter.loadPostsFromNetwork(currentPage + 1)
    } else {
      itemViewBinding
          .root
          .visibility = View.GONE
      itemViewBinding
          .root
          .layoutParams = RecyclerView.LayoutParams(0, 0)
    }
  }
}