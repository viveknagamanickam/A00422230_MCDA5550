package com.example.vivek.bmicalculator;

import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewBmiData extends AppCompatActivity {

    DbHelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bmi_data);
        populateListBmiData();
    }

    private void populateListBmiData(){
        db = new DbHelper(this);
        Cursor data = db.getBmiData();
        ArrayList<String> listData = new ArrayList<>();

        while(data.moveToNext()){
            listData.add(data.getString(0));
            listData.add(data.getString(1));
        }

        ListView lv = findViewById(R.id.ViewBmiData);
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        lv.setAdapter(adapter);
    }
}
