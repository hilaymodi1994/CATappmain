package com.example.mihirmodi.catmain.models;

/**
 * Created by lenovo on 08-02-2016.
 */
public class User {

    int userID;
    String userLASTNAME;
    String userFIRESTNAME;
    String userEMAILID;
    String userPASSWORD;
   

    public User() {
    }

    public User(String userLASTNAME, String userFIRESTNAME, String userEMAILID, String userPASSWORD, int userID) {
        this.userLASTNAME = userLASTNAME;
        this.userFIRESTNAME = userFIRESTNAME;
        this.userEMAILID = userEMAILID;
        this.userPASSWORD = userPASSWORD;
        this.userID = userID;
    }



    // setters
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserLASTNAME(String userLASTNAME) {
        this.userLASTNAME = userLASTNAME;
    }

    public void setUserFIRESTNAME(String userFIRESTNAME) {
        this.userFIRESTNAME = userFIRESTNAME;
    }
    public void setUserEMAILID(String userEMAILID) {
        this.userEMAILID = userEMAILID;
    }
    public void setUserPASSWORD(String userPASSWORD) {
        this.userPASSWORD = userPASSWORD;
    }


  //  public void setCreatedAt(String created_at){
      //  this.created_at = created_at;
  //  }

    // getters
    public int getUserID() {
        return this.userID;
    }

    public String getUserLASTNAME() {
        return this.userLASTNAME;
    }

    public String getUserFIRESTNAME() {
        return this.userFIRESTNAME;}

    public String getUserEMAILID() {
        return this.userEMAILID;}

    public String getUserPASSWORD(){
        return this.userPASSWORD;



    }
}
