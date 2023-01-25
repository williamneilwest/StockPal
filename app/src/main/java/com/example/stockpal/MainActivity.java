package com.example.stockpal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    private final String TAG = "Lifecycle";
    DatabaseHelper mDatabaseHelper;
    private Button btnLogin;
    private EditText emailBox;
    private EditText passwordBox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
        btnLogin = (Button) findViewById(R.id.buttonLogin);
        emailBox = (EditText) findViewById(R.id.emailFill);
        passwordBox = (EditText) findViewById(R.id.passwordFill);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String credentials = emailBox.getText().toString() + passwordBox.getText().toString();
                if (emailBox.length() != 0) {
                    UserAuth(credentials);

                }
                else{
                    toastMessage("You must enter something into the field!");
                }
            }
        });



    }



    public void goToSignupPage(View view){
        Intent intent = new Intent(this, SignupPage.class);
        startActivity(intent);

    }

    public void UserAuth(String credentials){
        mDatabaseHelper = new DatabaseHelper(this);
        Cursor data = mDatabaseHelper.getData();
        boolean auth = false;
        while(data.moveToNext()){
            if(data.getString(1).equals(credentials)){
                auth = true;


            }
        }

        if(auth) {
            toastMessage("Data Successfully Inserted!");
            toastMessage("Logging In");
            Log.d(TAG, "Logging In");
        }
        else {
            toastMessage("Something went wrong!");
        }

    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }



}