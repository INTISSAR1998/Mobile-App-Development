package com.isima.android.typeexamen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class rechercherClient extends AppCompatActivity {
    AutoCompleteTextView rechercherJ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechercher_client);
        DataBaseController db = new DataBaseController(this,"contact.db",null,1);

        rechercherJ.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,db.convert()));
        rechercherJ.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(rechercherClient.this, String.format("Item"+(position+1)+":"+((TextView)view).getText(),Toast.LENGTH_LONG)).show();
            }
        });
    }
}
