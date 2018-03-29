package com.varunbarad.feedsample.remote

import com.varunbarad.feedsample.BuildConfig
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
interface FeedService {
  @Headers("device_type: WEB")
  @FormUrlEncoded
  @POST("/api/event/paginate/feeds")
  fun getAllPosts(
      @Field("current_page") currentPage: Int = 0,
      @Header("event_id") eventId: Int = FeedServiceHelper.eventId,
      @Header("organiser_id") organiserId: Int = FeedServiceHelper.organiserId,
      @Field("selectedFeedType") selectedFeedType: String = FeedServiceHelper.selectedFeedType,
      @Header("access_token") accessToken: String = BuildConfig.FeedServiceAccessToken,
      @Field("feedType") feedType: String = "ALL"
  ): Call<ResponseBody>

  @Headers("device_type: WEB")
  @FormUrlEncoded
  @POST("/api/event/paginate/feeds")
  fun getPhotoPosts(
      @Field("current_page") currentPage: Int = 0,
      @Header("event_id") eventId: Int = FeedServiceHelper.eventId,
      @Header("organiser_id") organiserId: Int = FeedServiceHelper.organiserId,
      @Field("selectedFeedType") selectedFeedType: String = FeedServiceHelper.selectedFeedType,
      @Header("access_token") accessToken: String = BuildConfig.FeedServiceAccessToken,
      @Field("feedType") feedType: String = "PHOTO"
  ): Call<ResponseBody>

  @Headers("device_type: WEB")
  @FormUrlEncoded
  @POST("/api/event/paginate/feeds")
  fun getVideoPosts(
      @Field("current_page") currentPage: Int = 0,
      @Header("event_id") eventId: Int = FeedServiceHelper.eventId,
      @Header("organiser_id") organiserId: Int = FeedServiceHelper.organiserId,
      @Field("selectedFeedType") selectedFeedType: String = FeedServiceHelper.selectedFeedType,
      @Header("access_token") accessToken: String = BuildConfig.FeedServiceAccessToken,
      @Field("feedType") feedType: String = "VIDEO"
  ): Call<ResponseBody>

  @Headers("device_type: WEB")
  @FormUrlEncoded
  @POST("/api/event/paginate/feeds")
  fun getLinkPosts(
      @Field("current_page") currentPage: Int = 0,
      @Header("event_id") eventId: Int = FeedServiceHelper.eventId,
      @Header("organiser_id") organiserId: Int = FeedServiceHelper.organiserId,
      @Field("selectedFeedType") selectedFeedType: String = FeedServiceHelper.selectedFeedType,
      @Header("access_token") accessToken: String = BuildConfig.FeedServiceAccessToken,
      @Field("feedType") feedType: String = "LINKS"
  ): Call<ResponseBody>

  @Headers("device_type: WEB")
  @FormUrlEncoded
  @POST("/api/event/paginate/feeds")
  fun getIntroPosts(
      @Field("current_page") currentPage: Int = 0,
      @Header("event_id") eventId: Int = FeedServiceHelper.eventId,
      @Header("organiser_id") organiserId: Int = FeedServiceHelper.organiserId,
      @Field("selectedFeedType") selectedFeedType: String = FeedServiceHelper.selectedFeedType,
      @Header("access_token") accessToken: String = BuildConfig.FeedServiceAccessToken,
      @Field("feedType") feedType: String = "INTRO"
  ): Call<ResponseBody>
}