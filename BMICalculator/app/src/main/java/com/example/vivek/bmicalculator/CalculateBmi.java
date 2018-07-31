package com.example.vivek.bmicalculator;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateBmi extends AppCompatActivity {

    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);
        db = new DbHelper(this);
    }

   public void calculate(View view){
        EditText heightValue = (EditText) findViewById(R.id.textHeight);
        int height;
        if(TextUtils.isEmpty(heightValue.getText()))
            height =0;
        else{
            height =Integer.parseInt(heightValue.getText().toString());
        }
        Double h = Double.parseDouble(String.valueOf(height));

        EditText weightValue = (EditText) findViewById(R.id.textWeight);
        int weight;
        if(TextUtils.isEmpty(weightValue.getText()))
            weight =0;
        else{
            weight = Integer.parseInt(weightValue.getText().toString());
        }

        if(height ==0 || weight ==0){
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("ALERT !");
            alertDialog.setMessage("Enter height and weight");
            alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alertDialog.show();
        }

        Double w = Double.parseDouble(String.valueOf(weight));

        Double calc = (w/(h*h));
        TextView result = findViewById(R.id.ViewBmiResult);

        result.setText(calc.toString());

        addBmiData(height,weight);

   }

   public void viewHistory(View view){
       Intent intent = new Intent(this,ViewBmiData.class);
       startActivity(intent);
   }

   public void addBmiData(int height, int weight){
       db.addBmiUser(height,weight);
   }
}
