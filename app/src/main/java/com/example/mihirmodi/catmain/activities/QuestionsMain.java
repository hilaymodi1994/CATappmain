package com.example.mihirmodi.catmain.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.example.mihirmodi.catmain.adapters.OldQuestionAdapter;
import com.example.mihirmodi.catmain.adapters.QuestionRecyclerAdapter;
import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Question;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.util.ArrayList;

public class QuestionsMain extends AppCompatActivity {

    RecyclerView recyclerView;
    OldQuestionAdapter adapter;
    DatabaseHelper db=new DatabaseHelper(this);
    ArrayList<Question>questionsArrayList;
    String cid;
    int phn;
    int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_questions_main);


        assignView();
        //setup adapter
        setalldata();

        setupRecyclerView();
        setupAdapter();
    }

    private void setalldata() {
        Bundle b = getIntent().getExtras();
        phn= b.getInt("phn");
        cid=b.getString("phn");
        flag=0;
        questionsArrayList= db.getQuestionforcategories(phn);
    }

    private void setupAdapter() {
        adapter=new OldQuestionAdapter(this, questionsArrayList,phn,flag);
        recyclerView.setAdapter(adapter);
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void assignView() {

// To dismiss the dialog

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view1);

    }


}
