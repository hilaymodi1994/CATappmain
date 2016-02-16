package com.example.mihirmodi.catmain.models;

import android.content.Context;

import com.example.mihirmodi.catmain.R;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


public class DocumentPdfModel {

        @SerializedName("pdf_file_name")
        @Expose
        private String pdfFileName;
        @SerializedName("pdf_file_url")
        @Expose
        private String pdfFileUrl;

        /**
         *
         * @return
         * The pdfFileName
         */
        public String getPdfFileName() {
            return pdfFileName;
        }

        /**
         *
         * @param pdfFileName
         * The pdf_file_name
         */
        public void setPdfFileName(String pdfFileName) {
            this.pdfFileName = pdfFileName;
        }

        /**
         *
         * @return
         * The pdfFileUrl
         */
        public String getPdfFileUrl() {
            return pdfFileUrl;
        }

        /**
         *
         * @param pdfFileUrl
         * The pdf_file_url
         */
        public void setPdfFileUrl(String pdfFileUrl) {
            this.pdfFileUrl = pdfFileUrl;
        }


    public static List<DocumentPdfModel> getDummyInstituteList() {
        List<DocumentPdfModel> dummyIns=new ArrayList<>();
        for(int i=0;i<10;i++){
            DocumentPdfModel documentmodels= new DocumentPdfModel();
            documentmodels.setPdfFileName("PdfFileNam " + (i + 1));
            dummyIns.add(documentmodels);
        }
        return dummyIns;
    }


    public static List<DocumentPdfModel> getdocIIMInstitutes(Context context){
        String jsonString=getJsonStringFromFile(context, R.raw.document);
        Gson gson=new Gson();
        List<DocumentPdfModel> documentPDFmodels = gson.fromJson(jsonString, new TypeToken<List<DocumentPdfModel>>(){}.getType());
        return documentPDFmodels;
    }

    private static String getJsonStringFromFile(Context context,int fileID) {
        InputStream is = context.getResources().openRawResource(fileID);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String jsonString = writer.toString();
        return jsonString;
    }
}




