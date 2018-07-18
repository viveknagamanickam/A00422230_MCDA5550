package com.example.vivek.sqltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    dbHelper db;
    private Button buttonSubmit, buttonView;
    private EditText textDate, textHealthCardNumber, textPassword, textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = (EditText) findViewById(R.id.textName);
        textDate = (EditText) findViewById(R.id.textDate);
        textHealthCardNumber = (EditText) findViewById(R.id.textHealthCardNumber);
        textPassword = (EditText) findViewById(R.id.textPassword);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        db = new dbHelper(this);

/*        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = textName.getText().toString();
                String date = textDate.getText().toString();
                String healthCardNumber = textHealthCardNumber.getText().toString();
                String password = textPassword.getText().toString();
                textName.setText("");
                textDate.setText("");
                textHealthCardNumber.setText("");
                textPassword.setText("");
                addData(name, date, healthCardNumber, password);
            }
        });*/

/*        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Layout.class);
                startActivity(intent);
            }
        });*/
    }

    public void onViewClick(View v) {
        Intent intent = new Intent(MainActivity.this, Layout.class);
        startActivity(intent);

    }

    public void onClick(View view) {
        String name = textName.getText().toString();
        String date = textDate.getText().toString();
        String healthCardNumber = textHealthCardNumber.getText().toString();
        String password = textPassword.getText().toString();
        textName.setText("");
        textDate.setText("");
        textHealthCardNumber.setText("");
        textPassword.setText("");
        addData(name, date, healthCardNumber, password);

        Intent intent = new Intent(MainActivity.this, CalculateBMI.class);
        startActivity(intent);
    }


    public void addData(String name, String date, String healthCardNumber, String password){
        boolean insertData = db.addUser(name,date,healthCardNumber,password);

        }
    }


