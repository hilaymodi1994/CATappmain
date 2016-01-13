package com.example.mihirmodi.catmain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText e1, user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
         e1 = (EditText) findViewById(R.id.e1);
         user = (EditText) findViewById(R.id.e2);
         password = (EditText) findViewById(R.id.e3);
        Button signup = (Button) findViewById(R.id.b1);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidForm()) {
                    Toast.makeText(signup.this, "login...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signup.this, Home.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean isValidForm() {
        //removes previous error if any
        user.setError(null);
        password.setError(null);
        e1.setError(null);
        String email=e1.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


        boolean result = true;
        if (user.getText().toString().trim().length() <= 5) {
            user.setError("invald user name");
            result = false;
        }

        if (password.getText().toString().trim().length() <= 7) {
            password.setError("Password have atleast 7 charcter");
            result = false;
        }
        if(!email.matches(emailPattern))
        {
            e1.setError("invalid email address  ");
            result = false;
        }
        return result;
    }
}