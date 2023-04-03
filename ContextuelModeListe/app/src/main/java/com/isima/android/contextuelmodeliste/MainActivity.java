package com.isima.android.contextuelmodeliste;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private String[] elements;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.listings);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_mode_menu, menu);
        return true;
    }


    listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL).
    listView.setMultiChoiceListenner(new AbsListView.MultiChoiceModeListener(){
            List<String> selected = new ArrayList<String>();

            @Override
            public void onItemCheckedStateChanged (ActionMode mode,int position, long id,
            boolean checked){
            selected.add(elements[position]);
        }

            @Override
            public boolean onCreateActionMode (ActionMode mode, Menu menu){
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.context_mode_menu, menu);
            return true;
        }

            @Override
            public boolean onPrepareActionMode (ActionMode mode, Menu menu){
            return false;
        }

            @Override
            public boolean onActionItemClicked (ActionMode mode, MenuItem item){
            if (item.getItemId() == R.id.action_search) {
                Toast.makeText(this, selected.toString(), Toast.LENGTH_SHORT).show();
                mode.finish();
            }
            return true;
        }

            @Override
            public void onDestroyActionMode (ActionMode mode){
            selected.clear();
        }
    });


}
