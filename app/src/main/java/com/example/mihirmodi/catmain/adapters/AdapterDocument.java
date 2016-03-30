package com.example.mihirmodi.catmain.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.DocumentPdfModel;
import com.example.mihirmodi.catmain.viewholders.DocumentPdfViewHolder;

import java.util.List;

/**
 */
public class AdapterDocument extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<DocumentPdfModel> documentPDFmodels;
    private Context mContext;
    LayoutInflater inflater;
    public AdapterDocument(Context context, List<DocumentPdfModel> documentPDFmodels) {
        this.documentPDFmodels = documentPDFmodels;
        this.mContext = context;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView=inflater.inflate(R.layout.layoutdocument,parent,false);
        DocumentPdfViewHolder iVIewHolder=new DocumentPdfViewHolder(rootView,mContext);
        return iVIewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DocumentPdfViewHolder viewHolder=(DocumentPdfViewHolder)holder;
        viewHolder.bindInstitute(documentPDFmodels.get(position));
    }

    @Override
    public int getItemCount() {
        return documentPDFmodels.size();
    }
}
