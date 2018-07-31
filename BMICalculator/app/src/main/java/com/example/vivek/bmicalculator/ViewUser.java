package com.example.vivek.bmicalculator;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewUser extends AppCompatActivity {

    DbHelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);
        populateListView();
    }

    private void populateListView(){
        db = new DbHelper(this);
        Cursor data = db.getUserData();
        ArrayList<String> listData = new ArrayList<>();
/*        String[] strings = new String[_cursor.getCount()];
        _cursor.moveToFirst();
        Integer i=0;
        while(i<_cursor.getCount()) {
            //strings[i]=_cursor.getString()
            i++;
        }*/

        while(data.moveToNext()) {
            listData.add(data.getString(0));
            listData.add(data.getString(1));
            listData.add(data.getString(2));
            listData.add(data.getString(3));
        }
        //System.out.println(listData);
        ListView lv = findViewById(R.id.ViewUser);
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        lv.setAdapter(adapter);

    }
}
