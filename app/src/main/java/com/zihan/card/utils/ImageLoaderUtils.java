package com.zihan.card.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.zihan.card.R;

/**
 * Created by jilibing on 2016/6/22/0022.
 */
public class ImageLoaderUtils {

    public interface OnLoadComplete {
        public void loadComplete();
    }

    public static void display(ImageView imageView, String url, final OnLoadComplete onLoadComplete) {
        Glide
                .with(imageView.getContext())
                .load(url)
                .centerCrop()
                .error(getErrorHolder())
                .placeholder(getPlaceHolder())
                .into(new GlideDrawableImageViewTarget(imageView){
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                        super.onResourceReady(resource, animation);

                        onLoadComplete.loadComplete();
                    }
                });
    }

    public static void display(ImageView imageView, String url) {
        Glide
                .with(imageView.getContext())
                .load(url)
                .centerCrop()
                .error(getErrorHolder())
                .placeholder(getPlaceHolder())
                .into(imageView);
    }

    private static int getErrorHolder() {
        return R.mipmap.ic_launcher;
    }

    private static int getPlaceHolder() {
        return R.mipmap.ic_launcher;
    }
}
