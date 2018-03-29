package com.varunbarad.feedsample.remote

import com.google.gson.GsonBuilder
import com.varunbarad.feedsample.model.*
import org.json.JSONArray

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
fun parsePosts(responsePosts: JSONArray): List<Post> {
  val gson = GsonBuilder().create()

  val posts = mutableListOf<Post>()
  for (i in 0 until responsePosts.length()) {
    val element = responsePosts.getJSONObject(i)
    when (element.getString("feedType")) {
      "PHOTO" -> posts.add(gson.fromJson(element.toString(), PhotoPost::class.java))
      "LINK" -> posts.add(gson.fromJson(element.toString(), LinkPost::class.java))
      "VIDEO" -> posts.add(gson.fromJson(element.toString(), VideoPost::class.java))
      "INTRO" -> posts.add(gson.fromJson(element.toString(), IntroPost::class.java))
      "DISCUSSION" -> posts.add(gson.fromJson(element.toString(), DiscussionPost::class.java))
      else -> posts.add(gson.fromJson(element.toString(), Post::class.java))
    }
  }
  return posts
}