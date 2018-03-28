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
  override fun getItem(position: Int): Fragment = when (position) {
    0 -> FeedFragment.newInstance("All")
    1 -> FeedFragment.newInstance("Photo")
    2 -> FeedFragment.newInstance("Link")
    3 -> FeedFragment.newInstance("Video")
    4 -> FeedFragment.newInstance("Introduce")
    else -> FeedFragment.newInstance("Error")
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