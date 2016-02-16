package com.example.mihirmodi.catmain.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mihirmodi.catmain.models.QuizUserAnswer;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;
import com.example.mihirmodi.catmain.models.Quiz;
import com.example.mihirmodi.catmain.models.QuizQuestion;
import com.example.mihirmodi.catmain.models.QuizQuestionOption;
import com.example.mihirmodi.catmain.models.QuizScorecard;
import com.example.mihirmodi.catmain.R;

public class DatabasePracScreen extends AppCompatActivity {
EditText e1,e2,e3,e4,e5;
    String E1,E2,E3,E4,E5;
    Quiz q=new Quiz();
    DatabaseHelper db = new DatabaseHelper(this);
    QuizScorecard u=new QuizScorecard();
    QuizUserAnswer m =new QuizUserAnswer();
    QuizQuestion r=new QuizQuestion();
    QuizQuestionOption n=new QuizQuestionOption();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.databasepracscreen);
        db = new DatabaseHelper(this);
       Button b3=(Button)findViewById(R.id.etx1);
        Button b5=(Button)findViewById(R.id.etx3);
        Button b6=(Button)findViewById(R.id.etx4);

      Button b4=(Button)findViewById(R.id.etx2);

       // e3=(EditText)findViewById(R.id.etx3);

      //  e4=(EditText)findViewById(R.id.etx4);

       e5=(EditText)findViewById(R.id.etx5);

        Button b1=(Button)findViewById(R.id.btn1);
        Button b2=(Button)findViewById(R.id.btn2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //E1=1;
               // E2 ="u11";
               // E3="ans1";
               E4= "50";

                u.setquiz_scorecard_id(2);
                u.setuser_id(123);
                u.setquiz_user_answer_id(11);
                u.setquiz_totalmarks(94);
                db.insert(u);
               m.setquiz_question_option_id(1);
                m.setquiz_user_answer_id(2);
                m.setquiz_question_id(1);
                db.insertm(m);
                n.setquiz_question_option_id(5);
                n.setquiz_question_id(1);
                n.setquiz_question_option_text("A.delhi");
                n.setquiz_question_option_is_correct("delhi");
                db.insertn(n);
                n.setquiz_question_option_id(2);
                n.setquiz_question_id(1);
                n.setquiz_question_option_text("B.china");
                n.setquiz_question_option_is_correct("delhi");
                db.insertn(n);
                db.insertn(n);
                n.setquiz_question_option_id(3);
                n.setquiz_question_id(1);
                n.setquiz_question_option_text("C.mumbai");
                n.setquiz_question_option_is_correct("delhi");
                db.insertn(n);
                n.setquiz_question_option_id(4);
                n.setquiz_question_id(2);
                n.setquiz_question_option_text("D.kerala");
                n.setquiz_question_option_is_correct("delhi");
                db.insertn(n);
                db.insertn(n);
                q.setQuizID(1);
                q.setQuizTIME(5);
                q.setQuizTITLE("Data Inter Pretation");
                db.insertq(q);
                r.setQuizID(1);
                r.setQuizquestionID(1);
                r.setQuizquestionText("what is capital of INDIA?");
                r.setQuizqusetionMarks(3);
                db.insertr(r);
                r.setQuizID(1);
                r.setQuizquestionID(2);
                r.setQuizquestionText("what is capital of gujarat?");
                r.setQuizqusetionMarks(3);
                db.insertr(r);
                r.setQuizID(1);
                r.setQuizquestionID(3);
                r.setQuizquestionText("what is capital of maharashtra?");
                r.setQuizqusetionMarks(3);
                db.insertr(r);
                r.setQuizID(1);
                r.setQuizquestionID(4);
                r.setQuizquestionText("what is capital of rajasthan?");
                r.setQuizqusetionMarks(3);
                db.insertr(r);




                Toast.makeText(DatabasePracScreen.this,"add raw",Toast.LENGTH_LONG).show();


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    E2 =e2.getText().toString();
                QuizScorecard u =
                        db.findProduct(2);
                Log.d("Insert", "Insert raw");

                if (u != null) {
                    e5.setText(""+(u.getQuizuseranswerID())+"\n"+(u.getquiz_scorecard_id())+"\n"+(u.getquiz_totalmarks()));
                } else {
                    e5.setText("No Match Found");
                }
            }


        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  E2 =e2.getText().toString();
                QuizUserAnswer m =
                        db.findProductm(3);
                Log.d("Insert", "Insert raw");

                if (m != null) {
                    e5.setText(""+(m.getquiz_question_option_id())+"\n"+(m.getquiz_question_id())+"\n"+(m.getquiz_user_answer_id()));
                } else {
                    e5.setText("No Match Found");
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizQuestionOption n =
                        db.findProductn(5);
                Log.d("Insert", "Insert raw");

                if (n != null) {
                    e5.setText((n.getquiz_question_option_id())+"\n"+(n.getquiz_question_id())+"\n"+(n.getquiz_question_option_text()).toString()+"\n"+(n.getquiz_question_option_is_correct()).toString());
                } else {
                    e5.setText("No Match Found");
                }

            }
        });
       b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz q =
                        db.findProductq(4);
                Log.d("Insert", "Insert raw");

                if (q != null) {
                    e5.setText(""+(q.getQuizID())+"\n"+(q.getQuizTIME())+"\n"+(q.getQuizTITLE()));
                } else {
                    e5.setText("No Match Found");
                }

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizQuestion r =
                        db.findProductr(4);
                Log.d("Insert", "Insert raw");

                if (r != null) {
                    e5.setText(""+(r.getQuizID())+"\n"+(r.getQuizquestionID())+"\n"+(r.getQuizquestionText())+"\n"+(r.getQuizqusetionMarks()));
                } else {
                    e5.setText("No Match Found");
                }

            }
        });

    }


    }

