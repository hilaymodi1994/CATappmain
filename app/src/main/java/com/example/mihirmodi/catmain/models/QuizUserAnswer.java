package com.example.mihirmodi.catmain.models;

/**
 * Created by mmodi on 2/7/2016.
 */
public class QuizUserAnswer {

    int quizuseranswerID;
    int quizquestionID;
    int quizquestionoptionID;


    // constructors
    public QuizUserAnswer() {
    }

    public QuizUserAnswer(int quizuseranswerID, int quizquestionID, int quizquestionoptionID) {
        this.quizuseranswerID = quizuseranswerID;
        this.quizquestionID = quizquestionID;
        this.quizquestionoptionID = quizquestionoptionID;
    }

    // setters
    public void setquiz_user_answer_id(int quiz_user_answer_id) {
        this.quizuseranswerID = quiz_user_answer_id;
    }

    public void setquiz_question_id(int quiz_question_id) {
        this.quizquestionID = quiz_question_id;
    }

    public void setquiz_question_option_id(int quiz_question_option_id) {
        this.quizquestionoptionID = quiz_question_option_id;
    }



    // getters
    public int getquiz_user_answer_id() {
        return this.quizuseranswerID;
    }

    public int getquiz_question_id() {
        return this.quizquestionID;
    }

    public int getquiz_question_option_id() {
        return this.quizquestionoptionID;
    }
}