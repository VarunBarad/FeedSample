package com.varunbarad.feedsample.remote;

import retrofit2.Retrofit;

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
public class FeedServiceHelper {
  public static final int eventId = 924;
  public static final int organiserId = 12945;
  public static final String selectedFeedType = "[\"PHOTO\",\"DISCUSSION\",\"INTRO\",\"VIDEO\",\"LINKS\",\"POLLS\"]";
  
  public static FeedService create() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://e825.demohubilo.com/")
        .build();
    return retrofit.create(FeedService.class);
  }
}
