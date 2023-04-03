package com.isima.android.tp2part1;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import static android.R.id.list;

public class Notes extends ListActivity {
    private AutoCompleteTextView matieresTV;
    private ListView notesList;
    private String [] mesNotes={"12.5", "4.75", "15", "10.25", "7.5", "16.75"};
    private String [] mesMatieres={"Matiere1","Matiere2","Matiere3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        /*notesList=(ListView) findViewById(R.id.notesList);
        final ArrayAdapter<String> ListAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,mesNotes);
        notesList.setAdapter(ListAdapter);

        notesList.setAdapter(new MaLigneAdapter(this,new String[0])); */

        matieresTV = (AutoCompleteTextView) findViewById(R.id.matieresTV);
        matieresTV.setAdapter(new  ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, mesMatieres));

        matieresTV.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //behaviour when an item "view" is clicked

                notesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //behaviour when you click on the item "view"
                        String s =(String) parent.getItemAtPosition(position);
                        double value=Double.valueOf(s);
                        if ( value > 10 )
                            Toast.makeText(Notes.this,"Réussi", Toast.LENGTH_SHORT).show();
                        else  Toast.makeText(Notes.this,"Echoué", Toast.LENGTH_SHORT).show();}
                });
            }
            });

                /*String value =(String) adapterView.getItemAtPosition(i);*/
                notesList=(ListView) findViewById(list);
                notesList.setAdapter(new MaLigneAdapter(this, mesNotes));

         }

}



