

package com.example.mihirmodi.catmain.activities;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.example.mihirmodi.catmain.adapters.AdapterIntroductionScreen;
import com.example.mihirmodi.catmain.adapters.AdapterQuestins;
import com.example.mihirmodi.catmain.adapters.CategoriesAdapter;
import com.example.mihirmodi.catmain.adapters.QuizplayerAdapter;
import com.example.mihirmodi.catmain.models.Categories;
import com.example.mihirmodi.catmain.models.Institute;
import com.example.mihirmodi.catmain.adapters.AdapterInstitute;
import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Questions;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuizPlayer extends AppCompatActivity {


    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz_player);
        viewPager = (ViewPager) findViewById(R.id.pagerquizplayer);
       // PagerAdapter pagerAdapter = new QuizplayerAdapter(getSupportFragmentManager());
        //viewPager.setAdapter(pagerAdapter);

    }
}

