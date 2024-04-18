package com.example.co_labconnect;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.security.AccessControlContext;

import de.hdodenhof.circleimageview.CircleImageView;

public class util {

    public static void setProfilePic(Context context, Uri imageUri,CircleImageView imageView){
        Glide.with(context).load(imageUri).apply(RequestOptions.circleCropTransform()).into(imageView);
    }

}
