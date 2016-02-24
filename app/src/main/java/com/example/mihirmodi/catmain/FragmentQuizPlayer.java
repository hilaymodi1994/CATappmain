package com.example.mihirmodi.catmain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.adapters.AdapterQuestins;
import com.example.mihirmodi.catmain.models.Questions;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.util.ArrayList;


public class FragmentQuizPlayer extends Fragment {
    RecyclerView recyclerView;
    AdapterQuestins adapter;
    private DatabaseHelper db;
    ArrayList<Questions> questionsArrayList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_quiz_player,container,false);

        recyclerView=(RecyclerView) rootView.findViewById(R.id.recycler_view1);
        db=new DatabaseHelper(getActivity());
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        questionsArrayList=db.getAllquestion();
        recyclerView.setLayoutManager(layoutManager);
        adapter=new AdapterQuestins(getActivity(), questionsArrayList);
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}
