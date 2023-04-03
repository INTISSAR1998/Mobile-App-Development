package com.isima.android.deviceconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //On déclare toutes les variables dont on aura besoin
    private EditText montant ;
    private RadioButton etd,dte;
    private Button btn;
    private TextView result=null;
    private TextView txt;
    private RadioGroup group ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // id java =findViewById(R.id.id_xml)
        // On va associer les éléments java aux éléments XML
        montant = (EditText) findViewById(R.id.etMontant);
        etd = (RadioButton) findViewById(R.id.rbetd);
        dte = (RadioButton) findViewById(R.id.rbdte);
        group = (RadioGroup) findViewById(R.id.group);
        btn = (Button) findViewById(R.id.btnConvert);
        result = (TextView) findViewById(R.id.tvResult);
        btn.setOnClickListener(btnListener);
    }

    //On attribue un écouteur d'évènement à le bouton CONVERTIR

    private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String mnt = montant.getText().toString();
            //Voici la méthode qui fait la conversion qui a été demandée par l'utilisateur
            if(!mnt.equals("")){
                float mntetd = Float.valueOf(mnt);
                float mntdte = Float.valueOf(mnt);
                if(group.getCheckedRadioButtonId() == R.id.rbetd){
                    mntetd = mntetd * (float) 3.3 ;
                    Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(mntetd), Toast.LENGTH_LONG);
                    toast.show();
                }
                if(group.getCheckedRadioButtonId() == R.id.rbdte){
                    mntdte = mntdte / (float) 3.3 ;
                    Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(mntdte), Toast.LENGTH_LONG);
                    toast.show();
                }
                else {Toast toast = Toast.makeText(getApplicationContext(),"Merci de saisir un mantant encore une fois", Toast.LENGTH_LONG);}
            }

        }
    };
}
