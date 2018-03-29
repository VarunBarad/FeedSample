package com.varunbarad.feedsample.feed.list.viewholders

import com.varunbarad.feedsample.databinding.PostPhotoBinding
import com.varunbarad.feedsample.model.PhotoPost

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
class PhotoViewHolder(private val itemViewBinding: PostPhotoBinding) : BaseViewHolder(itemViewBinding.root) {
  fun bind(post: PhotoPost) {
    itemViewBinding.post = post
    itemViewBinding.executePendingBindings()
  }
}