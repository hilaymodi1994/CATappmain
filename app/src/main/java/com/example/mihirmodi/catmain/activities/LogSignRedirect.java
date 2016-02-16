package com.example.mihirmodi.catmain.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mihirmodi.catmain.R;

public class LogSignRedirect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsingredirect);

    }

    public void login(View v)
    {

        Intent intent=new Intent(this,LoginScreen.class);
        startActivity(intent);
    }
    public void signup(View v)
    {

        Intent intent=new Intent(this,SignupScreen.class);
        startActivity(intent);
    }

}
