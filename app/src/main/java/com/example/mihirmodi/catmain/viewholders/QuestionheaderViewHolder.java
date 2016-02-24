package com.example.mihirmodi.catmain.viewholders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Institute;
import com.example.mihirmodi.catmain.models.Questions;

/**
 * Created by mmodi on 2/17/2016.
 */
public class QuestionheaderViewHolder extends  RecyclerView.ViewHolder {
    TextView textView_question_header;
    TextView textView_question_content;
    Intent intent;
    Context context;

    public QuestionheaderViewHolder(View itemView, Context context) {
        super(itemView);
        assignViews(itemView);
        this.context = context;
    }


    private void assignViews(View itemView) {
        textView_question_header = (TextView) itemView.findViewById(R.id.textView_question_header);
        textView_question_content = (TextView) itemView.findViewById(R.id.textView_question_content);
    }
    public void bindInstitute(final Questions questions) {
        textView_question_content.setText(Html.fromHtml(questions.getHeader()));
    textView_question_header.setText(Html.fromHtml(questions.getContent()));

}
}




