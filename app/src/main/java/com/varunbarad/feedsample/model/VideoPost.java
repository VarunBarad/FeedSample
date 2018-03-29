package com.varunbarad.feedsample.model;

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
public class VideoPost extends Post {
  private String videoId;
  private String imageUrl;
  
  public VideoPost(String eventId, String organiserId, String feedType, String info, int userId, User user, int commentCount, int likes, String videoId, String imageUrl) {
    super(eventId, organiserId, feedType, info, userId, user, commentCount, likes);
    this.videoId = videoId;
    this.imageUrl = imageUrl;
  }
  
  public String getVideoId() {
    return videoId;
  }
  
  public void setVideoId(String videoId) {
    this.videoId = videoId;
  }
  
  public String getImageUrl() {
    return imageUrl;
  }
  
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
  
  @Override
  public String toString() {
    return "Video post";
  }
}
