package com.varunbarad.feedsample.feed

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.varunbarad.feedsample.R
import com.varunbarad.feedsample.databinding.ActivityFeedBinding
import com.varunbarad.feedsample.listener.FragmentInteractionListener

class FeedActivity : AppCompatActivity(), FragmentInteractionListener {
  private lateinit var dataBinding: ActivityFeedBinding
  private lateinit var pagerAdapter: FeedCategoryAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    this.dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_feed)
    this.setupActivity()
  }

  private fun setupActivity() {
    this.setSupportActionBar(dataBinding.toolbar)

    this.pagerAdapter = FeedCategoryAdapter(this.supportFragmentManager)
    dataBinding.viewPager.adapter = pagerAdapter
    dataBinding.tabs.setupWithViewPager(dataBinding.viewPager)
  }

  override fun onFragmentInteraction(data: String) {
    Toast.makeText(this, "Interaction from fragment: $data", Toast.LENGTH_LONG).show()
  }
}
