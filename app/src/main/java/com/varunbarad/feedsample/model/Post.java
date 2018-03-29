package com.varunbarad.feedsample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
public class Post {
  private String _id;
  @SerializedName("event_id")
  private String eventId;
  @SerializedName("organiser_id")
  private String organiserId;
  private String feedType;
  private String info;
  @SerializedName("user_id")
  private int userId;
  @SerializedName("userId")
  private User user;
  private int commentCount;
  private int likes;
  
  public Post(String _id, String eventId, String organiserId, String feedType, String info, int userId, User user, int commentCount, int likes) {
    _id = _id;
    this.eventId = eventId;
    this.organiserId = organiserId;
    this.feedType = feedType;
    this.info = info;
    this.userId = userId;
    this.user = user;
    this.commentCount = commentCount;
    this.likes = likes;
  }
  
  public String getEventId() {
    return eventId;
  }
  
  public void setEventId(String eventId) {
    this.eventId = eventId;
  }
  
  public String getOrganiserId() {
    return organiserId;
  }
  
  public void setOrganiserId(String organiserId) {
    this.organiserId = organiserId;
  }
  
  public String getFeedType() {
    return feedType;
  }
  
  public void setFeedType(String feedType) {
    this.feedType = feedType;
  }
  
  public String getInfo() {
    return info;
  }
  
  public void setInfo(String info) {
    this.info = info;
  }
  
  public int getUserId() {
    return userId;
  }
  
  public void setUserId(int userId) {
    this.userId = userId;
  }
  
  public User getUser() {
    return user;
  }
  
  public void setUser(User user) {
    this.user = user;
  }
  
  public int getCommentCount() {
    return commentCount;
  }
  
  public void setCommentCount(int commentCount) {
    this.commentCount = commentCount;
  }
  
  public int getLikes() {
    return likes;
  }
  
  public void setLikes(int likes) {
    this.likes = likes;
  }
  
  @Override
  public String toString() {
    return "Default post";
  }
  
  public String get_id() {
    return _id;
  }
  
  public void set_id(String _id) {
    this._id = _id;
  }
}
