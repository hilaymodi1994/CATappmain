package com.example.mihirmodi.catmain.viewholders;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.activities.QuizPlayer;
import com.example.mihirmodi.catmain.activities.TestList;
import com.example.mihirmodi.catmain.models.Question;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by mmodi on 2/17/2016.
 */
public class QuestionHeaderViewHolder extends RecyclerView.ViewHolder {
    TextView textView_question_header;
    TextView textView_question_content;
    TextView textView_question_solution;


    ArrayList<Question>questionArrayList;

    int flag;



    public static String PackageName = "com.example.mihirmodi.catmain";
    ImageView imageView;
    Intent intent;
    CardView cardView;
    Context context;


    public QuestionHeaderViewHolder(View itemView, Context context) {
        super(itemView);
        assignViews(itemView);
        this.context = context;
    }


    private void assignViews(View itemView) {
        textView_question_header = (TextView) itemView.findViewById(R.id.textView_question_header);
        textView_question_content = (TextView) itemView.findViewById(R.id.textView_question_content);
        imageView = (ImageView) itemView.findViewById(R.id.img);
        cardView = (CardView) itemView.findViewById(R.id.cardView_question);
        textView_question_solution = (TextView) itemView.findViewById(R.id.textview_solution);

    }

    public void bindQuestionWithClick(final Context context, final Question questions, final int position, final int catid ,final int flag) {

        textView_question_content.setText(Html.fromHtml(questions.getHeader()));
        textView_question_header.setText(Html.fromHtml(questions.getContent()));

this.flag=flag;
        File file = new File(getImagesTestQueFileLocation("","") );
        Uri uri = Uri.fromFile(file);
        imageView.setImageURI(uri);


        if (position > 0 && context != null) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, QuizPlayer.class);
                   intent.putExtra(QuizPlayer.EXTRA_LAUNCH_id, catid );
                    intent.putExtra(QuizPlayer.EXTRA_LAUNCH_POSITION, position);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });

        } else {
            cardView.setOnClickListener(null);
        }
    }




    public void bindQuestionHeaderText(final Question questions ,int position, final int flag) {

        bindQuestionWithClick(null, questions, position, flag, -1);
        if(flag==0){
            textView_question_solution.setVisibility(View.VISIBLE);
        textView_question_solution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView_question_solution.setText(Html.fromHtml(questions.getAnswerText()));
                textView_question_solution.setTextColor(Color.DKGRAY);
                textView_question_solution.setVisibility(View.VISIBLE);}
            }
        );}
    }



    public static String getImagesTestQueFileLocation(String testId,String imageName){
        return Environment.getDataDirectory()+ "/data/" + DatabaseHelper.PackageName + "/Images/" + testId + "/queimages/" + imageName;
    }
}
