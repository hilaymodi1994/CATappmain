package com.example.mihirmodi.catmain.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.adapters.QuestionRecyclerAdapter;
import com.example.mihirmodi.catmain.models.IWRecyclerItem;
import com.example.mihirmodi.catmain.models.Options;
import com.example.mihirmodi.catmain.models.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * This will have recyclerview which contains header, options of perticular question
 */
public class QuestionFragment extends Fragment {
    int flag;
    int Score;
    RecyclerView recyclerView;
    Question question;
    QuestionRecyclerAdapter recyclerAdapter;
    List<IWRecyclerItem> recyclerItems;
    public QuestionFragment() {
        // Required empty public constructor
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
public int getFlag(){return  Score;}
    public void setFlag(int flag){this.flag=flag;}
    public int getScore(){return Score ;}
    public void setScore(int Score){this.Score=Score;}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_question, container, false);
        recyclerView=(RecyclerView)rootView.findViewById(R.id.recyclerView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        prepareRecyclerViewAndAdapter();
        if(question!=null){
            loadQuestion();
        }
    }

    private void loadQuestion() {
        recyclerItems.add(new IWRecyclerItem(IWRecyclerItem.TYPE.QUESTION_HEADER, question));
        recyclerAdapter.notifyItemInserted(recyclerItems.size()-1);
        for(Options options:question.getOptionsList()){
            recyclerItems.add(new IWRecyclerItem(IWRecyclerItem.TYPE.QUESTION_OPTION, options));
            recyclerAdapter.notifyItemInserted(recyclerItems.size()-1);
        }

    }

    private void prepareRecyclerViewAndAdapter() {
        recyclerItems=new ArrayList<>();
        recyclerAdapter=new QuestionRecyclerAdapter(getActivity(),recyclerItems,getFlag(),getScore());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerAdapter);
    }
}