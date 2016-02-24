package com.example.mihirmodi.catmain.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Categories;
import com.example.mihirmodi.catmain.models.Institute;
import com.example.mihirmodi.catmain.viewholders.CategoriesViewHolder;
import com.example.mihirmodi.catmain.viewholders.InstituteViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 23-01-2016.
 */
public class CategoriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Categories> categories;
    private Context mContext;
    LayoutInflater inflater;
    public CategoriesAdapter(Context context, ArrayList<Categories> categories) {
        this.categories = categories;
        this.mContext = context;
        inflater=LayoutInflater.from(context);
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView=inflater.inflate(R.layout.layoutcategories,parent,false);
        CategoriesViewHolder categoriesViewHolder=new CategoriesViewHolder(rootView,mContext);
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CategoriesViewHolder view=(CategoriesViewHolder)holder;
        view.bindInstitute(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}

