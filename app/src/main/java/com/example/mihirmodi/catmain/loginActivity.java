package com.example.mihirmodi.catmain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void login(View v)
    {
        Toast.makeText(this, "hiii", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,login1.class);
        startActivity(intent);
    }
    public void signup(View v)
    {
        Toast.makeText(this, "hiii", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,signup.class);
        startActivity(intent);
    }

}
