package com.example.vivek.bmicalculator;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    DbHelper db;
    public String username;
    public String storedPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       //db = new DbHelper(getApplicationContext());

    }


    public void login(View view){

        db = new DbHelper(getApplicationContext());

        EditText textUsername = (EditText) findViewById(R.id.textUserName);
        EditText textPassword = (EditText) findViewById(R.id.textPassword);
        username = textUsername.getText().toString();
        String password = textPassword.getText().toString();
        if(username.equals("")||password.equals("")){
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("ALERT !");
            alertDialog.setMessage("Fill both the fields");
            alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alertDialog.show();
        }

        if(!username.equals("")){
            storedPassword = db.getSingleEntry(username);
            if(password.equals(storedPassword)){
                Intent intent = new Intent(this,CalculateBmi.class);
                startActivity(intent);
            }
            else {
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("OOPS");
                alertDialog.setMessage("Incorrect Username or password");
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertDialog.show();
            }

        }
    }

    public void goToAddUser(View view){
        Intent intent = new Intent(this,AddUser.class);
        startActivity(intent);
    }
}
