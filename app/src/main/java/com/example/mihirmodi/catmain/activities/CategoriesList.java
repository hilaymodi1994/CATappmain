package com.example.mihirmodi.catmain.activities;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Categories;
import com.example.mihirmodi.catmain.utils.DatabaseHelper;

import java.util.List;

public class CategoriesList extends AppCompatActivity {
    DatabaseHelper db = new DatabaseHelper(this);
    Categories q = new Categories();
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);
        try {
            db.createDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        t = (TextView) findViewById(R.id.t11);
        Button b1=(Button)findViewById(R.id.btn_display);
        Button b2=(Button)findViewById(R.id.btn_insrt);
        Button b3=(Button)findViewById(R.id.btn_delete);
        Button b4=(Button)findViewById(R.id.btn_update);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Categories q =
                        db.getcat(135);
                Log.d("Insert", "Insert raw");

                if (q != null) {
                    t.setText("" + (q.getId()) + "\n" + (q.getName()));
                } else {
                    t.setText("No Match Found");
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q.setId(135);
                q.setName("data");// q.setQuiz_title("Data Inter Pretation");
                db.insertcat(q);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    q.setId(135);
                db.deleteCat(q);
                Log.d("Insert", "Insert raw");



            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                q.setId(135);
                q.setName("dataquestion");// q.setQuiz_title("Data Inter Pretation");
                db.updateCat(q);
            }
        });

    }

    /*public Categories getCat(int id) {
        Categories q =
                db.getcat(104);
        Log.d("Insert", "Insert raw");

        if (q != null) {
            t.setText("" + (q.getId()) + "\n" + (q.getName()));
        } else {
            t.setText("No Match Found");
        }
        return q;
    }*/
    public int updateCnotact( Categories q) {
        q.setId(135);
        q.setName("datac");
        return 0;
    }
}




