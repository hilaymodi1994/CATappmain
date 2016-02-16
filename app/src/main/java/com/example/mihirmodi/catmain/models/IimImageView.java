package com.example.mihirmodi.catmain.models;
import android.content.Context;
import android.widget.ImageView;

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
import java.util.List;


public class IimImageView {

    @SerializedName("Collagename")
    @Expose
    private String Collagename;
    @SerializedName("imageurl")
    @Expose
    private String imageurl;
    @SerializedName("website")
    @Expose
    private String website;

    /**
     *
     * @return
     * The Collagename
     */
    public String getCollagename() {
        return Collagename;
    }

    /**
     *
     * @param Collagename
     * The Collagename
     */
    public void setCollagename(String Collagename) {
        this.Collagename = Collagename;
    }

    /**
     *
     * @return
     * The imageurl
     */
    public String getImageurl() {
        return imageurl;
    }

    /**
     *
     * @param imageurl
     * The imageurl
     */
    public ImageView setImageurl(String imageurl) {
        this.imageurl = imageurl;
        return null;
    }

    /**
     *
     * @return
     * The website
     */
    public String getWebsite() {
        return website;
    }

    /**
     *
     * @param website
     * The website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    public static List<IimImageView> getInstitutemenuInstitutes(Context context){
        String jsonString=getJsonStringFromFile(context, R.raw.imageslider);
        Gson gson=new Gson();
        List<IimImageView> iimImageViews = gson.fromJson(jsonString, new TypeToken<List<IimImageView>>(){}.getType());
        return iimImageViews;
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
