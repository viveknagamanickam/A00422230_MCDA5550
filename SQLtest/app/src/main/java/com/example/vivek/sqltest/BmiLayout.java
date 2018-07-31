package com.example.vivek.sqltest;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BmiLayout extends AppCompatActivity {

    dbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_layout);
        populateBmiListView();
    }

    public void populateBmiListView(){
        db = new dbHelper(this);
        Cursor data = db.getBmiData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(0));
            listData.add(data.getString(1));

        }

        ListView lv =findViewById(R.id.listBmiView);
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        lv.setAdapter(adapter);
    }
}
