package com.varunbarad.feedsample.feed.list.viewholders

import com.varunbarad.feedsample.R
import com.varunbarad.feedsample.databinding.PostIntroBinding
import com.varunbarad.feedsample.model.IntroPost

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
class IntroViewHolder(private val itemViewBinding: PostIntroBinding) : BaseViewHolder(itemViewBinding.root) {
  fun bind(post: IntroPost) {
    itemViewBinding.post = post
    itemViewBinding.executePendingBindings()

    itemViewBinding
        .content
        .text = when (post.introType) {
      "OFFER" -> itemViewBinding.root.context.resources.getString(R.string.template_intro_offer, post.info)
      else -> itemViewBinding.root.context.resources.getString(R.string.template_intro_rest, post.info)
    }
  }
}