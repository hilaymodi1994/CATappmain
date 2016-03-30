package com.example.mihirmodi.catmain.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.example.mihirmodi.catmain.adapters.CategoriesAdapter;
import com.example.mihirmodi.catmain.adapters.TestsAdapter;
import com.example.mihirmodi.catmain.models.Categories;
import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Tests;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestList extends AppCompatActivity {

    RecyclerView recyclerView;
    TestsAdapter adapter;
    DatabaseHelper db=new DatabaseHelper(this);
    ArrayList<Tests>testses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_test_list);

        assignView();
        //setup adapter
        setalldata();

        setupRecyclerView();
        setupAdapter();
    }

    private void setalldata (){
        testses=db.getAlltest();
    }





    private void setupAdapter() {
        adapter=new TestsAdapter(this, testses);
        recyclerView.setAdapter(adapter);
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void assignView() {
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view1);
    }


}
