package com.isima.android.exemplechapitre3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ArrayAdapterActivity extends Activity {

    ListView myList;
    String [] myData = {"Lundi", "Mardi", "Mercredi" , "Jeudi", "Vendredi", "Samedi", "Dimanche"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);
        myList = (ListView) findViewById(R.id.myList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myData);
        myList.setAdapter(adapter);

        myList.setOnItemClickListener(mMessageClickHandler);
    }

    // Create a message handling object as an anonymous class.
    private AdapterView.OnItemClickListener mMessageClickHandler = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            // Do something in response to the click
            Toast.makeText(ArrayAdapterActivity.this,"Item "+(position+1)+":"+((TextView)v).getText(),Toast.LENGTH_LONG).show();
        }
    };

}
