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
import com.example.mihirmodi.catmain.adapters.SolutionAdapter;
import com.example.mihirmodi.catmain.adapters.TestmainAdapter;
import com.example.mihirmodi.catmain.models.Question;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.util.ArrayList;

public class TestMain extends AppCompatActivity {

    RecyclerView recyclerView;
    TestmainAdapter adapter;
    DatabaseHelper db=new DatabaseHelper(this);
    ArrayList<Question> questionsArrayList;
    int phn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_test_main);

        assignView();
        //setup adapter
        setalldata();

        setupRecyclerView();
        setupAdapter();
    }

    private void setalldata()
    {Bundle a = getIntent().getExtras();
        phn= a.getInt("phn");
        questionsArrayList=db.getTestfromtestlist(phn);
    }

    private void setupAdapter() {
        adapter=new TestmainAdapter(this, questionsArrayList);
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
