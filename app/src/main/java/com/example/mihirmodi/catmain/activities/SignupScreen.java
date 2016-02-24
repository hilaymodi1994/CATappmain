package com.example.mihirmodi.catmain.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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

public class SignupScreen extends AppCompatActivity {
    EditText email, user, password;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        findViewById(R.id.pager).requestFocus();
         email = (EditText) findViewById(R.id.e1);
         user = (EditText) findViewById(R.id.e2);
         password = (EditText) findViewById(R.id.e3);
        Button signup = (Button) findViewById(R.id.b1);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidForm()) {
                    Log.d("SIGNUP", "BUtton clicked");
                    try {
                        Log.d("SIGNUP", "Button in try");
                        signup();
                    } catch (Exception e) {
                        Log.d("SIGNUP", "BUtton clicked");
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    private void signup() throws Exception {
       String platformString="android";
        String nameString= user.getText().toString();
        String emailString= email.getText().toString();
        String passwordString=password.getText().toString();
        String hash= HashGenerator.getHashFromString(nameString + emailString + passwordString + platformString);
        Log.d("SIGNUP",nameString+emailString+passwordString + platformString);
        toast=Toast.makeText(this,"Somwthing went wrong",Toast.LENGTH_SHORT);
        RestAdapter restAdapter=new RestAdapter.Builder().setEndpoint(getString(R.string.baseURL)).build();
        CatappRetrofitService service=restAdapter.create(CatappRetrofitService.class);
        service.signup(nameString, emailString, passwordString,platformString, hash, new Callback<JsonObject>() {
            @Override
            public void success(JsonObject jsonObject, Response response) {

                Log.d("SignupScreen", "response:" + jsonObject);
                if (jsonObject.has("msg")&& jsonObject.get("msg").getAsString().equals("Users registered succesfully")) {
                    toast.setText("SignupScreen done");
                    toast.show();
                    Intent intent = new Intent(SignupScreen.this, HomeScreen.class);
                    startActivity(intent);
                } else {
                    toast.setText("Something went wrong. Try to register again in sometime.or Email already registered. Press back to view login screen");
                    toast.show();
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
        email.setError(null);
        String email= this.email.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


        boolean result = true;
        if (user.getText().toString().trim().length() <= 5) {
            user.setError("invald Users name");
            result = false;
        }

       if (password.getText().toString().trim().length() <= 7) {
            password.setError("Password have atleast 7 charcter");
           result = false;
        }
       if(!email.matches(emailPattern))
        {
           this.email.setError("invalid email address  ");
            result = false;
       }
        return result;
    }
    public void back(View v)
    {
        Intent i =new Intent(this,LoginScreen.class);
        startActivity(i);
    }
}