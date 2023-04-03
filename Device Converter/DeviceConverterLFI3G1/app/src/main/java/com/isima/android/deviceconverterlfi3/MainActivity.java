package com.isima.android.deviceconverterlfi3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText montant;
    RadioButton etd, dte;
    TextView result;

    double montantConverti=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Associer les éléments Java aux éléments XML
        //id_java = findViewById(id_xml)
        montant = findViewById(R.id.etMontant);
        etd =findViewById(R.id.rbetd);
        dte = findViewById(R.id.rbdte);
        //    convert = findViewById(R.id.btnConvert);
        result = findViewById(R.id.tvResult);

        //Action sur le bouton
  /*      convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //méthode qui contient le comportement du bouton
                //1: récupérer le contenu de l'EditText
                //NB: tout ce qui est écrit dans un EditText ou TextView est de type String
                String mnt = montant.getText().toString();
                //tester si le champ est vide
                if(!mnt.equals("")){
                    double mntToConvert = Double.valueOf(mnt);
                    if(etd.isChecked()){
                        montantConverti = mntToConvert *3.3;

                    }
                    else
                        if(dte.isChecked()){
                            montantConverti = mntToConvert / 3.3;

                        }
                        else
                            Toast.makeText(getApplicationContext(), "Veuillez choisir une option !", Toast.LENGTH_LONG).show();


                    result.setText(""+montantConverti);
                       /* String mntConverti = String.valueOf(montantConverti);
                        result.setText(mntConverti);
                }
                else



            }
        });

*/

    }


    public void convert(View view) {
        //méthode qui contient le comportement du bouton
        //1: récupérer le contenu de l'EditText
        //NB: tout ce qui est écrit dans un EditText ou TextView est de type String
        String mnt = montant.getText().toString();
        //tester si le champ est vide
        if(!mnt.equals("")){
            double mntToConvert = Double.valueOf(mnt);
            if(etd.isChecked()){
                montantConverti = mntToConvert *3.3;

            }
            else
            if(dte.isChecked()){
                montantConverti = mntToConvert / 3.3;

            }
            else
                Toast.makeText(getApplicationContext(), "Veuillez choisir une option !", Toast.LENGTH_LONG).show();


            result.setText(""+montantConverti);
                       /* String mntConverti = String.valueOf(montantConverti);
                        result.setText(mntConverti);*/
        }
        else
            Toast.makeText(getApplicationContext(), "Merci de saisir un montant", Toast.LENGTH_LONG).show();


    }

}





