package com.isima.android.tp02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

public class Notes extends AppCompatActivity {
    ListView notesList;
    String [] mesNotes = {"12.5", "4.75", "15", "10.25", "7.5","16.75"};
    String[] mesMatieres ={"Matière1", "Matière2", "Matière3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        notesList = (ListView) findViewById(R.id.notesList);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mesNotes);
        notesList.setAdapter(listAdapter);
        //notesList.setAdapter(new MaLigneAdapter(this,new String[0]));
        notesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                // behaviour when you click on the item"view"
                String s = (String) notesList.getItemAtPosition(i);
                Float f = Float.valueOf(s);

                if(f >= 10) {
                    Toast.makeText(getApplicationContext(), "Réussi", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Echoué", Toast.LENGTH_SHORT).show();
                }

            }
        });
        AutoCompleteTextView matieresTV = (AutoCompleteTextView) findViewById(R.id.matieresTV);
        matieresTV.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,mesMatieres));

        matieresTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        //notesList=(ListView) findViewById(list);
        //notesList.setAdapter(new MaLigneAdapter(this, mesNotes));
    }

}
