
package com.example.mihirmodi.catmain.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mihirmodi.catmain.adapters.QuizPlayerPagerAdapter;
import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Question;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.util.List;

public class QuizPlayer extends AppCompatActivity {

    private long totalTimeCountInMilliseconds; // total count down time in
    // milliseconds
    private long timeBlinkInMilliseconds;
    private CountDownTimer countDownTimer;
TextView texttimmer;
    CardView cardviewsubmit;
    Button submit;
    public static String EXTRA_LAUNCH_id="categryid";
    int flag;
    int cat_id = 0;
    int test_id = 0;
    int time;
    float score=0;
    public static String EXTRA_LAUNCH_POSITION="launchPosition";
    ViewPager viewPager;
    List<Question> questions;
    private DatabaseHelper db;
    QuizPlayerPagerAdapter pagerAdapter;
    private boolean blink;
    //String Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz_player);
        viewPager = (ViewPager) findViewById(R.id.pagerquizplayer);
        db = new DatabaseHelper(getApplicationContext());
        cat_id= getIntent().getExtras().getInt(EXTRA_LAUNCH_id);
        texttimmer = (TextView)findViewById(R.id.texttimer);
        submit=(Button)findViewById(R.id.toolbar_button);
        cardviewsubmit=(CardView)findViewById(R.id.Card_top);
        time= (int) getIntent().getExtras().getLong("time");
        test_id=getIntent().getExtras().getInt("phn");
        if(cat_id != 0){
            questions=db.getQuestionforcategories(cat_id);
            flag=0;
            pagerAdapter=new QuizPlayerPagerAdapter(this,this,getSupportFragmentManager(),questions,flag);
            viewPager.setAdapter(pagerAdapter);
            setToLaunchPosition();
        }
        if(test_id!=0){
            questions=db.getTestfromtestlist(test_id);
            flag=1;
          //  Score=db.getTestfromtestlist(test_id).toString();
            cardviewsubmit.setVisibility(View.VISIBLE);
         texttimmer.setText(String.valueOf(time));
            settimer();
            startTimer();
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(QuizPlayer.this, ScoreCard.class);
                    Bundle b = new Bundle();
                    b.putFloat("score", score);
                   intent.putExtras(b);
                    startActivity(intent);
                }
            });
            pagerAdapter=new QuizPlayerPagerAdapter(this,this,getSupportFragmentManager(),questions,flag);
            viewPager.setAdapter(pagerAdapter);
            setToLaunchPosition();

        }

    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(totalTimeCountInMilliseconds, 500) {
            // 500 means, onTick function will be called at every 500
            // milliseconds

            @Override
            public void onTick(long leftTimeInMilliseconds) {
                int seconds=(int)(leftTimeInMilliseconds/1000)%60;
                int minutes=(int)((leftTimeInMilliseconds/(1000*60))%60);
                int hours=(int)((leftTimeInMilliseconds/(1000*60*60))%24);

                if (leftTimeInMilliseconds < timeBlinkInMilliseconds) {

                    // change the style of the textview .. giving a red
                    // alert style

                    if (blink) {
                        texttimmer.setVisibility(View.VISIBLE);
                        // if blink is true, textview will be visible
                    } else {
                        texttimmer.setVisibility(View.INVISIBLE);
                    }

                    blink = !blink; // toggle the value of blink
                }

                texttimmer.setText(String.format("%d:%d:%d", hours,minutes,seconds ));
                // format the textview to show the easily readable format

            }

            @Override
            public void onFinish() {
                texttimmer.setText("Submiting your test");
                Intent intent = new Intent(QuizPlayer.this, ScoreCard.class);
                Bundle b = new Bundle();
                b.putFloat("score",score);
                intent.putExtras(b);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        }.start();
    }



    private void settimer() {
        totalTimeCountInMilliseconds =  time*1000 ;

        timeBlinkInMilliseconds = 30 * 10;
    }

    /**
     * change page to requested index
     */
    private void setToLaunchPosition() {
        int position=getIntent().getIntExtra(EXTRA_LAUNCH_POSITION,-1);
        if(position!=-1){
            viewPager.setCurrentItem(position);
        }
    }
    public void onBackPressed() {
        if(test_id!=0) {

            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                    .setMessage("Are you sure you want to exit TEST ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(QuizPlayer.this, TestList.class);
                            startActivity(i);
                            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                            System.exit(0);
                        }
                    }).setNegativeButton("No", null).show();
        }else {new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure you want to exit TEST ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(QuizPlayer.this, CategoriesListmain.class);

                        startActivity(i);
                        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                        System.exit(0);
                    }
                }).setNegativeButton("No", null).show();}
    }

    public void increaseScore(){
        score++;
    }

    public void decreaseScore(){
        score=score-0.3f;
    }
}