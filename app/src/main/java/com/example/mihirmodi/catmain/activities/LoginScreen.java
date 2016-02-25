package com.example.mihirmodi.catmain.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mihirmodi.catmain.interfaces.CatappRetrofitService;
import com.example.mihirmodi.catmain.utils.HashGenerator;
import com.example.mihirmodi.catmain.R;
import com.google.gson.JsonObject;

import retrofit.Callback;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class LoginScreen extends AppCompatActivity {
    EditText user;
    EditText password;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.loginscreen);
        findViewById(R.id.pager).requestFocus();
        user = (EditText) findViewById(R.id.user);

        password = (EditText) findViewById(R.id.password);
        Button signin=(Button)findViewById(R.id.sign_in);




        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("LOGIN", "BUtton clicked");
                if (isValidForm()) {
                    try {
                        Log.d("LOGIN", "Form validated");
                        login();
                    } catch (Exception e) {
                        Log.d("LOGIN", "Login exception");
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void login() throws Exception {
        String emailString=user.getText().toString();
        String passwordString=password.getText().toString();
        String hash= HashGenerator.getHashFromString(emailString + passwordString);
        Log.d("LOGIN",emailString + passwordString+hash);
        toast=Toast.makeText(this,"Somwthing went wrong",Toast.LENGTH_SHORT);
        RestAdapter restAdapter=new RestAdapter.Builder().setEndpoint(getString(R.string.baseURL)).build();
        CatappRetrofitService service=restAdapter.create(CatappRetrofitService.class);

        service.login(emailString, passwordString, hash, new Callback<JsonObject>() {
            @Override
            public void success(JsonObject jsonObject, Response response) {

                Log.d("Login", "response:" + jsonObject);
                if (jsonObject.has("authorized") && jsonObject.get("authorized").getAsBoolean()==false) {
                    toast.setText("Invalid username / password");
                    toast.show();
                } else {
                    toast.setText("Login done");
                    toast.show();

                    Intent intent = new Intent(LoginScreen.this,HomeScreen.class);
                    startActivity(intent);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }





    private boolean isValidForm() {
        //removes previous error if any
        user.setError(null);
        password.setError(null);

        boolean result=true;
        if(user.getText().toString().trim().length()==0){
            user.setError("Username can not be blank");
            result=false;
        }

        if(password.getText().toString().trim().length()==0){
            password.setError("Password can not be blank");
            result=false;
        }
        return result;
    }






    public void signup(View view)
    {
        
        Intent intent=new Intent(this,SignupScreen.class);
        startActivity(intent);
    }

}
