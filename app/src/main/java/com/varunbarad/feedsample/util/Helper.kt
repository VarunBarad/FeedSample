@file:JvmName("Helper")

package com.varunbarad.feedsample.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.varunbarad.feedsample.R

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
fun openUrlInBrowser(context: Context, url: String) {
  val websiteUri = Uri.parse(url)
  val websiteIntent = Intent(Intent.ACTION_VIEW, websiteUri)
  if (websiteIntent.resolveActivity(context.packageManager) != null) {
    context.startActivity(websiteIntent)
  } else {
    Toast.makeText(context, R.string.message_noBrowser, Toast.LENGTH_SHORT).show()
  }
}