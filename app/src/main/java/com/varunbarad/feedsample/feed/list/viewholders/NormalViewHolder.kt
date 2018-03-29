package com.varunbarad.feedsample.feed.list.viewholders

import com.varunbarad.feedsample.R
import com.varunbarad.feedsample.databinding.PostNormalBinding
import com.varunbarad.feedsample.model.Post

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
class NormalViewHolder(private val itemViewBinding: PostNormalBinding) : BaseViewHolder(itemViewBinding.root) {
  fun bind(post: Post) {
    itemViewBinding.post = post
    itemViewBinding.executePendingBindings()

    if (post.info != null) {
      itemViewBinding.content.text = post.info
    } else {
      itemViewBinding.content.setText(R.string.message_ignoredLayout)
    }
  }
}