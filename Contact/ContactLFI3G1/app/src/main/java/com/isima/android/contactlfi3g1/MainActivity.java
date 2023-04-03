package com.isima.android.contactlfi3g1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText numero, nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = findViewById(R.id.edNum);
        nom = findViewById(R.id.edNom);

    }

    public void ajouterContact(View view) {
        //méthode qui permettra l'insertion dans la bd et
        // la redirection vers l'activité "Call.java"
        String _numero = numero.getText().toString();
        String _nom = nom.getText().toString();

        //1: redirection vers call
        Intent myIntent = new Intent(getApplicationContext(), Call.class);
        //2:remplir l'intent avec les informations à envoyer
        myIntent.putExtra("cle_nom", _nom);
        myIntent.putExtra("cle_num", _numero);
        //3:démarrer l'intent
        startActivity(myIntent);
    }
}



