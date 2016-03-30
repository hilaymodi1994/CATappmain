package com.example.mihirmodi.catmain.viewholders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.IimImageView;
import com.example.mihirmodi.catmain.models.Institute;

/**
 *
 */
public class ImageViewHolder extends RecyclerView.ViewHolder {
    ImageView IImimage;
    TextView tv_collagename;
    Intent intent;
    Context context;
    IimImageView iimImageView;

    public ImageViewHolder(View itemView, Context context) {
        super(itemView);
        assignViews(itemView);
        this.context = context;
    }


    private void assignViews(View itemView) {
        tv_collagename = (TextView) itemView.findViewById(R.id.ImageViewText);
        IImimage = (ImageView) itemView.findViewById(R.id.imageView);


    }

    public void bindInstitute(final Institute institute) {
        tv_collagename.setText(institute.getName());

        //// TODO: 03-02-2016 update this when image url is added
        String image = institute.getState();

        tv_collagename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = institute.getWebsite();
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + url));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                } catch (Exception e) {
                    Log.e("Exception Caught", e.toString());
                }
            }
        });


    }


}








