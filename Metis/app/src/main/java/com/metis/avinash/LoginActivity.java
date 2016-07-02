package com.metis.avinash;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.JsonObject;
import com.metis.avinash.Models.LoginModel;
import com.metis.avinash.WebUtils.RestClient;

import java.util.HashMap;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPref sp = new SharedPref();
        String token = sp.getAccessToken(this);
        if (token != "missing") {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }
        else {
            final EditText username = (EditText) findViewById(R.id.et_username);
            final EditText password = (EditText) findViewById(R.id.et_password);
            Button b_login = (Button) findViewById(R.id.b_login);

            b_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    HashMap<String, String> loginMap = new HashMap<String, String>();
                    loginMap.put("username", username.getText().toString());
                    loginMap.put("password", password.getText().toString());


                    RestClient.get().loginUser(loginMap, new Callback<LoginModel>() {
                        @Override

                        public void success(LoginModel loginModel, Response response) {
                            String auth_token = loginModel.token;
                            SharedPref.setAccessToken(getBaseContext(), auth_token);
                            Intent i = new Intent(getBaseContext(), MainActivity.class);
                            startActivity(i);
                            finish();
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            //Toast.makeText()

                        }
                    });

                }
            });

        }
    }



    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
        .setMessage("Are you sure?")
        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        }).setNegativeButton("no", null).show();
    }
}
