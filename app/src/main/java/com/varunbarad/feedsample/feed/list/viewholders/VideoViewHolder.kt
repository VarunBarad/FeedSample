package com.varunbarad.feedsample.feed.list.viewholders

import com.varunbarad.feedsample.databinding.PostVideoBinding
import com.varunbarad.feedsample.model.VideoPost

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
class VideoViewHolder(private val itemViewBinding: PostVideoBinding) : BaseViewHolder(itemViewBinding.root) {
  fun bind(post: VideoPost) {
    itemViewBinding.post = post
    itemViewBinding.executePendingBindings()

    val embedCode = "<iframe width=\"100%\" src=\"https://www.youtube.com/embed/${post.videoId}\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"
    itemViewBinding
        .videoWebView
        .settings
        .javaScriptEnabled = true
    itemViewBinding
        .videoWebView
        .loadDataWithBaseURL("", embedCode, "text/html", "UTF-8", "")
  }
}