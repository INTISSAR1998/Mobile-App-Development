package com.isima.android.typeexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AjoutActivity extends AppCompatActivity {

    EditText nom,numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        nom = findViewById(R.id.edNom);
        numero = findViewById(R.id.edNumero);
    }

    public void save(View view) {
        nom = findViewById(R.id.edNom);
        numero = findViewById(R.id.edNumero);
        String n = nom.getText().toString();
        String num = numero.getText().toString();
        Contact c = new Contact(n,num);
        DateBaseHandler db = new DateBaseHandler(this,"contact.db",null,1);
        db.ajoutercontact(c);
    }
}
