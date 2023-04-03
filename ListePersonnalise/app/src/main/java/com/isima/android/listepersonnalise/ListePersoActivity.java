package com.isima.android.listepersonnalise;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListePersoActivity extends ListActivity {

    TextView selection;
    String[] items = {"12.5", "18", "9.43", "2.33", "15.12", "8.3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_perso);
        selection = (TextView) findViewById(R.id.selection);
        setListAdapter(new IconicAdapter(this));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        selection.setText(items[position]);
    }

    class IconicAdapter extends ArrayAdapter<String> {
        Activity context;
        IconicAdapter(Activity context) {
            super(context, R.layout.ma_ligne, items);
            this.context = context;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View ligne = inflater.inflate(R.layout.ma_ligne, null);
            TextView label = (TextView) ligne.findViewById(R.id.label);
            ImageView icone = (ImageView) ligne.findViewById(R.id.imageView);
            label.setText(items[position]);
            if (Float.valueOf(items[position]) >= 10){
                icone.setImageResource(R.drawable.pass);
            } else {
                icone.setImageResource(R.drawable.fail);
            }
            return ligne;
        }
    }
}
