package com.example.mihirmodi.catmain.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Institute;
import com.example.mihirmodi.catmain.viewholders.InstituteViewHolder;

import java.util.List;

/**
 * Created by lenovo on 23-01-2016.
 */
public class AdapterInstitute extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Institute> institutes;
    private Context mContext;
    LayoutInflater inflater;
    public AdapterInstitute(Context context, List<Institute> institutes) {
        this.institutes = institutes;
        this.mContext = context;
        inflater=LayoutInflater.from(context);
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView=inflater.inflate(R.layout.layoutinstitutemenu,parent,false);
        InstituteViewHolder iVIewHolder=new InstituteViewHolder(rootView,mContext);
        return iVIewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        InstituteViewHolder view=(InstituteViewHolder)holder;
        view.bindInstitute(institutes.get(position));
    }

    @Override
    public int getItemCount() {
        return institutes.size();
    }
}
