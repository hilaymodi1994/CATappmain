package com.example.mihirmodi.catmain.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;

import java.text.DecimalFormat;

public class ScoreCard extends AppCompatActivity {
float score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_score_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        score= getIntent().getExtras().getFloat("score");
       TextView text=(TextView)findViewById(R.id.textview_solution);
        DecimalFormat df=new DecimalFormat();
        df.setMaximumFractionDigits(2);
        text.setText(df.format(score));
    }
}
