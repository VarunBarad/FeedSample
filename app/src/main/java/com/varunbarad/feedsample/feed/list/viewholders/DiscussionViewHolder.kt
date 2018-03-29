package com.varunbarad.feedsample.feed.list.viewholders

import com.varunbarad.feedsample.databinding.PostDiscussionBinding
import com.varunbarad.feedsample.model.DiscussionPost

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
class DiscussionViewHolder(private val itemViewBinding: PostDiscussionBinding) : BaseViewHolder(itemViewBinding.root) {
  fun bind(post: DiscussionPost) {
    itemViewBinding.post = post
    itemViewBinding.executePendingBindings()
  }
}