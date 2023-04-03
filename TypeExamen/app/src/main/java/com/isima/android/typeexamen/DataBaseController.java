package com.isima.android.typeexamen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

//SQLiteOpenHelper héritée pour gérer une base de données SQLite
public class DataBaseController extends SQLiteOpenHelper {

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

    public DataBaseController(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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

    //Insertion d'un Contact dans la table
    public void insertContact(Contact con){
        //accéder à la BD en mode écriture
        SQLiteDatabase db = this.getWritableDatabase();
        //créer un content values pr y stocker les infos du contact
        ContentValues cv = new ContentValues();
        //remplir le content values
        cv.put(champ_nom, con.getNom() );
        cv.put(champ_numero, con.getNum());
        //insertion du cv
        db.insert(table_name, null, cv);
        db.close();
    }

    public List<Contact> getAll(){
        List<Contact> listResult = new ArrayList<>();
        //accéder à la bd en mode lecture
        SQLiteDatabase db = this.getReadableDatabase();
        //créer la requête
        String req = "select * from "+table_name;
        //exécuter la reqûete
        //rawQuery retourne un objet de type Cursor
        Cursor curseur = db.rawQuery(req, null);
        if(curseur.moveToFirst()){//le curseur contient au moins une ligne
            do{
                Contact c = new Contact();
                c.setId(curseur.getInt(0));
                c.setNom(curseur.getString(1));
                c.setNum(curseur.getString(2));

                listResult.add(c);
            }while(curseur.moveToNext());
        }

        return listResult;
    }

    public String[] convert(){
        List<Contact> list = getAll();
        String[] stringResult = new String[100];
        for (int i=0;i<list.size();i++){
            stringResult[i] = list.get(i).getNom();
        }
        return stringResult;
    }

}


