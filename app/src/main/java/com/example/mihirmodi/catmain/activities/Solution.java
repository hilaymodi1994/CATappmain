package com.example.mihirmodi.catmain.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.adapters.OldQuestionAdapter;
import com.example.mihirmodi.catmain.adapters.SolutionAdapter;
import com.example.mihirmodi.catmain.models.Question;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.util.ArrayList;

public class Solution extends AppCompatActivity {

    RecyclerView recyclerView;
    SolutionAdapter adapter;
    DatabaseHelper db=new DatabaseHelper(this);
    ArrayList<Question> questionsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_solution);

        assignView();
        //setup adapter
        setalldata();

        setupRecyclerView();
        setupAdapter();
    }

    private void setalldata() {
        questionsArrayList=db.getAllQuestionsFilledWithOptions();
    }

    private void setupAdapter() {
        adapter=new SolutionAdapter(this, questionsArrayList);
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
