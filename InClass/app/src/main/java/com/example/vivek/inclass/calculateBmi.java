package com.example.vivek.inclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class calculateBmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);
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
    }
}
