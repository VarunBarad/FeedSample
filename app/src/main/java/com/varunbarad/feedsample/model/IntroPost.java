package com.varunbarad.feedsample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
public class IntroPost extends Post {
  @SerializedName("intro_type")
  private String introType;
  
  public IntroPost(String eventId, String organiserId, String feedType, String info, int userId, User user, int commentCount, int likes, String introType, String _id) {
    super(_id, eventId, organiserId, feedType, info, userId, user, commentCount, likes);
    this.introType = introType;
  }
  
  public String getIntroType() {
    return introType;
  }
  
  public void setIntroType(String introType) {
    this.introType = introType;
  }
  
  @Override
  public String toString() {
    return "Intro Post";
  }
}
