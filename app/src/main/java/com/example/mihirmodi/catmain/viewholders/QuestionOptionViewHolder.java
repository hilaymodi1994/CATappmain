package com.example.mihirmodi.catmain.viewholders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Institute;

/**
 * Created by mmodi on 2/17/2016.
 */
public class QuestionOptionViewHolder extends  RecyclerView.ViewHolder {
    TextView textView_option;
    RadioButton radio_selected;
    CheckBox checkbox_selected;
    Intent intent;
    Context context;

    public QuestionOptionViewHolder(View itemView, Context context) {
        super(itemView);
        assignViews(itemView);
        this.context = context;
    }


    private void assignViews(View itemView) {
        textView_option = (TextView) itemView.findViewById(R.id.textView_option);
        radio_selected=(RadioButton)itemView.findViewById(R.id.radio_selected);
        checkbox_selected=(CheckBox)itemView.findViewById(R.id.checkbox_selected);
    }
    public void bindInstitute(final Institute institute) {


    }
}




