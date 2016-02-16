package com.example.mihirmodi.catmain.models;

/**
 * Created by lenovo on 08-02-2016.
 */
public class Quiz {
    int quizID;
    String quizTITLE;
    int quizTIME;


    // constructors
    public Quiz() {

    }

    public Quiz(String quizTITLE, int quizID, int quizTIME) {
        this.quizTIME = quizTIME;
        this.quizTITLE = quizTITLE;
        this.quizID = quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public void setQuizTITLE(String quizTITLE) {
        this.quizTITLE = quizTITLE;
    }

    public void setQuizTIME(int quizTIME) {
        this.quizTIME = quizTIME;
    }

    // getter
    public int getQuizID() {
        return this.quizID;
    }

    public String getQuizTITLE() {
        return this.quizTITLE;
    }

    public int getQuizTIME() {
        return this.quizTIME;
    }
}

