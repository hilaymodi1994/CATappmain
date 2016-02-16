package com.example.mihirmodi.catmain.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.mihirmodi.catmain.models.Institute;
import com.example.mihirmodi.catmain.adapters.AdapterImageView;
import com.example.mihirmodi.catmain.R;

import java.util.List;

public class InstitutesHome extends AppCompatActivity {
    android.support.v7.widget.RecyclerView recyclerView,recyclerView1;
    AdapterImageView adapter,adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instituthome);
        assignView();
        //setup adapter
        setupRecyclerView();
        setupAdapter();



    }



    private void setupAdapter() {
        List<Institute> iimImageslides=Institute.getSlidingIIM(this);
        adapter=new AdapterImageView(this,iimImageslides);
        recyclerView.setAdapter(adapter);
        List<Institute> iimImageslide=Institute.getSlidingNonIIM(this);
        adapter1=new AdapterImageView(this,iimImageslide);
        recyclerView1.setAdapter(adapter1);

    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager
            = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView1.setLayoutManager(layoutManager1);


    }

    private void assignView() {
       recyclerView=(RecyclerView)findViewById(R.id.recycler_view1);
        recyclerView1=(RecyclerView)findViewById(R.id.recycler_view2);
        Toolbar toolbarTop = (Toolbar) findViewById(R.id.toolbar_top);
        TextView mTitle = (TextView) toolbarTop.findViewById(R.id.toolbar_title);
        TextView tv_viewintitute=(TextView)findViewById(R.id.textview_institute);
    }

    public void viewinstitute(View view)
    {
        Intent intent = new Intent(this, AllIInstituteView.class);
        intent.putExtra(InstituteView.FILTER_INST, InstituteView.FILTER_INST);
        startActivity(intent);
    }
    public void viewiim(View view)
    {
        Intent intent = new Intent(this, InstituteView.class);
        intent.putExtra(InstituteView.FILTER_INST, InstituteView.FILTER_IIM);
        startActivity(intent);
    }
    public void viewnoniim(View view)
    {
        Intent intent = new Intent(this, InstituteView.class);
        intent.putExtra(InstituteView.FILTER_INST, InstituteView.FILTER_NON_IIM);
        startActivity(intent);
    }

}
