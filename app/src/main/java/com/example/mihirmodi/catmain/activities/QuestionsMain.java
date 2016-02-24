package com.example.mihirmodi.catmain.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mihirmodi.catmain.adapters.AdapterQuestins;
import com.example.mihirmodi.catmain.adapters.CategoriesAdapter;
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

public class QuestionsMain extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterQuestins adapter;
    DatabaseHelper db=new DatabaseHelper(this);
    ArrayList<Questions>questionsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_main);

        assignView();
        //setup adapter
        setalldata();

        setupRecyclerView();
        setupAdapter();
    }

    private void setalldata() {
        questionsArrayList=db.getAllquestion();
    }





    private void setupAdapter() {
        adapter=new AdapterQuestins(this, questionsArrayList);
        recyclerView.setAdapter(adapter);
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void assignView() {
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view1);
    }


}

