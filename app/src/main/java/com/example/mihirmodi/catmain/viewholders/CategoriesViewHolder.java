package com.example.mihirmodi.catmain.viewholders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.activities.QuestionsMain;

import com.example.mihirmodi.catmain.models.Category;
import com.example.mihirmodi.catmain.models.IimImageView;

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
    public void bindInstitute(final Category category) {
        textView_categories.setText(category.getName());
        //tv_street.setText(nonInstitute.getStreet());
        //tv_area.setText(nonInstitute.getArea());
        //tv_city.setText(nonInstitute.getCity());
textView_categories.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

// To dismiss the dialog

        int phn = category.getId();
        Intent sIntent = new Intent(context,QuestionsMain.class);
            Bundle b=new Bundle();
            b.putInt("phn", category.getId());
            sIntent.putExtras(b);
        context.startActivity(sIntent);




    }
});

    }
}

