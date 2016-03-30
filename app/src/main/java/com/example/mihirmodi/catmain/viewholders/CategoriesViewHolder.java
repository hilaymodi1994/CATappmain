package com.example.mihirmodi.catmain.viewholders;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.activities.QuestionsMain;

import com.example.mihirmodi.catmain.models.Categories;
import com.example.mihirmodi.catmain.models.IimImageView;
import com.example.mihirmodi.catmain.models.Institute;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.util.ArrayList;

/**
 * Created by mmodi on 2/17/2016.
 */
public class CategoriesViewHolder extends RecyclerView.ViewHolder {

    TextView textView_categories;
    Intent intent;
    Context context;
    IimImageView iimImageView;


    public CategoriesViewHolder(View itemView, Context context) {
        super(itemView);
        assignViews(itemView);
        this.context = context;
    }


    private void assignViews(View itemView) {
        textView_categories = (TextView) itemView.findViewById(R.id.textView_categories);


    }
    public void bindInstitute(final Categories categories) {
        textView_categories.setText(categories.getName());
        //tv_street.setText(nonInstitute.getStreet());
        //tv_area.setText(nonInstitute.getArea());
        //tv_city.setText(nonInstitute.getCity());
textView_categories.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

// To dismiss the dialog

        int phn = categories.getId();
        Intent sIntent = new Intent(context,QuestionsMain.class);
            Bundle b=new Bundle();
            b.putInt("phn", categories.getId());
            sIntent.putExtras(b);
        context.startActivity(sIntent);




    }
});

    }
}

