package com.example.mihirmodi.catmain.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Institute;
import com.example.mihirmodi.catmain.viewholders.ImageViewHolder;

import java.util.List;

/**
 *
 */
public class AdapterImageView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
private List<Institute> iimImageslides;
private Context mContext;
        LayoutInflater inflater;
public AdapterImageView(Context context, List<Institute> iimImageslides) {
        this.iimImageslides = iimImageslides;
        this.mContext = context;
        inflater= LayoutInflater.from(context);
        }


@Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView=inflater.inflate(R.layout.layoutinstitutesection,parent,false);
        ImageViewHolder iVIewHolder=new ImageViewHolder(rootView,mContext);
        return iVIewHolder;
        }

@Override
public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ImageViewHolder viewHolder=(ImageViewHolder)holder;
        viewHolder.bindInstitute( iimImageslides.get(position));
        }

@Override
public int getItemCount() {
        return  iimImageslides.size();
        }
        }

