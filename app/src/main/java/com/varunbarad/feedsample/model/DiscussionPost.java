package com.varunbarad.feedsample.model;

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
public class DiscussionPost extends Post {
  public DiscussionPost(String eventId, String organiserId, String feedType, String info, int userId, User user, int commentCount, int likes) {
    super(eventId, organiserId, feedType, info, userId, user, commentCount, likes);
  }
  
  @Override
  public String toString() {
    return "Discussion Post";
  }
}
