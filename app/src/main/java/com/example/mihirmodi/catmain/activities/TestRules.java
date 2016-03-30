package com.example.mihirmodi.catmain.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.mihirmodi.catmain.R;

public class TestRules extends AppCompatActivity {
int phn;
    int time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.rules);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle b = getIntent().getExtras();
        phn= b.getInt("phn");
       time= (int) b.getLong("time");


        Button accept=(Button)findViewById(R.id.backBtn);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestRules.this," Start test ",Toast.LENGTH_SHORT).show();
                Toast.makeText(TestRules.this," ALL THE BEST ",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(TestRules.this,QuizPlayer.class);
                Bundle a=new Bundle();

                a.putInt("phn", phn);
                a.putLong("time", time);
                intent.putExtras(a);
                intent.putExtras(a);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });
    }

}
