package com.varunbarad.feedsample.util;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.varunbarad.feedsample.R;
import com.varunbarad.feedsample.remote.FeedServiceHelper;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Creator: Varun Barad
 * Date: 29-03-2018
 * Project: FeedSample
 */
public final class DataBindingUtils {
  @BindingAdapter({"bind:profileImageUrl"})
  public static void loadProfileImage(ImageView view, String imageUrl) {
    Picasso
        .with(view.getContext())
        .load(DataBindingUtils.getProfileThumbnailUrl(imageUrl))
        .error(R.drawable.ic_profile)
        .placeholder(R.drawable.ic_profile)
        .transform(new CropCircleTransformation())
        .into(view);
  }
  
  @BindingAdapter({"bind:imageUrl"})
  public static void loadImage(ImageView view, String imageUrl) {
    Picasso
        .with(view.getContext())
        .load(DataBindingUtils.getImageUrl(imageUrl))
        .error(R.drawable.ic_cloud_off)
        .into(view);
  }
  
  @BindingAdapter({"bind:webUrl"})
  public static void openUrl(View view, final String webUrl) {
    view.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Helper.openUrlInBrowser(view.getContext(), webUrl);
      }
    });
  }
  
  public static String getProfileThumbnailUrl(String imageId) {
    return "https://d28hsb6vkzynsw.cloudfront.net/profile/thumb/" + imageId;
  }
  
  public static String getImageUrl(String imageId) {
    return "https://d28hsb6vkzynsw.cloudfront.net/feed/" + FeedServiceHelper.eventId + "/" + imageId;
  }
}
