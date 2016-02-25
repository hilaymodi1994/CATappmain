package com.example.mihirmodi.catmain.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.mihirmodi.catmain.utils.DatabaseHelper;
import com.example.mihirmodi.catmain.R;

public class SplashScreen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);
        final DatabaseHelper db = new DatabaseHelper(this);
        ImageView i=(ImageView)findViewById(R.id.imageView);
        Animation ani= AnimationUtils.loadAnimation(getBaseContext(),R.anim.anim);
        i.startAnimation(ani);
        ani.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Log.d("SplashScreen","on animation end");
                try {
                    db.createDataBase();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent=new Intent(SplashScreen.this,IntroductionScreen.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}


