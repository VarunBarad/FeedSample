package com.varunbarad.feedsample.feed

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Creator: Varun Barad
 * Date: 28-03-2018
 * Project: FeedSample
 */
class FeedCategoryAdapter(fragmentManager: FragmentManager?) : FragmentPagerAdapter(fragmentManager) {
  private var allPostsFragment: FeedFragment? = null
  private var photoPostsFragment: FeedFragment? = null
  private var linkPostsFragment: FeedFragment? = null
  private var videoPostsFragment: FeedFragment? = null
  private var introducePostsFragment: FeedFragment? = null

  override fun getItem(position: Int): Fragment = when (position) {
    0 -> {
      if (allPostsFragment == null) {
        allPostsFragment = FeedFragment.newInstance("ALL")
      }
      allPostsFragment!!
    }
    1 -> {
      if (photoPostsFragment == null) {
        photoPostsFragment = FeedFragment.newInstance("PHOTO")
      }
      photoPostsFragment!!
    }
    2 -> {
      if (linkPostsFragment == null) {
        linkPostsFragment = FeedFragment.newInstance("LINK")
      }
      linkPostsFragment!!
    }
    3 -> {
      if (videoPostsFragment == null) {
        videoPostsFragment = FeedFragment.newInstance("VIDEO")
      }
      videoPostsFragment!!
    }
    4 -> {
      if (introducePostsFragment == null) {
        introducePostsFragment = FeedFragment.newInstance("INTRODUCE")
      }
      introducePostsFragment!!
    }
    else -> {
      throw IllegalStateException("Only five tabs are supported. Tried to load tab number: ${position + 1}")
    }
  }

  override fun getCount(): Int = 5

  override fun getPageTitle(position: Int): CharSequence? = when (position) {
    0 -> "ALL"
    1 -> "PHOTO"
    2 -> "LINK"
    3 -> "VIDEO"
    4 -> "INTRODUCE"
    else -> "ERROR"
  }
}