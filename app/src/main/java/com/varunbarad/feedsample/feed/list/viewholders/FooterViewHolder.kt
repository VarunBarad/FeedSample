package com.varunbarad.feedsample.feed.list.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.varunbarad.feedsample.databinding.PostFooterBinding

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
class FooterViewHolder(private val itemViewBinding: PostFooterBinding) : BaseViewHolder(itemViewBinding.root) {
  fun bind(loadMorePosts: Boolean) {
    if (loadMorePosts) {
      itemViewBinding
          .root
          .visibility = View.VISIBLE
      itemViewBinding
          .root
          .layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
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