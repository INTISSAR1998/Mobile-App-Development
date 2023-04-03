package com.isima.android.exemplechapitre2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HelloWorldActivity extends AppCompatActivity {

    public EditText myEditText;
    public Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);

        myEditText = findViewById(R.id.edName);
        myButton = findViewById(R.id.btnOK);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HelloWorldActivity.this , "Bonjour " + myEditText.getText() + "!", Toast.LENGTH_SHORT ).show();
            }
        });
    }
}
