package com.example.mihirmodi.catmain.viewholders;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.activities.ExtraActivity;
import com.example.mihirmodi.catmain.activities.QuizPlayer;
import com.example.mihirmodi.catmain.models.Question;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.io.File;

/**
 * Created by mmodi on 3/8/2016.
 */
public class SolutionViewHolder extends RecyclerView.ViewHolder {
    TextView textView_question_header;
    TextView textView_question_content;
    TextView textView_question_solution;



    ImageView imageView;
    Intent intent;
    CardView cardView;
    Context context;

    public SolutionViewHolder(View itemView, Context context) {
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

    public void bindQuestionWithClick( final Question questions, final int position) {
        textView_question_content.setText(Html.fromHtml(questions.getHeader()));
        textView_question_header.setText(Html.fromHtml(questions.getContent()));
        textView_question_solution.setText(Html.fromHtml(questions.getAnswerText()));



            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    textView_question_solution.setTextColor(Color.DKGRAY);
                    textView_question_solution.setVisibility(View.VISIBLE);


                }
            });

        }
    }


