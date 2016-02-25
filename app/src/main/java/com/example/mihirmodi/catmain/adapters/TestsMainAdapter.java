package com.example.mihirmodi.catmain.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Categories;
import com.example.mihirmodi.catmain.models.Tests;
import com.example.mihirmodi.catmain.viewholders.CategoriesViewHolder;
import com.example.mihirmodi.catmain.viewholders.TestmainViewHolder;

import java.util.ArrayList;

/**
 * Created by mmodi on 2/24/2016.
 */
public class TestsMainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Tests> testses;
    private Context mContext;
    LayoutInflater inflater;
    public TestsMainAdapter(Context context,  ArrayList<Tests> testses) {
        this.testses = testses;
        this.mContext = context;
        inflater=LayoutInflater.from(context);
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView=inflater.inflate(R.layout.layouttestsmain,parent,false);
        TestmainViewHolder testmainViewHolder=new TestmainViewHolder(rootView,mContext);
        return testmainViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TestmainViewHolder view=(TestmainViewHolder)holder;
        view.bindInstitute(testses.get(position));
    }

    @Override
    public int getItemCount() {
        return testses.size();
    }
}

