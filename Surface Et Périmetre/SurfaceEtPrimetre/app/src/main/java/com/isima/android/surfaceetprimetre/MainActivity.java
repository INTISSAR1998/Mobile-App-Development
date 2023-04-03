package com.isima.android.surfaceetprimetre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.edLargeur);
        e2 = (EditText) findViewById(R.id.edLongueur);
        result = findViewById(R.id.res);
    }

    public void cSurface (View v){
        String slargeur = e1.getText().toString();
        String slongueur= e2.getText().toString();
        Float largeur = Float.valueOf(slargeur);
        Float longueur = Float.valueOf(slongueur);
        result.setText("La surface est : "+(largeur*longueur));
    }

    public void cPérimetre (View v) {
        String slargeur = e1.getText().toString();
        String slongueur = e2.getText().toString();
        Float largeur = Float.valueOf(slargeur);
        Float longueur = Float.valueOf(slongueur);
        result.setText("Le périmetre est : "+((largeur+longueur)*2));
    }

}
