package com.example.mihirmodi.catmain.adapters;

import android.content.ClipData;
import android.content.Context;
import android.preference.PreferenceActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.mihirmodi.catmain.FragmentQuizPlayer;
import com.example.mihirmodi.catmain.activities.IntroductionScreenFragment1;
import com.example.mihirmodi.catmain.activities.IntroductionScreenFragment2;
import com.example.mihirmodi.catmain.activities.IntroductionScreenFragment3;
import com.example.mihirmodi.catmain.activities.IntroductionScreenFragment4;
import com.example.mihirmodi.catmain.activities.QuizPlayer;
import com.example.mihirmodi.catmain.models.Questions;
import com.example.mihirmodi.catmain.models.RecyclerItem;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.util.ArrayList;

/**
 * Created by mmodi on 2/23/2016.
 */
public class QuizplayerAdapter  extends FragmentPagerAdapter {
    ArrayList<Questions> questionsArrayList;
    private DatabaseHelper db;
    Context context;
    public QuizplayerAdapter(FragmentManager fm, ArrayList<Questions> questionsArrayList){
        super(fm);
        this.questionsArrayList = questionsArrayList;
        this.context=context;
        db=new DatabaseHelper(context.getApplicationContext());
        RecyclerView recyclerView;

    }

    @Override
    public Fragment getItem(int position) {
        questionsArrayList=db.getAllquestion();
        Questions questions = questionsArrayList.get(position);


                FragmentQuizPlayer questionFragment = new FragmentQuizPlayer();
                return questionFragment;

    }

    @Override
    public int getCount() {
        return 1;
    }


}

