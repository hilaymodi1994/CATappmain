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
import com.example.mihirmodi.catmain.viewholders.TestsViewHolder;

import java.util.ArrayList;

/**
 * Created by mmodi on 3/1/2016.
 */
public class TestsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Tests> testses;
    private Context mContext;
    LayoutInflater inflater;
    public TestsAdapter(Context context, ArrayList<Tests> testses) {
        this.testses = testses;
        this.mContext = context;
        inflater=LayoutInflater.from(context);
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView=inflater.inflate(R.layout.layout_test_list,parent,false);
        TestsViewHolder testsViewHolder=new TestsViewHolder(rootView,mContext);
        return testsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TestsViewHolder view=(TestsViewHolder)holder;
        view.bindInstitute(testses.get(position));
    }

    @Override
    public int getItemCount() {
        return testses.size();
    }
}

