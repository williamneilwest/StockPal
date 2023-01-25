package com.example.stockpal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupPage extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd, btnViewData, btnDelete;
    private EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        editTextEmail = (EditText) findViewById(R.id.emailField);
        editTextPassword = (EditText) findViewById(R.id.passwordField);

        btnAdd = (Button) findViewById(R.id.createAccount);

        mDatabaseHelper = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String newEntry = editTextEmail.getText().toString() + editTextPassword.getText().toString();
                if (editTextEmail.length() != 0) {
                    AddData(newEntry);
                    editTextEmail.setText("");
                }
                else{
                    toastMessage("You must enter something into the field!");
                }
            }
        });
    }
    public void AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);
        if(insertData) {
            toastMessage("Data Successfully Inserted!");
        }
        else {
            toastMessage("Something went wrong!");
        }

    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}