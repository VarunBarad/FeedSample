package com.varunbarad.feedsample.feed

import com.varunbarad.feedsample.model.Post

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
interface FeedPresenter {
  val view: FeedView
  val category: String

  fun loadPostsFromNetwork(currentPage: Int = 0)
}

interface FeedView {
  var presenter: FeedPresenter

  fun showPosts(posts: MutableList<Post>, currentPage: Int, totalPages: Int)
  fun showError()
  fun showProgress()
}