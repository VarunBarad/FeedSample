package com.varunbarad.feedsample.model;

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
public class LinkPost extends Post {
  private String url;
  private String title;
  private String description;
  private String imageUrl;
  
  public LinkPost(String eventId, String organiserId, String feedType, String info, int userId, User user, int commentCount, int likes, String url, String title, String description, String imageUrl, String _id) {
    super(_id, eventId, organiserId, feedType, info, userId, user, commentCount, likes);
    this.url = url;
    this.title = title;
    this.description = description;
    this.imageUrl = imageUrl;
  }
  
  public String getUrl() {
    return url;
  }
  
  public void setUrl(String url) {
    this.url = url;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public String getImageUrl() {
    return imageUrl;
  }
  
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
  
  @Override
  public String toString() {
    return "Videos post";
  }
}
