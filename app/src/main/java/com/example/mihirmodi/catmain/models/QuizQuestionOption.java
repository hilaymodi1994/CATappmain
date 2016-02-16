package com.example.mihirmodi.catmain.models;

/**
 * Created by mmodi on 2/7/2016.
 */
public class QuizQuestionOption {

    int quizquestionoptionID;
    int quizquestionID;
    String quizquestionoptionText;
    String quizquestionoptionISCORRECT;


    // constructors
    public QuizQuestionOption() {
    }

    public QuizQuestionOption(int quizquestionoptionID, int quizquestionID, String quizquestionoptionText, String quizquestionoptionISCORRECT) {
        this.quizquestionoptionID = quizquestionoptionID;
        this.quizquestionID = quizquestionID;
        this.quizquestionoptionText = quizquestionoptionText;
        this.quizquestionoptionISCORRECT = quizquestionoptionISCORRECT;
    }

    // setters
    public void setquiz_question_option_id(int quiz_question_option_id) {
        this.quizquestionoptionID = quiz_question_option_id;
    }

    public void setquiz_question_id(int quiz_question_id) {
        this.quizquestionID = quiz_question_id;
    }

    public void setquiz_question_option_text(String  quiz_question_option_text) {
        this.quizquestionoptionText = quiz_question_option_text;
    }
    public void setquiz_question_option_is_correct(String  quiz_question_option_is_correct) {
        this.quizquestionoptionISCORRECT = quiz_question_option_is_correct;
    }


    // getters
    public int getquiz_question_option_id() {
        return this.quizquestionoptionID;
    }

    public int getquiz_question_id() {
        return this.quizquestionID;
    }

    public String  getquiz_question_option_text() {
        return this.quizquestionoptionText;
    }
    public String  getquiz_question_option_is_correct() {
        return this.quizquestionoptionISCORRECT;
    }
}