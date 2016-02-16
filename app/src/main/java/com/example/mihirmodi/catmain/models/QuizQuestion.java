package com.example.mihirmodi.catmain.models;

/**
 * Created by lenovo on 08-02-2016.
 */
public class QuizQuestion {


    int quizquestionID;
    int quizID;
    String quizquestionText;
    int quizqusetionMarks;


    public QuizQuestion() {
    }

    public QuizQuestion(String quizquestionText, int quizquestionID, int quizID, int quizqusetionMarks) {
        this.quizID = quizID;
        this.quizquestionID = quizquestionID;
        this.quizquestionText = quizquestionText;
        this.quizqusetionMarks = quizqusetionMarks;

    }


    // setters
    public void setQuizquestionID(int quizquestionID) {
        this.quizquestionID = quizquestionID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public void setQuizquestionText(String quizquestionText) {
        this.quizquestionText = quizquestionText;
    }

    public void setQuizqusetionMarks(int quizqusetionMarks) {
        this.quizqusetionMarks = quizqusetionMarks;
    }

    // getters
    public int getQuizID() {
        return this.quizID;
    }

    public int getQuizquestionID() {
        return this.quizquestionID;
    }
    public int getQuizqusetionMarks() {
        return this.quizqusetionMarks;
    }
    public String getQuizquestionText() {
        return this.quizquestionText;
    }

}