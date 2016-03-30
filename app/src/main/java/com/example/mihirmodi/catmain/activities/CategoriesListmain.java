package com.example.mihirmodi.catmain.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.example.mihirmodi.catmain.adapters.CategoriesAdapter;
import com.example.mihirmodi.catmain.models.Category;
import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CategoriesListmain extends AppCompatActivity {

    RecyclerView recyclerView;
    CategoriesAdapter adapter;
    DatabaseHelper db=new DatabaseHelper(this);
    ArrayList<Category>categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_categories_listmain);

        assignView();
        //setup adapter
        setalldata();
        Collections.sort(categories, new Comparator<Category>() {

    /* This comparator will sort AppDetail objects alphabetically. */

            @Override
            public int compare(Category c1, Category c2) {

                // String implements Comparable
                return (c1.getName().toString()).compareTo(c2.getName().toString());
            }
        });
        setupRecyclerView();
        setupAdapter();
    }

    private void setalldata (){
        categories=db.getAlldata();

    }





    private void setupAdapter() {
        adapter=new CategoriesAdapter(this, categories);
        recyclerView.setAdapter(adapter);
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void assignView() {
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view1);
    }


}
