package com.example.mihirmodi.catmain;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ScrollingView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import retrofit.Callback;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class login1 extends AppCompatActivity {
    EditText user;
    EditText password;
    Toast toast;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        user = (EditText) findViewById(R.id.user);

        password = (EditText) findViewById(R.id.password);
        key = "578wefhjw824bfa78r3j4brdfuo3b87fsja839rwqbwe8w3brwe8fb39";
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
        String hash=getHashFromString(emailString + passwordString);
        Log.d("LOGIN",emailString+passwordString+hash);
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

                    Intent intent = new Intent(login1.this, Home.class);
                    startActivity(intent);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }

    private String getHashFromString(String _stringToConvert) throws Exception {
        String hash = "";

        Mac mac = Mac.getInstance("hmacSHA256");
        SecretKeySpec secret = new SecretKeySpec(key.getBytes("ASCII"), mac.getAlgorithm());
        mac.init(secret);
        byte[] digest;
        digest = mac.doFinal(_stringToConvert.getBytes());
        hash = Base64.encodeBytes(digest);
        return hash;
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
        
        Intent intent=new Intent(this,signup.class);
        startActivity(intent);
    }

}
