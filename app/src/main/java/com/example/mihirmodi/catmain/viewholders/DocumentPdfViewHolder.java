package com.example.mihirmodi.catmain.viewholders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.DocumentPdfModel;

/**
 *
 */
public class DocumentPdfViewHolder extends RecyclerView.ViewHolder  {
    TextView tv_pdfname;
    TextView btn_url;
    Button btn_website;
    Intent intent;
    Context context;

    public DocumentPdfViewHolder(View itemView, Context context) {
        super(itemView);
        assignViews(itemView);
        this.context = context;
    }


    private void assignViews(View itemView) {
        tv_pdfname = (TextView) itemView.findViewById(R.id.tv_pdfname);
        btn_url = (Button) itemView.findViewById(R.id.btn_ruldownload);


    }

    public void bindInstitute(final DocumentPdfModel documentPDFmodel) {
        tv_pdfname.setText(documentPDFmodel.getPdfFileName());
        btn_url.setText(documentPDFmodel.getPdfFileUrl());
        btn_url.setText("Download");
        btn_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(documentPDFmodel.getPdfFileUrl()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                } catch (Exception e) {
                    Log.e("Exception Caught", e.toString());
                }
            }
        });
    }
}
