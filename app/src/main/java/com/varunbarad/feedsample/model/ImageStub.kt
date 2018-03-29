package com.varunbarad.feedsample.model

import com.google.gson.annotations.SerializedName

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
data class ImageStub(
    val height: Int,
    val width: Int,
    @SerializedName("thumb") val thumbnail: String,
    @SerializedName("orignal") val original: String
)