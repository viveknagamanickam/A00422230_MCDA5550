package com.example.vivek.bmicalculator;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddUser extends AppCompatActivity {

    DbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        db = new DbHelper(this);
    }

    public void goToUserView(View view){

        EditText textName = (EditText) findViewById(R.id.textName);
        EditText textHealthCardNumber = (EditText) findViewById(R.id.textHcn);
        EditText textCreatePassword = (EditText) findViewById(R.id.textCreatePassword);
        EditText textDob = (EditText) findViewById(R.id.textDob);

        String name = textName.getText().toString();
        int healthCardNumber = 0;

        if(TextUtils.isEmpty(textHealthCardNumber.getText()))
            healthCardNumber = 0;
            else {
                Log.e("Error",textHealthCardNumber.getText().toString());
            healthCardNumber = Integer.parseInt(textHealthCardNumber.getText().toString());
        }
        String password = textCreatePassword.getText().toString();
        String dob = textDob.getText().toString();

        if((name.equals(""))|| (healthCardNumber==0)||(password.equals(""))||(dob.equals("")) ){
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("ALERT !");
            alertDialog.setMessage("Fill all the fields");
            alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alertDialog.show();
        } else {
            addData(name, healthCardNumber, password, dob);
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("SUCCESS !!");
            alertDialog.setMessage("NEW USER REGISTERED");
            alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alertDialog.show();
        }
//        Intent intent = new Intent (this,ViewUser.class);
//        startActivity(intent);

    }

    public void goToUserDataView(View view){
        Intent intent = new Intent (this,ViewUser.class);
        startActivity(intent);
    }

    public void goToCalculatePage(View view){
        Intent intent = new Intent(this,CalculateBmi.class);
        startActivity(intent);
    }



    public void addData(String name, int healthCardNumber, String password, String dob){

        db.addUser(name,healthCardNumber,password,dob);
    }
}
