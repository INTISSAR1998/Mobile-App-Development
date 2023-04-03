package com.isima.android.contactlfi3g1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Call extends Activity{

    TextView result;
    Intent i;
    String nom_recup, num_recup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        i = getIntent();
        //récupérer les variables envoyées par l'intent à travers leurs clés
        nom_recup = i.getStringExtra("cle_nom");

        num_recup = i.getStringExtra("cle_num");
        result = findViewById(R.id.tvResult);

        result.setText(nom_recup+" est ajouté avec succès  "+num_recup);

        Button btnCall = findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //concernant l'intent implicite, l'uri doit commencer par tel: si on veut passer un appel
                //sms: si on veut envoyer un message ....
                Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num_recup));
                startActivity(call);
            }
        });
    }

}
