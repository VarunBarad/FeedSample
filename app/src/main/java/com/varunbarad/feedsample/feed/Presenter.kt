package com.varunbarad.feedsample.feed

import android.util.Log
import com.varunbarad.feedsample.remote.FeedServiceHelper
import com.varunbarad.feedsample.remote.parsePosts
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
class Presenter(override val view: FeedView, override val category: String) : FeedPresenter {
  override fun loadPostsFromNetwork(currentPage: Int) {
    val service = FeedServiceHelper
        .create()

    val retrofitCallback = object : Callback<ResponseBody> {
      override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
        if (response != null) {
          val postsResponse = JSONObject(response.body()?.string()).getJSONObject("data")

          view.showPosts(
              parsePosts(postsResponse.getJSONArray("feeds")),
              postsResponse.getInt("current_page"),
              postsResponse.getInt("totalPages")
          )
        } else {
          Log.e("SERVICE", "Response was null")
          view.showError()
        }
      }

      override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
        Log.e("NETWORK", t?.message)
      }

    }

    when (category) {
      "ALL" -> service.getAllPosts(currentPage).enqueue(retrofitCallback)
      "PHOTO" -> service.getPhotoPosts(currentPage).enqueue(retrofitCallback)
      "LINK" -> service.getLinkPosts(currentPage).enqueue(retrofitCallback)
      "VIDEO" -> service.getVideoPosts(currentPage).enqueue(retrofitCallback)
      "INTRODUCE" -> service.getIntroPosts(currentPage).enqueue(retrofitCallback)
    }
  }
}