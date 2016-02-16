package com.example.mihirmodi.catmain.models;

/**
 * Created by mmodi on 2/7/2016.
 */
public class QuizScorecard {

    int quizscorecardID;
    int userID;
    int quizuseranswerID;
    int quizTOTALMARKS;


    // constructors
    public QuizScorecard() {
    }

    public QuizScorecard(int quizscorecardID, int userID, int quizuseranswerID, int quizTOTALMARKS) {
        this.quizscorecardID = quizscorecardID;
        this.userID = userID;
        this.quizuseranswerID = quizuseranswerID;
        this.quizTOTALMARKS = quizTOTALMARKS;
    }

    // setters
    public void setquiz_scorecard_id(int quiz_scorecard_id) {
        this.quizscorecardID = quiz_scorecard_id;
    }

    public void setuser_id(int user_id) {
        this.userID = user_id;
    }

    public void setquiz_user_answer_id(int quiz_user_answer_id) {
        this.quizuseranswerID = quiz_user_answer_id;
    }
    public void setquiz_totalmarks(int  quiz_totalmarks) {
        this.quizTOTALMARKS = quiz_totalmarks;
    }


    // getters
    public int getquiz_scorecard_id() {
        return this.quizscorecardID;
    }

    public int getuser_id() {
        return this.userID;
    }

    public int getQuizuseranswerID() {
        return this.quizuseranswerID;
    }
    public int getquiz_totalmarks() {
        return this.quizTOTALMARKS;
    }
}