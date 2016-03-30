package com.example.mihirmodi.catmain.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.example.mihirmodi.catmain.models.Institute;
import com.example.mihirmodi.catmain.adapters.AdapterInstitute;
import com.example.mihirmodi.catmain.R;

import java.util.List;

public class InstituteView extends AppCompatActivity {
    public static final String FILTER_INST="filteration";
    public static final String FILTER_IIM="iims";
    public static final String FILTER_NON_IIM="non-iims";
    public static final String FILTER_ALL="showAll";
    RecyclerView recyclerView;
    AdapterInstitute adapter;
    private List<Institute> filteredInsts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.instituteview);

        assignView();
        //setup adapter
        setFiltredInsts();
        setupRecyclerView();
        setupAdapter();
    }

    private void setFiltredInsts() {

        if(getIntent().getStringExtra(FILTER_INST)!=null && getIntent().getStringExtra(FILTER_INST).equals(FILTER_IIM)){
            filteredInsts=Institute.getIIMs(this);
        }else if (getIntent().getStringExtra(FILTER_INST)!=null && getIntent().getStringExtra(FILTER_INST).equals(FILTER_NON_IIM))
        {
            filteredInsts=Institute.getNonIIMs(this);
        }
        else{
            filteredInsts=Institute.getAllInstitutes(this);
        }

    }

    private void setupAdapter() {
        adapter=new AdapterInstitute(this, filteredInsts);
        recyclerView.setAdapter(adapter);
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void assignView() {
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view1);
    }


}
