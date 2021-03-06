

package com.example.mihirmodi.catmain.activities;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.mihirmodi.catmain.adapters.AdapterIntroductionScreen;
import com.example.mihirmodi.catmain.adapters.CategoriesAdapter;
import com.example.mihirmodi.catmain.models.Categories;
import com.example.mihirmodi.catmain.models.Institute;
import com.example.mihirmodi.catmain.adapters.AdapterInstitute;
import com.example.mihirmodi.catmain.adapters.QuizPlayerPagerAdapter;
import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Question;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.util.List;

public class QuizPlayer extends AppCompatActivity {

    public static String EXTRA_LAUNCH_POSITION="launchPosition";
    ViewPager viewPager;
    List<Question> questions;
    private DatabaseHelper db;
    QuizPlayerPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz_player);
        viewPager = (ViewPager) findViewById(R.id.pagerquizplayer);

        db = new DatabaseHelper(getApplicationContext());
        questions=db.getAllquestion();
        pagerAdapter=new QuizPlayerPagerAdapter(this,getSupportFragmentManager(),questions);
        viewPager.setAdapter(pagerAdapter);
        setToLaunchPosition();
    }
    /**
     * change page to requested index
     */
    private void setToLaunchPosition() {
        int position=getIntent().getIntExtra(EXTRA_LAUNCH_POSITION,-1);
        if(position!=-1){
            viewPager.setCurrentItem(position);
        }
    }
}

