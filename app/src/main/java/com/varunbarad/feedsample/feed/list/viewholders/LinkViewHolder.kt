package com.varunbarad.feedsample.feed.list.viewholders

import com.varunbarad.feedsample.databinding.PostLinkBinding
import com.varunbarad.feedsample.model.LinkPost

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
class LinkViewHolder(private val itemViewBinding: PostLinkBinding) : BaseViewHolder(itemViewBinding.root) {
  fun bind(post: LinkPost) {
    itemViewBinding.post = post
    itemViewBinding.executePendingBindings()
  }
}