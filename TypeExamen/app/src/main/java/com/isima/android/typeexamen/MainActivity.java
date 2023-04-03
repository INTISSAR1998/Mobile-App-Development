package com.isima.android.typeexamen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ajout(View view){
        EditText NomE = findViewById(R.id.Edt_nom);
        String Nom = NomE.getText().toString();
        EditText NumE = findViewById(R.id.Edt_num);
        String Num = NumE.getText().toString();
        Contact con = new Contact(Nom,Num);
        DataBaseController db = new DataBaseController(this,"contact.db",null,1);
        db.insertContact(con);
        Toast.makeText(MainActivity.this,"Ajout réussi:",Toast.LENGTH_LONG).show();
    }

    public void showPopup(final View view) {
        final Intent i = new Intent(this, rechercherClient.class);
        final Intent ii = new Intent(this, AfficherContact.class);
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener((item) {
        switch (item.getItemId()) {
            case R.id.action_afficher:
                startActivity(ii);
                return true;
            case R.id.action_ajouter:
                Toast.makeText(MainActivity.this, "Vous etes dans cette page", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_rechercher:
                startActivity(i);
                return true;
            default:
                return false;
        }
    });
        popup.inflate(R.menu.action);
        popup.show();
    }
}
