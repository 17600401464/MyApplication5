package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by lenovo on 2017/9/5.
 */

public class Myactivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ji);
        CircularImage cover_user_photo = (CircularImage) findViewById(R.id.cover_user_photo);
      cover_user_photo.setImageResource(R.drawable.qq);
    }
}
