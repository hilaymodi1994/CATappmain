package com.example.mihirmodi.catmain.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import com.example.mihirmodi.catmain.models.Categories;
import com.example.mihirmodi.catmain.models.Question;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;
    //private static final String DATABASE_NAME = "Catapp";
    //private static TestsDataSQLHelper mInstance = null;
    private static final int DATABASE_VERSION = 2;
    public static String PackageName = "com.example.mihirmodi.catmain";
    //The Android's default system path of your application database.
    private static String DB_PATH = Environment.getDataDirectory() + "/data/" + PackageName + "/databases/";
    private SQLiteDatabase myDataBase;
    private static String DB_NAME = "catappdb.sqlite";
    private static String DB_NAME_1 = "catappdb1";
    private static String DB_NAME_2 = "catappdb2";
    private Context myContext;
    // Table name
    public static final String USERS_TABLE_NAME = "users";
    public static final String QUESTIONS_TABLE_NAME = "questions";
    public static final String OPTIONS_TABLE_NAME = "options";
    public static final String ATTEMPTS_TABLE_NAME = "attempts";
    public static final String ATTEMPT_DETAIL_TABLE_NAME = "attempt_details";
    public static final String TESTS_TABLE_NAME = "tests";
    public static final String CATEGORIES_TABLE_NAME = "categories";
    public static final String QUESTION_CATEGORIES_TABLE_NAME = "question_categories";
    // Columns
    public static final String FullName = "fullname";
    public static final String PhoneNo = "phoneno";
    public static final String EmailId = "email";
    public static final String Registered = "registered";

    public static final String TestId = "t_id";
    public static final String UserId = "u_id";
    public static final String TimeStamp = "timpstamp";
    public int oldversion = -1;
    public static final String DB_FULL_PATH = DB_PATH + DB_NAME;
    //public static final String publishingPlatformURL = "http://iwpublish.herokuapp.com/api/v1/";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
        this.myContext = context;

    }
	/*public static TestsDataSQLHelper getInstance(Context ctx) {
        *//**
     * use the application context as suggested by CommonsWare.
     * this will ensure that you dont accidentally leak an Activitys
     * context (see this article for more information:
     * http://developer.android.com/resources/articles/avoiding-memory-leaks.html)
     *//*
        if (mInstance == null) {
            mInstance = new TestsDataSQLHelper(ctx);
        }
        return mInstance;
    }*/

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     */
    public void createDataBase() throws Exception {

        boolean dbExist = checkDataBase();

        if (dbExist) {
            //do nothing - database already exist
        } else {

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();
//                copyTestLogo();
//                copyImageFiles();
//                copyExtraFiles();

                //-- Add registered user field and remove primary key index from attempt details.
                //SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_FULL_PATH, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.OPEN_READWRITE);

            } catch (IOException e) {

                throw new Exception("Error copying database");

            }
        }

    }

    private boolean checkDataBase() {

        SQLiteDatabase checkDB = null;

        try {
            checkDB = SQLiteDatabase.openDatabase(DB_FULL_PATH, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.OPEN_READONLY);
            checkDB.close();
        } catch (Exception e) {
            //database does't exist yet.
            Log.d("DB", "Db does not exist-" + e.getMessage());
            return false;
        }

        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {
        try {

            // Path to the just created empty db
            String outFileName = DB_PATH + DB_NAME;

            //Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);

            //transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;

            InputStream myInput = myContext.getAssets().open(DB_NAME_1);
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer);
            }

            myInput = myContext.getAssets().open(DB_NAME_2);
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer);
            }
            //Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void copyImageFiles() {
        AssetManager assetManager = myContext.getAssets();
        String assets[] = null;
        try {
            // Delete files from queadaydbimages folder as new image structure in use
            File imgfolder = new File(Environment.getDataDirectory() + "/data/" + PackageName + "/QueADayDBImages/");
            // FileUtil.deleteFolder(imgfolder);


            File file = new File(Environment.getDataDirectory() + "/data/" + PackageName + "/Images");
            file.mkdir();
            // create new image structure
            assets = assetManager.list("");
            InputStream is;
            for (int i = 0; i < assets.length; i++) {

                file = new File(Environment.getDataDirectory() + "/data/" + PackageName + "/Images/" + assets[i].split("_")[0]);
                if (file.exists() != true) {
                    file.mkdir();
                } else {
                    if (file.length() == 0) {
                        file.mkdir();
                    }
                }

                file = new File(Environment.getDataDirectory() + "/data/" + PackageName + "/Images/" + assets[i].split("_")[0] + "/queimages");
                if (file.exists() != true) {
                    file.mkdir();
                } else {
                    if (file.length() == 0) {
                        file.mkdir();
                    }
                }

                is = assetManager.open(assets[i]);
                file = new File(Environment.getDataDirectory() + "/data/" + PackageName + "/Images/" + assets[i].split("_")[0] + "/queimages/" + assets[i].split("_")[1] + "_" + assets[i].split("_")[2]);
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileOutputStream out = new FileOutputStream(file);

                byte b[] = new byte[4096];
                while (is.read(b) != -1) {
                    out.write(b);
                }
                out.close();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void copyExtraFiles() {
        AssetManager assetManager = myContext.getAssets();
        String[] files = null;
        try {
            files = assetManager.list("Extra");
        } catch (IOException e) {
            Log.e("tag", e.getMessage());
        }

        for (String filename : files) {
            System.out.println("File name => " + filename);
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open("Extra/" + filename);   // if files resides inside the "Files" directory itself
                out = new FileOutputStream(Environment.getDataDirectory() + "/data/" + PackageName + "/" + filename);
                byte[] buffer = new byte[1024];
                int read;
                while ((read = in.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
                in.close();
                in = null;
                out.flush();
                out.close();
                out = null;
            } catch (Exception e) {
                Log.e("tag", e.getMessage());
            }
        }
    }

    public void copyTestLogo() {
        AssetManager assetManager = myContext.getAssets();
        String[] files = null;
        try {
            files = assetManager.list("testlogo");
        } catch (IOException e) {
            Log.e("tag", e.getMessage());
        }

        File file = new File(Environment.getDataDirectory() + "/data/" + PackageName + "/Images");
        if (file.exists() != true)
            file.mkdir();

        for (String filename : files) {
            InputStream in = null;
            try {
                in = assetManager.open("testlogo/" + filename);   // if files resides inside the "Files" directory itself
                file = new File(Environment.getDataDirectory() + "/data/" + PackageName + "/Images/" + filename.split("_", 2)[0]);
                if (file.exists() != true)
                    file.mkdir();

                file = new File(Environment.getDataDirectory() + "/data/" + PackageName + "/Images/" + filename.split("_", 2)[0] + "/logo");
                if (file.exists() != true)
                    file.mkdir();

                file = new File(Environment.getDataDirectory() + "/data/" + PackageName + "/Images/" + filename.split("_", 2)[0] + "/logo/" + filename.split("_", 2)[1]);
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileOutputStream out = new FileOutputStream(file);

                byte b[] = new byte[4096];
                while (in.read(b) != -1) {
                    out.write(b);
                }
                out.close();
            } catch (Exception e) {
                Log.e("tag", e.getMessage());
            }
        }
    }

    public SQLiteDatabase openDataBase() throws SQLException {

        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.OPEN_READONLY);
        return myDataBase;
    }

    @Override
    public synchronized void close() {

        if (myDataBase != null && myDataBase.isOpen())
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DB", "Oncreate called");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("DB", "onUpgrade called");
        oldversion = oldVersion;
        if (oldVersion == 1) {
            // copyTestLogo();
            //  copyImageFiles();
            // copyExtraFiles();

        }

        if (oldVersion >= newVersion)
            return;
    }

    // Add your public helper methods to access and get content from the database.
    // You could return cursors by doing "return myDataBase.query(....)" so it'd be easy
    // to you to create adapters for your views.
    public void insertcat(Categories q) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", q.getId());
        contentValues.put("name", q.getName());
        db.insert(CATEGORIES_TABLE_NAME, null, contentValues);

        db.close();
    }

    //getContact()
    // Getting single contact
    public Categories getcat(int user) {

        String query = "Select * FROM " + CATEGORIES_TABLE_NAME + " WHERE " + "_id" + " =  \"" + user + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Categories q = new Categories();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            q.setId(cursor.getInt(0));
            // q.setQuiz_time(cursor.getInt(2));
            q.setName(cursor.getString(1));


            // u.setuser_id(cursor.getInt(1))

            cursor.close();
        } else {
            q = null;
        }
        db.close();
        return q;


    }

    // updateContact()
    // Updating single contact
    public int updateCat(Categories q) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", q.getName());
        values.put("_id", q.getId());

        // updating row
        return db.update(CATEGORIES_TABLE_NAME, values, "_id" + " = ?",
                new String[]{String.valueOf(q.getId())});
    }


    //deleteContact()
    // Deleting single contact
    public void deleteCat(Categories q) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(CATEGORIES_TABLE_NAME, "_id" + " = ?",
                new String[]{String.valueOf(q.getId())});

    }

    public ArrayList<Categories> getAlldata() {
        ArrayList<Categories> categories = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String[] columns = {"_id","name"};
        Cursor cursor = db.query(CATEGORIES_TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                //create a new Games object and retrieve the data from the cursor to be stored in this Games object
                Categories cat = new Categories();
                //each step is a 2 part process, find the index of the column first, find the data of that column using
                //that index and finally set our blank Games object to contain our data
                cat.setId(cursor.getInt(cursor.getColumnIndex("_id")));

                cat.setName(cursor.getString(cursor.getColumnIndex("name")));




                categories.add(cat);
            } while (cursor.moveToNext());
        }
        return categories;
    }

    public ArrayList<Question> getAllquestion() {
        ArrayList<Question> questionsArrayList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String[] columns = {"_id","header","content","image_file","answer_text","image_file_ans","year","name","t_id"};
        Cursor cursor = db.query(QUESTIONS_TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                //create a new Games object and retrieve the data from the cursor to be stored in this Games object
                Question questions = new Question();
                //each step is a 2 part process, find the index of the column first, find the data of that column using
                //that index and finally set our blank Games object to contain our data
                questions.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                questions.setHeader(cursor.getString(cursor.getColumnIndex("header")));
                questions.setContent(cursor.getString(cursor.getColumnIndex("content")));
               // questions.setImageUrl(cursor.getString(cursor.getColumnIndex("image_file")));
               // questions.setAnswerText(cursor.getString(cursor.getColumnIndex("answer_text")));
               // questions.setImageUrlAns(cursor.getString(cursor.getColumnIndex("image_file_ans")));
               // questions.setYear(cursor.getString(cursor.getColumnIndex("year")));
              //  questions.setName(cursor.getString(cursor.getColumnIndex("name")));
               // questions.setTid(cursor.getInt(cursor.getColumnIndex("tid")));




                questionsArrayList.add(questions);
            } while (cursor.moveToNext());
        }
        return questionsArrayList;
    }
}