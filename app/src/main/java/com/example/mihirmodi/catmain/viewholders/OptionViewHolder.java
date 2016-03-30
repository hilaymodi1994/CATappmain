package com.example.mihirmodi.catmain.viewholders;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Options;

/**
 * Created by hbb20 on 1/3/16.
 */
public class OptionViewHolder extends RecyclerView.ViewHolder {
    int i = 0;
    TextView textViewContent;
    Context context;
    int flag;
    int Score;

    public OptionViewHolder(View itemView, int flag,int Score) {
        super(itemView);
        textViewContent = (TextView) itemView.findViewById(R.id.textView_content);
        this.flag=flag;
        this.Score=Score;
    }

    public void bindOption(final Options option) {

        textViewContent.setText(option.getContent());
        textViewContent.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                i++;
                if (flag == 0) {
                    boolean state = option.isCorrect();

                    if (state == true) {
                        textViewContent.setTextColor(Color.GREEN);

                    } else {
                        textViewContent.setTextColor(Color.RED);

                    }
                } else {
                    if(i==1){boolean state = option.isCorrect();
                    textViewContent.setTextColor(Color.BLUE);
                        if (state == true) {
                          Score++;

                        } else {
                            textViewContent.setTextColor(Color.RED);

                            Score++;
                        }

                    }
                    else {if(i==2){textViewContent.setTextColor(Color.WHITE);
                    i=0;}}


                }


            }
        });
    }
}
