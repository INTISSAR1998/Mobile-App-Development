package com.isima.android.tp0;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

public class HelloWorld extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_hello_world);*/
        TextView tv = new TextView(this);
        tv.setText("Hello World");
        setContentView(tv);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast helloToast = Toast.makeText(this,"onStart",Toast.LENGTH_LONG);
        helloToast.setGravity(Gravity.CENTER,0,0);
        helloToast.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast helloToast = Toast.makeText(this,"onResume",Toast.LENGTH_LONG);
        helloToast.setGravity(Gravity.CENTER,0,0);
        helloToast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast helloToast = Toast.makeText(this,"onPause",Toast.LENGTH_LONG);
        helloToast.setGravity(Gravity.CENTER,0,0);
        helloToast.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast helloToast = Toast.makeText(this,"onStop",Toast.LENGTH_LONG);
        helloToast.setGravity(Gravity.CENTER,0,0);
        helloToast.show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast helloToast = Toast.makeText(this,"onRestart",Toast.LENGTH_LONG);
        helloToast.setGravity(Gravity.CENTER,0,0);
        helloToast.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast helloToast = Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG);
        helloToast.setGravity(Gravity.CENTER,0,0);
        helloToast.show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

}
