package com.example.vivek.sqltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateBMI extends AppCompatActivity {

    dbHelper db;
    private Button history;
    private EditText height1, weight1;
    private EditText height;
    private EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);

        height = (EditText) findViewById(R.id.textHeight);
        weight = (EditText) findViewById(R.id.textWeight);
        history = (Button) findViewById(R.id.buttonHistory);
        db = new dbHelper(this);
    }

    public void calculate(View view){
        EditText height = (EditText) findViewById(R.id.textHeight);
        String value = height.getText().toString();
        Double heightVal = Double.parseDouble(value);
        System.out.println("Height is "+heightVal);


        EditText weight = (EditText) findViewById(R.id.textWeight);
        String val = weight.getText().toString();
        Double weightVal = Double.parseDouble(val);
        System.out.println("Weight is "+weightVal);

        Double calc = (weightVal/(heightVal*heightVal));
        TextView result = findViewById(R.id.textResult);

        result.setText(calc.toString());

        addBmiData(height, weight);

    }

    public void onHistoryClick(View view){
        Intent intent = new Intent(CalculateBMI.this, BmiLayout.class);
        startActivity(intent);

    }


    public void addBmiData(EditText height, EditText weight){
        boolean insertData = db.addBmiUser(height,weight);
    }


}
