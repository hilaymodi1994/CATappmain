package com.example.mihirmodi.catmain.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.mihirmodi.catmain.activities.QuestionFragment;
import com.example.mihirmodi.catmain.models.Question;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.util.List;

/**
 * Created by mmodi on 2/23/2016.
 */
public class QuizPlayerPagerAdapter extends FragmentPagerAdapter {
    List<Question> questionsArrayList;
    private DatabaseHelper db;
    Context context;

    public QuizPlayerPagerAdapter(Context context,FragmentManager fm, List<Question> questionsList) {
        super(fm);
        this.questionsArrayList = questionsList;
        this.context = context;
        db = new DatabaseHelper(context.getApplicationContext());
        RecyclerView recyclerView;
    }

    @Override
    public Fragment getItem(int position) {
        Question question = questionsArrayList.get(position);
        QuestionFragment questionFragment = new QuestionFragment();
        questionFragment.setQuestion(question);
        return questionFragment;

    }

    @Override
    public int getCount() {
        return questionsArrayList.size();
    }


}

