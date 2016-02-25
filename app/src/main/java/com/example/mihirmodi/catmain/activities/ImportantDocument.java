package com.example.mihirmodi.catmain.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.example.mihirmodi.catmain.models.DocumentPdfModel;
import com.example.mihirmodi.catmain.adapters.AdapterDocument;
import com.example.mihirmodi.catmain.R;

import java.util.List;

public class ImportantDocument extends AppCompatActivity {

    android.support.v7.widget.RecyclerView recyclerView;
    AdapterDocument adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.importantdoc);

        assignView();
        //setup adapter
        setupRecyclerView();
        setupAdapter();
    }

    private void setupAdapter() {
        List<DocumentPdfModel> documentPDFmodels = DocumentPdfModel.getdocIIMInstitutes(this);
        adapter=new AdapterDocument(this, documentPDFmodels);
        recyclerView.setAdapter(adapter);
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void assignView() {
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view1);
    }


}
