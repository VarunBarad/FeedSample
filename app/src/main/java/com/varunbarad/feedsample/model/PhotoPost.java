package com.varunbarad.feedsample.model;

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
public class PhotoPost extends Post {
  private ImageStub image;
  
  public PhotoPost(String eventId, String organiserId, String feedType, String info, int userId, User user, int commentCount, int likes, ImageStub image) {
    super(eventId, organiserId, feedType, info, userId, user, commentCount, likes);
    this.image = image;
  }
  
  public ImageStub getImage() {
    return image;
  }
  
  public void setImage(ImageStub image) {
    this.image = image;
  }
  
  @Override
  public String toString() {
    return "Photo post";
  }
}
