package com.example.mihirmodi.catmain.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;

public class ExtraActivity extends AppCompatActivity {
    public static String EXTRA_LAUNCH_POSITION="launchPosition";
    ViewPager viewPager;
    TextView textView_solution_question;
    TextView textView_solution;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);
        textView_solution_question=(TextView)findViewById(R.id.textView_header_sol);
        textView_solution=(TextView)findViewById(R.id.textView_sol_que);

        setToLaunchPosition();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String Header = extras.getString("Header");
        String solution = extras.getString("solution");
        textView_solution_question.setText(Header);
        textView_solution.setText(solution);




    }
    private void setToLaunchPosition() {
        int position=getIntent().getIntExtra(EXTRA_LAUNCH_POSITION, -1);
        if(position!=-1){
            viewPager.setCurrentItem(position);
        }
    }


}
