package com.example.mihirmodi.catmain.viewholders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.activities.QuizPlayer;
import com.example.mihirmodi.catmain.models.Question;

/**
 * Created by mmodi on 2/17/2016.
 */
public class QuestionHeaderViewHolder extends RecyclerView.ViewHolder {
    TextView textView_question_header;
    TextView textView_question_content;
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
        cardView=(CardView)itemView.findViewById(R.id.cardView_question);
    }

    public void bindQuestionWithClick(final Context context, final Question questions, final int position) {
        textView_question_content.setText(Html.fromHtml(questions.getHeader()));
        textView_question_header.setText(Html.fromHtml(questions.getContent()));

        if(position>0 && context!=null){
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, QuizPlayer.class);
                    intent.putExtra(QuizPlayer.EXTRA_LAUNCH_POSITION,position);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }else{
            cardView.setOnClickListener(null);
        }
    }

    public void bindQuestionHeaderText(final Question questions) {
        bindQuestionWithClick(null, questions, -1);
    }
}




