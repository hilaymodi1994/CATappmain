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
import com.example.mihirmodi.catmain.adapters.CategoriesAdapter;
import com.example.mihirmodi.catmain.adapters.TestsMainAdapter;
import com.example.mihirmodi.catmain.models.Categories;
import com.example.mihirmodi.catmain.models.Tests;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Testsmain extends AppCompatActivity {

    RecyclerView recyclerView;
    TestsMainAdapter adapter;
    DatabaseHelper db=new DatabaseHelper(this);
    ArrayList<Tests> testses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_testsmain);

        assignView();
        //setup adapter
        setalldata();


        setupRecyclerView();
        setupAdapter();
    }

    private void setalldata (){
        testses=db.getAlltests();
    }





    private void setupAdapter() {
        adapter=new TestsMainAdapter(this, testses);
        recyclerView.setAdapter(adapter);
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void assignView() {
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view1);
    }


}
