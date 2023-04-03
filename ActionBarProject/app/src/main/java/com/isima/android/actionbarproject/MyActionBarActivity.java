package com.isima.android.actionbarproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.Menu;

public class MyActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_action_bar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_my_action_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_search:
                Toast.makeText(this,"This is the Search Action!",Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
            case R.id.action_compose:
                Toast.makeText(this,"This is the Compose Action!",Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
            case R.id.action_settings:
                Toast.makeText(this,"This is the Settings Action!",Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
