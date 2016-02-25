package com.example.mihirmodi.catmain.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;

import com.example.mihirmodi.catmain.adapters.AdapterIntroductionScreen;
import com.example.mihirmodi.catmain.R;

public class IntroductionScreen extends FragmentActivity  {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.introduction);
        viewPager= (ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter=new AdapterIntroductionScreen(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);


    }

    public  void  skip(View v){

        Intent intent=new Intent(this,LogSignRedirect.class);
        startActivity(intent);
    }

    }
