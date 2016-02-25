package com.example.mihirmodi.catmain.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.IWRecyclerItem;
import com.example.mihirmodi.catmain.models.Question;
import com.example.mihirmodi.catmain.viewholders.QuestionHeaderViewHolder;

import java.util.List;

/**
 * Created by mmodi on 2/21/2016.
 */
public class QuestionRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<IWRecyclerItem> recyclerItems;
    private Context mContext;
    LayoutInflater inflater;
    final static int TYPE_HEADER = 0, TYPE_OPTION = 1;


    public QuestionRecyclerAdapter(Context context, List<IWRecyclerItem> recyclerItems) {
        this.recyclerItems = recyclerItems;
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView;
        switch (viewType) {
            case TYPE_HEADER:
                rootView = inflater.inflate(R.layout.layoutquestionheadertext, parent, false);
                QuestionHeaderViewHolder questionHeaderViewHolder = new QuestionHeaderViewHolder(rootView, mContext);
                return questionHeaderViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case TYPE_HEADER:
                QuestionHeaderViewHolder view = (QuestionHeaderViewHolder) holder;
                view.bindQuestionHeaderText((Question) recyclerItems.get(position).getItem());
                break;
        }

    }

    @Override
    public int getItemCount() {
        return recyclerItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (recyclerItems.get(position).getItemType()) {

            case QUESTION_HEADER:
                return TYPE_HEADER;
            case QUESTION_OPTION:
                return TYPE_OPTION;
        }
        return 0;
    }
}

