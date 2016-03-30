
package com.example.mihirmodi.catmain.viewholders;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.activities.QuestionsMain;
import com.example.mihirmodi.catmain.activities.TestRules;
import com.example.mihirmodi.catmain.models.Categories;
import com.example.mihirmodi.catmain.models.IimImageView;
import com.example.mihirmodi.catmain.models.Tests;

public class TestsViewHolder extends RecyclerView.ViewHolder {

    TextView textView_testses;

    Intent intent;
    Context context;
    IimImageView iimImageView;


    public TestsViewHolder(View itemView, Context context) {
        super(itemView);
        assignViews(itemView);
        this.context = context;
    }


    private void assignViews(View itemView) {
        textView_testses = (TextView) itemView.findViewById(R.id.textView_tests);


    }
    public void bindInstitute(final Tests testses) {
        textView_testses.setText(testses.getName());

        textView_testses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phn = testses.getName();
                Intent sIntent = new Intent(context,TestRules.class);
                Bundle b=new Bundle();

                b.putInt("phn", testses.getId());
                b.putLong("time", testses.getAllowedTime());
                sIntent.putExtras(b);

                context.startActivity(sIntent);


            }




        });

    }
}


