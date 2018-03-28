package com.varunbarad.feedsample.feed

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.varunbarad.feedsample.R
import com.varunbarad.feedsample.databinding.ActivityFeedBinding

class FeedActivity : AppCompatActivity() {
  private lateinit var dataBinding: ActivityFeedBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    this.dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_feed)
    this.setupActivity()
  }

  private fun setupActivity() {
    this.setSupportActionBar(dataBinding.toolbar)
  }
}
