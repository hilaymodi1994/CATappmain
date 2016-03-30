package com.example.mihirmodi.catmain.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Question;
import com.example.mihirmodi.catmain.viewholders.QuestionHeaderViewHolder;
import com.example.mihirmodi.catmain.viewholders.SolutionViewHolder;

import java.util.ArrayList;

/**
 * Created by mmodi on 3/8/2016.
 */
public class SolutionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Question> questionsArrayList;
    private Context mContext;
    LayoutInflater inflater;


    public SolutionAdapter(Context context, ArrayList<Question> questionsArrayList) {
        this.questionsArrayList = questionsArrayList;
        this.mContext = context;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView=inflater.inflate(R.layout.layout_solution,parent,false);
        SolutionViewHolder questionheaderViewHolder=new SolutionViewHolder(rootView,mContext);
        return questionheaderViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SolutionViewHolder view=(SolutionViewHolder)holder;
        view.bindQuestionWithClick(questionsArrayList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return questionsArrayList.size();
    }
}
