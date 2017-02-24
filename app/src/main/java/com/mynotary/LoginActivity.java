package com.mynotary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mynotary.AsyncTasks.AsyncResponse;
import com.mynotary.AsyncTasks.WebserviceCall;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    EditText emailET,passwordET;
    Button loginBtn,forgetPassBtn,signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailET = (EditText) findViewById(R.id.login_email);
        passwordET = (EditText) findViewById(R.id.login_password);
        loginBtn = (Button) findViewById(R.id.login_login);
        forgetPassBtn = (Button) findViewById(R.id.login_forgot_password);
        signupBtn = (Button) findViewById(R.id.login_signup);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailStr = emailET.getText().toString();
                String passwordStr = passwordET.getText().toString();

                // webservice call for login
                JSONObject object = new JSONObject();
                try {
                    object.put("email",emailStr);
                    object.put("password",passwordStr);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                String jsonRequest = String.valueOf(object);
                String URL = "http://rapidans.esy.es/project/login.php";
                new WebserviceCall(LoginActivity.this, URL, jsonRequest, "Loading...", true, new AsyncResponse() {
                    @Override
                    public void onSuccess(final String message, JSONArray jsonData) {
                            Toast.makeText(LoginActivity.this,message, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(String message) {
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                }).execute();
            }
        });

        forgetPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to forgetPassBtn
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to signup page
            }
        });
    }
}
