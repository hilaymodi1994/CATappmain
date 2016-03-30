package com.example.mihirmodi.catmain.viewholders;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.activities.QuestionFragment;
import com.example.mihirmodi.catmain.activities.QuizPlayer;
import com.example.mihirmodi.catmain.models.Option;

/**
 * Created by hbb20 on 1/3/16.
 */
public class OptionViewHolder extends RecyclerView.ViewHolder {
    private final QuestionFragment questionFragment;
    int i = 0;
    TextView textViewContent;
    Context context;
    RelativeLayout relativeHolder;
    QuizPlayer quizPlayer;

    public OptionViewHolder(Context context,View itemView, QuizPlayer quizPlayer, QuestionFragment questionFragment) {
        super(itemView);
        this.context=context;
        relativeHolder= (RelativeLayout)itemView.findViewById(R.id.relative_optionHolder);
        textViewContent = (TextView) itemView.findViewById(R.id.textView_content);
        this.quizPlayer=quizPlayer;
        this.questionFragment =questionFragment;
    }

    public void bindOption(final Option option) {
        //content setup
        textViewContent.setText(option.getContent());

        //click set up
        if(option.isSelectable()){ //set click listener only if selectable
            relativeHolder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option.setClicked(true);
                    questionFragment.disableAllOptions();
                    if(option.isCorrect()){
                        quizPlayer.increaseScore();
                    }else {
                        quizPlayer.decreaseScore();
                    }
                }
            });
        }else{
            relativeHolder.setOnClickListener(null);
        }

        //set styling
        if(option.isSelectable()){ //when option is available for click
            relativeHolder.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.back2));
        }else{ //when any one option has been clicked and made other disabled

            if(option.isClicked()){
                if(option.isCorrect()) {
                    relativeHolder.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.back2_correct));
                }
                else {
                    relativeHolder.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.back2_incorrect));
                }
            }else {
                relativeHolder.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.back2_disabled));
            }
        }
    }
}
