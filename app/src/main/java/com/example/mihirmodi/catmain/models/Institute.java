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

public class Institute {

    @SerializedName("Name")
    @Expose
    private String Name;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("pincode")
    @Expose
    private String pincode;
    @SerializedName("phone no")
    @Expose
    private String phoneNo;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("Emailid")
    @Expose
    private String Emailid;
    @SerializedName("cutOff")
    @Expose
    private float cutOff;
    @SerializedName("isIIM")
    @Expose
    private boolean isIIM;

    /**
     *
     * @return
     * The Name
     */
    public String getName() {
        return Name;
    }

    /**
     *
     * @param Name
     * The Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     *
     * @return
     * The street
     */
    public String getStreet() {
        return street;
    }

    /**
     *
     * @param street
     * The street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     *
     * @return
     * The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     * The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     * The pincode
     */
    public String getPincode() {
        return pincode;
    }

    /**
     *
     * @param pincode
     * The pincode
     */
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    /**
     *
     * @return
     * The phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     *
     * @param phoneNo
     * The phone no
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    /**
     *
     * @return
     * The Emailid
     */
    public String getEmailid() {
        return Emailid;
    }

    /**
     *
     * @param Emailid
     * The Emailid
     */
    public void setEmailid(String Emailid) {
        this.Emailid = Emailid;
    }

    /**
     *
     * @return
     * The cutOff
     */
    public float getCutOff() {
        return cutOff;
    }

    /**
     *
     * @param cutOff
     * The cutOff
     */
    public void setCutOff(float cutOff) {
        this.cutOff = cutOff;
    }

    /**
     *
     * @return
     * The isIIM
     */
    public boolean isIsIIM() {
        return isIIM;
    }

    /**
     *
     * @param isIIM
     * The isIIM
     */
    public void setIsIIM(boolean isIIM) {
        this.isIIM = isIIM;
    }

    public static List<Institute> getDummynonInstituteList() {
        List<Institute> dummyIns=new ArrayList<>();
        for(int i=0;i<10;i++){
            Institute institute = new Institute();
            institute.setName("Institute " + (i + 1));
            institute.setCity("city" + (i + 1));
            institute.setStreet("Shrt " + (i + 1));
            institute.setWebsite("Web " + (i + 1));
            institute.setState("state" + (i + 1));
            institute.setPincode("pincode" + (i + 1));
            institute.setEmailid("emailid" + (i + 1));
            institute.setCutOff(85 + i);
            institute.isIsIIM();
            dummyIns.add(institute);
        }
        return dummyIns;
    }


    public static List<Institute> getAllInstitutes(Context context){
        String jsonString=getJsonStringFromFile(context, R.raw.institute);
        Gson gson=new Gson();
        List<Institute> institutes = gson.fromJson(jsonString, new TypeToken<List<Institute>>(){}.getType());
        return institutes;
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

    public static List<Institute> getSlidingIIM(Context context) {
        List<Institute> iimInsts=getIIMs(context);
        return iimInsts.subList(0,4);
    }

    /**
     * Fetches all the institutes and filter out non iim and return only iims.
     * @param context
     * @return
     */
    public static List<Institute> getIIMs(Context context) {
        List<Institute> allInst= getAllInstitutes(context);
        List<Institute> iims=new ArrayList<>();
        for(int i=0;i<allInst.size();i++){
            Institute iterationInstitute=allInst.get(i);
            if(iterationInstitute.isIsIIM()){
                iims.add(iterationInstitute);
            }
        }
        return iims;
    }
    public static List<Institute> getSlidingNonIIM(Context context) {
        List<Institute> noniimInsts=getNonIIMs(context);
        return noniimInsts.subList(0,4);
    }

    /**
     * Fetches all the institutes and filter out non iim and return only iims.
     * @param context
     * @return
     */
    public static List<Institute> getNonIIMs(Context context) {
        List<Institute> allInst= getAllInstitutes(context);
        List<Institute> noniims=new ArrayList<>();
        for(int i=0;i<allInst.size();i++){
            Institute iterationInstitute=allInst.get(i);
            if(!iterationInstitute.isIsIIM()){
               noniims.add(iterationInstitute);
            }
        }
        return noniims;
    }
}
