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
    private EditText editText, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        editText = (EditText) findViewById(R.id.nameFirstField);
        editText2 = (EditText) findViewById(R.id.nameLastField);

        btnAdd = (Button) findViewById(R.id.createAccount);

        mDatabaseHelper = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String newEntry = editText.getText().toString() + editText2.getText().toString();
                if (editText.length() != 0) {
                    AddData(newEntry);

                    editText.setText("");
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