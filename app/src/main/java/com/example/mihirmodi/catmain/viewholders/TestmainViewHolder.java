package com.example.mihirmodi.catmain.viewholders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.activities.QuestionsMain;
import com.example.mihirmodi.catmain.models.Categories;
import com.example.mihirmodi.catmain.models.IimImageView;
import com.example.mihirmodi.catmain.models.Tests;

/**
 * Created by mmodi on 2/24/2016.
 */
public class TestmainViewHolder extends RecyclerView.ViewHolder {

    TextView textView_tests;
    Intent intent;
    Context context;



    public TestmainViewHolder(View itemView, Context context) {
        super(itemView);
        assignViews(itemView);
        this.context = context;
    }


    private void assignViews(View itemView) {
        textView_tests = (TextView) itemView.findViewById(R.id.textView_tests);


    }
    public void bindInstitute(final Tests tests) {
        textView_tests.setText(tests.getName());
        //tv_street.setText(nonInstitute.getStreet());
        //tv_area.setText(nonInstitute.getArea());
        //tv_city.setText(nonInstitute.getCity());
        textView_tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phn = tests.getName();
                Intent sIntent = new Intent(context, QuestionsMain.class);
                context.startActivity(sIntent);

            }


        });

    }
}

