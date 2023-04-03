package com.isima.android.contactlfi3g2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nom, numero;
    String ch_nom, ch_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.edNom);
        numero = findViewById(R.id.edNum);

        ch_nom = nom.getText().toString();
        ch_num = numero.getText().toString();

    }

    public void ajouter(View view) {

        //1: création de l'intent
        Intent myIntent = new Intent(this, Call.class);
        //2: charger l'intetn avec les onformations à envoyer
        myIntent.putExtra("cle_nom", ch_nom);
        myIntent.putExtra("cle_num", ch_num);
        //3: démarrer l'intent
        startActivity(myIntent);

    }

}








