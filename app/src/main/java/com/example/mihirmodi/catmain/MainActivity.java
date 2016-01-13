package com.example.mihirmodi.catmain;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity  {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager= (ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter=new pageadapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);


    }

    public  void  skip(View v){
        Toast.makeText(this, "hiii", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,loginActivity.class);
        startActivity(intent);
    }

    }
