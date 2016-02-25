package com.example.mihirmodi.catmain.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mihirmodi.catmain.adapters.OldQuestionAdapter;
import com.example.mihirmodi.catmain.adapters.QuestionRecyclerAdapter;
import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Question;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.util.ArrayList;

public class QuestionsMain extends AppCompatActivity {

    RecyclerView recyclerView;
    OldQuestionAdapter adapter;
    DatabaseHelper db=new DatabaseHelper(this);
    ArrayList<Question>questionsArrayList;
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
        adapter=new OldQuestionAdapter(this, questionsArrayList);
        recyclerView.setAdapter(adapter);
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void assignView() {
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view1);
    }


}

