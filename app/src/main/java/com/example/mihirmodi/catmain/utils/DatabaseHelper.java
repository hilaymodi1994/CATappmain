package com.example.mihirmodi.catmain.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mihirmodi.catmain.models.Quiz;
import com.example.mihirmodi.catmain.models.QuizQuestion;
import com.example.mihirmodi.catmain.models.QuizQuestionOption;
import com.example.mihirmodi.catmain.models.QuizScorecard;
import com.example.mihirmodi.catmain.models.QuizUserAnswer;

public class DatabaseHelper extends SQLiteOpenHelper {
    Context c;
SQLiteDatabase db;
    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "QuizDataBase";

    // Table Names
    private static final String TABLE_QUIZ_QUESTION_OPTION = "QuizQuestionOption";
    private static final String TABLE_QUIZ_USER_ANSWER = "QuizUserAnswer";
    private static final String TABLE_QUIZ_SCORECARD = "QuizScorecard";
    private static final String TABLE_user = "User";
    private static final String TABLE_Quiz = "quiz";
    private static final String TABLE_Quiz_question = "quiz_question";

    // Common column names
    private static final String QUIZ_SCORECARD_ID = "quiz_scorecard_id";
    private static final String USER_ID = "user_id";
    private static final String QUIZ_USER_ANSWER_ID = "quiz_user_answer_id";
    private static final String QUIZ_TOTALMARKS = "quiz_totalmarks";
    private static final String QUIZ_QUESTION_ID = "quiz_question_id";
    private static final String QUIZ_QUESTION_OPTION_ID = "quiz_question_option_id";
    private static final String QUIZ_OUESTION_OPTION_TEXT = "quiz_question_option_text";
    private static final String QUIZ_OUESTION_OPTION_IS_CORRECT = "quiz_question_option_is_correct";
    private static final  String USER_LAST_NAME="user_last_name";

    private static final String USER_FIRST_NAME="user_first_name";
    private static final String USER_EMAIL="user_email";
    private static final String USER_PASSWORD=" user_password";
    private static final String QUIZ_ID="quiz_id";
    private static final String QUIZ_TITLE="quiz_title";
    private static final String QUIZ_TIME="quiz_time";
    private static final String QUIZ_QUESTION_TEXT="quiz_question_text";
    private static final String QUIZ_QUESTION_MARKS="quiz_question_marks";


    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_QUIZ_QUESTION_OPTION = "CREATE TABLE "
            + TABLE_QUIZ_QUESTION_OPTION + "(" + QUIZ_QUESTION_OPTION_ID + " INTEGER PRIMARY KEY," + QUIZ_QUESTION_ID
            + " INTEGER," + QUIZ_OUESTION_OPTION_TEXT + "  TEXT," + QUIZ_OUESTION_OPTION_IS_CORRECT
            + "  TEXT" + "FOREIGN KEY ("+QUIZ_QUESTION_OPTION_ID+") REFERENCES "+TABLE_QUIZ_USER_ANSWER+"("+QUIZ_USER_ANSWER_ID+"));";

    // Tag table create statement
    private static final String CREATE_TABLE_QUIZ_USER_ANSWER = "CREATE TABLE " + TABLE_QUIZ_USER_ANSWER
            + "(" + QUIZ_USER_ANSWER_ID + " INTEGER PRIMARY KEY," + QUIZ_QUESTION_ID + " INTEGER,"
            + QUIZ_QUESTION_OPTION_ID + " INTEGER" + "FOREIGN KEY ("+QUIZ_USER_ANSWER_ID+") REFERENCES "+TABLE_QUIZ_SCORECARD+"("+QUIZ_SCORECARD_ID+"));";

    // todo_tag table create statement
    private static final String CREATE_TABLE_QUIZ_SCORECARD = "CREATE TABLE "
            + TABLE_QUIZ_SCORECARD + "(" + QUIZ_SCORECARD_ID + " INTEGER PRIMARY KEY,"
            + USER_ID + " INTEGER,"+ QUIZ_USER_ANSWER_ID + " INTEGER,"
            + QUIZ_TOTALMARKS + " TEXT" + ")";

    private static final String CREATE_TABLE_user = "CREATE TABLE "
            + TABLE_user + "(" + USER_ID + " INTEGER PRIMARY KEY," + USER_LAST_NAME
            + " TEXT," + USER_FIRST_NAME + " TEXT," + USER_EMAIL
            + " TEXT," +      USER_PASSWORD +" TEXT"+ " FOREIGN KEY ("+USER_ID+") REFERENCES "+TABLE_QUIZ_SCORECARD+"("+QUIZ_SCORECARD_ID+"));";

    // Tag table create statement
    private static final String CREATE_TABLE_Quiz = "CREATE TABLE " + TABLE_Quiz
            + "(" + QUIZ_ID + " INTEGER PRIMARY KEY," + QUIZ_TITLE + " TEXT,"
            + QUIZ_TIME+ " DATETIME" + "FOREIGN KEY ("+QUIZ_ID+") REFERENCES "+TABLE_Quiz_question+"("+QUIZ_QUESTION_ID+"));";

    // todo_tag table create statement
    private static final String CREATE_TABLE_Quiz_question = "CREATE TABLE "
            + TABLE_Quiz_question + "(" + QUIZ_ID + " INTEGER,"
            + QUIZ_QUESTION_ID + " INTEGER PRIMARY KEY," + QUIZ_QUESTION_TEXT + " TEXT,"
            + QUIZ_QUESTION_MARKS + " INTEGER" +"FOREIGN KEY ("+QUIZ_QUESTION_ID+") REFERENCES "+TABLE_QUIZ_QUESTION_OPTION+"("+QUIZ_QUESTION_OPTION_ID+") REFERENCES "+TABLE_QUIZ_USER_ANSWER+"("+QUIZ_USER_ANSWER_ID+"));";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        Log.d("TABLE", "Table created");
        db.execSQL(CREATE_TABLE_QUIZ_QUESTION_OPTION);
        db.execSQL(CREATE_TABLE_QUIZ_USER_ANSWER);
        db.execSQL(CREATE_TABLE_QUIZ_SCORECARD);
        db.execSQL(CREATE_TABLE_user);
        db.execSQL(CREATE_TABLE_Quiz);
        db.execSQL(CREATE_TABLE_Quiz_question);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUIZ_QUESTION_OPTION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUIZ_USER_ANSWER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUIZ_SCORECARD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_user);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Quiz);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Quiz_question);

        // create new tables
        onCreate(db);
    }
    public void insert(QuizScorecard u) {
        db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(QUIZ_SCORECARD_ID, u.getquiz_scorecard_id());
        contentValues.put(USER_ID, u.getuser_id());
        contentValues.put(QUIZ_USER_ANSWER_ID, u.getquiz_scorecard_id());
        contentValues.put(QUIZ_TOTALMARKS, u.getquiz_totalmarks());
        db.insert(TABLE_QUIZ_SCORECARD, null, contentValues);

       db.close();


    }
    public void insertm(QuizUserAnswer m) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUIZ_QUESTION_OPTION_ID, m.getquiz_question_option_id());
        contentValues.put(QUIZ_QUESTION_ID, m.getquiz_question_id());
        contentValues.put(QUIZ_USER_ANSWER_ID, m.getquiz_user_answer_id());

        db.insert(TABLE_QUIZ_USER_ANSWER, null, contentValues);

        db.close();
    }
   //z
    public void insertn(QuizQuestionOption n) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUIZ_QUESTION_OPTION_ID, n.getquiz_question_option_id());
        contentValues.put(QUIZ_QUESTION_ID,n.getquiz_question_id());
        contentValues.put(QUIZ_OUESTION_OPTION_TEXT, n.getquiz_question_option_text());
        contentValues.put(QUIZ_OUESTION_OPTION_IS_CORRECT, n.getquiz_question_option_is_correct());
        db.insert(TABLE_QUIZ_QUESTION_OPTION, null, contentValues);

        db.close();
    }
    public void insertq(Quiz q) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUIZ_ID, q.getQuizID());
        contentValues.put(QUIZ_TITLE,q.getQuizTITLE());
        contentValues.put(QUIZ_TIME, q.getQuizTIME());
        db.insert(TABLE_Quiz, null, contentValues);

        db.close();
    }
    public void insertr(QuizQuestion r) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUIZ_ID,r.getQuizID());
        contentValues.put(QUIZ_QUESTION_ID,r.getQuizquestionID());
        contentValues.put(QUIZ_QUESTION_TEXT,r.getQuizquestionText());
        contentValues.put(QUIZ_QUESTION_MARKS,r.getQuizqusetionMarks());
        db.insert(TABLE_Quiz_question, null, contentValues);

        db.close();
    }



    public QuizScorecard findProduct(int user) {



       String query = "Select * FROM " + TABLE_QUIZ_SCORECARD + " WHERE " + QUIZ_SCORECARD_ID+ " =  \"" + user + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        QuizScorecard u = new QuizScorecard();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            u.setquiz_scorecard_id(cursor.getInt(0));
            u.setquiz_user_answer_id(cursor.getInt(2));
            u.setquiz_totalmarks(cursor.getInt(3));
            u.setuser_id(cursor.getInt(1));

            cursor.close();
        } else {
            u= null;
        }
        db.close();
        return u;
    }
    public QuizUserAnswer findProductm(int user) {
        String query = "Select * FROM " + TABLE_QUIZ_USER_ANSWER + " WHERE " + QUIZ_USER_ANSWER_ID+ " =  \"" + user + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        QuizUserAnswer m =new QuizUserAnswer();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            m.setquiz_question_id(cursor.getInt(1));
            m.setquiz_user_answer_id(cursor.getInt(0));
            m.setquiz_question_option_id(cursor.getInt(2));
           // u.setuser_id(cursor.getInt(1));

            cursor.close();
        } else {
            m= null;
        }
        db.close();
        return m;
    }
    public QuizQuestionOption findProductn(int user) {
        String query = "Select * FROM " + TABLE_QUIZ_QUESTION_OPTION + " WHERE " + QUIZ_QUESTION_OPTION_ID + " =  \"" + user + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        QuizQuestionOption n = new QuizQuestionOption();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            n.setquiz_question_option_id(cursor.getInt(0));
            n.setquiz_question_id(cursor.getInt(1));
            n.setquiz_question_option_text(cursor.getString(2));
            n.setquiz_question_option_is_correct(cursor.getString(3));
            // u.setuser_id(cursor.getInt(1))

            cursor.close();
        } else {
            n = null;
        }
        db.close();
        return n;


    }
    public Quiz findProductq(int user) {

     String query = "Select * FROM "  +TABLE_Quiz+ " WHERE " + QUIZ_ID + " =  \"" + user + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Quiz q = new Quiz();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            q.setQuizID(cursor.getInt(0));
            q.setQuizTIME(cursor.getInt(2));
            q.setQuizTITLE(cursor.getString(1));


            // u.setuser_id(cursor.getInt(1))

            cursor.close();
        } else {
            q = null;
        }
        db.close();
        return q;


    }
    public QuizQuestion findProductr(int user) {
        String query = "Select * FROM " + TABLE_Quiz_question+ " WHERE " + QUIZ_QUESTION_ID+ " =  \"" + user + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        QuizQuestion r = new QuizQuestion();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            r.setQuizID(cursor.getInt(1));
            r.setQuizquestionID(cursor.getInt(0));
            r.setQuizquestionText(cursor.getString(2));
            r.setQuizqusetionMarks(cursor.getInt(3));

            // u.setuser_id(cursor.getInt(1))

            cursor.close();
        } else {
            r= null;
        }
        db.close();
        return r;


    }




}
