package com.example.mihirmodi.catmain.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.mihirmodi.catmain.models.Institute;
import com.example.mihirmodi.catmain.adapters.AdapterInstitute;
import com.example.mihirmodi.catmain.R;

import java.util.ArrayList;
import java.util.List;

public class AllIInstituteView extends AppCompatActivity {
    public static final String FILTER_INST="filteration";

    RecyclerView recyclerView;
    EditText editText_search;
    AdapterInstitute adapter;
    List<Institute> masterInsts;
    List<Institute> filteredInsts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.allinstitute);


        assignView();
        setupRecyclerView();
        setMasterInsts();

        setupAdapter();


    }
    SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextChange(String query) {
            Log.d("QUERY","changed "+query);
            query = query.toString();
            for (int i = 0; i < filteredInsts.size(); i++) {

                final String text = filteredInsts.get(i).toString();
                if (text.contains(query)) {

                    filteredInsts.add(filteredInsts.get(i));
                }
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(AllIInstituteView.this));
            adapter=new AdapterInstitute(AllIInstituteView.this, filteredInsts);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();  // data set changed
            return true;

        }
        public boolean onQueryTextSubmit(String query) {
            return false;
        }
    };



    private void setMasterInsts() {
        masterInsts=Institute.getAllInstitutes(this);
        applyQuery("");
    }


    private void setupAdapter() {
        adapter=new AdapterInstitute(this, filteredInsts);
        recyclerView.setAdapter(adapter);
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void assignView() {
        editText_search = (EditText) findViewById(R.id.search);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view1);
        addWatcher();
    }

    private void addWatcher() {
        editText_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                applyQuery(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void applyQuery(String query) {
        filteredInsts=filterFromMaster(query);
        if(filteredInsts.size()==0){
            Toast.makeText(this,"No result for '"+query+"'",Toast.LENGTH_LONG).show();
        }else{
                setupAdapter();
        }
    }

    private List<Institute> filterFromMaster(String query) {
        List<Institute> tempList=new ArrayList<>();
        for(Institute institute:masterInsts){
            if(query.trim().length()==0){
                tempList.add(institute);
                continue;
            }

            if(institute.getName().toLowerCase().contains(query.toLowerCase()) || institute.getState().toLowerCase().contains(query.toLowerCase()) || institute.getCity().toLowerCase().contains(query.toLowerCase())){
                tempList.add(institute);
            }
        }

        return tempList;
    }


}
