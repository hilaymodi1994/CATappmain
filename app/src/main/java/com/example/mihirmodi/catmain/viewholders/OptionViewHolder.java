package com.example.mihirmodi.catmain.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Options;

/**
 * Created by hbb20 on 1/3/16.
 */
public class OptionViewHolder extends RecyclerView.ViewHolder {
    TextView textViewContent;
    public OptionViewHolder(View itemView) {
        super(itemView);
        textViewContent=(TextView)itemView.findViewById(R.id.textView_content);
    }

    public void bindOption(Options option){
        textViewContent.setText(option.getContent());
    }
}
