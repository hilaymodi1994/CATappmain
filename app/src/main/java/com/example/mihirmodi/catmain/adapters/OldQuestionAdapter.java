package com.example.mihirmodi.catmain.adapters;

        import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.example.mihirmodi.catmain.R;
        import com.example.mihirmodi.catmain.models.Question;
        import com.example.mihirmodi.catmain.viewholders.QuestionHeaderViewHolder;

        import java.util.ArrayList;

/**
 * Created by mmodi on 2/21/2016.
 */
public class OldQuestionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Question> questionsArrayList;
    private Context mContext;
    LayoutInflater inflater;


    public OldQuestionAdapter(Context context, ArrayList<Question> questionsArrayList) {
        this.questionsArrayList = questionsArrayList;
        this.mContext = context;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView=inflater.inflate(R.layout.layoutquestionheadertext,parent,false);
        QuestionHeaderViewHolder questionheaderViewHolder=new QuestionHeaderViewHolder(rootView,mContext);
        return questionheaderViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        QuestionHeaderViewHolder view=(QuestionHeaderViewHolder)holder;
        view.bindQuestionWithClick(mContext, questionsArrayList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return questionsArrayList.size();
    }
}

