package com.varunbarad.feedsample.listener

/**
 * Creator: Varun Barad
 * Date: 30-03-2018
 * Project: FeedSample
 */
interface PostInteractionListener {
  fun pressLike(_id: String, position: Int)
  fun pressComment(_id: String, position: Int)
  fun pressShare(_id: String, position: Int)
  fun pressOpeions(_id: String, position: Int)
}