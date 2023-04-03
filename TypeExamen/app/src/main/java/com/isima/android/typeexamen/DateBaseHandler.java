package com.isima.android.typeexamen;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class DateBaseHandler extends SQLiteOpenHelper {

    //nom et version de la base de données
    private static String DATABASE_NAME ="contact.db";
    private static int DATABASE_VERSION = 1;
    //les champs de la table contact
    private static String champ_id ="id";
    private static String champ_nom ="nom";
    private static String champ_numero ="num";
    //nom de la table
    private static String table_name ="contact";

    private static String req_delete="drop table if exists "+table_name;



    private static String req_create ="create table "+table_name+"("+champ_id+" INTEGER primary" +
            "key autoincrement, "+champ_nom+ "text,"+champ_numero+"text);";

    public DateBaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //execSQL : exécuter une requête sql qui retourne pas des valeurs
        db.execSQL(req_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //supprimer la table contact si elle existe
        db.execSQL(req_delete);
        //créer de nouveau la table contact
        onCreate(db);
    }

    // Recherche d'un Contact dans la table
    public void ajoutercontact (Contact con){
        SQLiteDatabase db = this.getWritableDatabase();
        String nom = con.getNom();
        String num = con.getNum();
        ContentValues cv = new ContentValues();
        cv.pu
    }
}
