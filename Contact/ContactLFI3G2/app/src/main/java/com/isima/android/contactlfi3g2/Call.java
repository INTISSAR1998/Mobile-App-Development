package com.isima.android.contactlfi3g2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Call extends Activity {

    TextView result;
    Button call;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_call);

        result = findViewById(R.id.tvResult);
        call = findViewById(R.id.btnCall);
        //1: récupérer l'intent
        Intent i = getIntent();
        String nom_recup = i.getStringExtra("cle_nom");
        final String num_recup = i.getStringExtra("cle_num");
        //2: afficher le nom dans le TV
        result.setText(nom_recup + " est ajouté avec succès");
        //3: action sur le bouton
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //4: intent pour passer l'appel
                Intent intent_call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num_recup));
                startActivity(intent_call);
            }
        });

    }

}











