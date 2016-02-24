package com.example.mihirmodi.catmain.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Categories;
import com.example.mihirmodi.catmain.models.Questions;
import com.example.mihirmodi.catmain.viewholders.CategoriesViewHolder;
import com.example.mihirmodi.catmain.viewholders.QuestionheaderViewHolder;

import java.util.ArrayList;

/**
 * Created by mmodi on 2/21/2016.
 */
public class AdapterQuestins extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Questions> questionsArrayList;
    private Context mContext;
    LayoutInflater inflater;


    public AdapterQuestins(Context context, ArrayList<Questions> questionsArrayList) {
        this.questionsArrayList = questionsArrayList;
        this.mContext = context;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView=inflater.inflate(R.layout.layoutquestionheadertext,parent,false);
        QuestionheaderViewHolder questionheaderViewHolder=new QuestionheaderViewHolder(rootView,mContext);
        return questionheaderViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        QuestionheaderViewHolder view=(QuestionheaderViewHolder)holder;
        view.bindInstitute(questionsArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return questionsArrayList.size();
    }
}

