package com.varunbarad.feedsample.feed.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.varunbarad.feedsample.databinding.*
import com.varunbarad.feedsample.feed.list.viewholders.*
import com.varunbarad.feedsample.model.*

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
class PostsAdapter(val posts: MutableList<Post> = mutableListOf()) : RecyclerView.Adapter<BaseViewHolder>() {
  fun addPosts(posts: MutableList<Post>) {
    val insertionPosition = itemCount - 1
    this.posts.addAll(posts)
    this.notifyItemRangeInserted(insertionPosition, posts.size)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
    return when (viewType) {
      LAYOUT_FOOTER -> FooterViewHolder(PostFooterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
      LAYOUT_NORMAL -> NormalViewHolder(PostNormalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
      LAYOUT_PHOTO -> PhotoViewHolder(PostPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
      LAYOUT_LINK -> LinkViewHolder(PostLinkBinding.inflate(LayoutInflater.from(parent.context), parent, false))
      LAYOUT_VIDEO -> VideoViewHolder(PostVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
      LAYOUT_INTRO -> IntroViewHolder(PostIntroBinding.inflate(LayoutInflater.from(parent.context), parent, false))
      LAYOUT_DISCUSSION -> DiscussionViewHolder(PostDiscussionBinding.inflate(LayoutInflater.from(parent.context), parent, false))
      else -> NormalViewHolder(PostNormalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
  }

  override fun getItemCount(): Int = (posts.size + 1)

  override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
    if (position == (itemCount - 1)) {
      (holder as FooterViewHolder).bind()
    } else {
      when (posts[position].feedType) {
        "PHOTO" -> (holder as PhotoViewHolder).bind(posts[position] as PhotoPost)
        "VIDEO" -> (holder as VideoViewHolder).bind(posts[position] as VideoPost)
        "LINKS" -> (holder as LinkViewHolder).bind(posts[position] as LinkPost)
        "DISCUSSION" -> (holder as DiscussionViewHolder).bind(posts[position] as DiscussionPost)
        "INTRO" -> (holder as IntroViewHolder).bind(posts[position] as IntroPost)
        else -> (holder as NormalViewHolder).bind(posts[position])
      }
    }
  }

  override fun getItemViewType(position: Int): Int {
    return if (position == itemCount - 1) {
      LAYOUT_FOOTER
    } else {
      when (posts[position].feedType) {
        "PHOTO" -> LAYOUT_PHOTO
        "VIDEO" -> LAYOUT_VIDEO
        "INTRO" -> LAYOUT_INTRO
        "LINKS" -> LAYOUT_LINK
        "DISCUSSION" -> LAYOUT_DISCUSSION
        else -> LAYOUT_NORMAL
      }
    }
  }

  companion object {
    private const val LAYOUT_FOOTER = 0
    private const val LAYOUT_NORMAL = 1
    private const val LAYOUT_PHOTO = 2
    private const val LAYOUT_LINK = 3
    private const val LAYOUT_VIDEO = 4
    private const val LAYOUT_INTRO = 5
    private const val LAYOUT_DISCUSSION = 6
  }
}