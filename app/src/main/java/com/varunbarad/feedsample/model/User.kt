package com.varunbarad.feedsample.model

import com.google.gson.annotations.SerializedName

/**
 * Creator: Varun Barad
 * Date: 28-03-2018
 * Project: FeedSample
 */
data class User(
    val firstName: String = "",
    val lastName: String = "",
    val about: String = "",
    val designation: String = "",
    val profilePictures: ProfilePictures,
    @SerializedName("user_id") val userId: String = ""
)

data class ProfilePictures(
    val thumbnail: String = "",
    /*orignal*/val original: String = ""
)