package com.isima.android.contactlfi3g2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

//pour gérer une BD sqlite je dois hériter de SQLiteOpenHelper
public class DataBaseController extends SQLiteOpenHelper {

        //nom et version de la BS
        public static String Database_name ="contact.db";
        public static int Database_version =1;
        //nom de table et champs
        public static String table_name ="contact";
        public static String champ_id = "id";
        public static String champ_nom = "nom";
        public static String champ_num = "num";

        public static String req_create ="create table "+table_name+" ("+champ_id+" integer primary key " +
                "autoincrement,"+ champ_nom+" text, "+champ_num+" text);";

        public  static String req_delete = "drop table if exists"+table_name;

        public DataBaseController(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, Database_name, null, Database_version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //création de la table
            //execSQL car req ne retourne rien
            db.execSQL(req_create);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //supprimer la table si existe
            db.execSQL(req_delete);
            //créer la table contact
            onCreate(db);
        }

        public void insertContact(Contact con){
            //1: accéder à la base en mode écriture
            SQLiteDatabase db = this.getWritableDatabase();
            //2: récupérer les informations du contact con
            String nom = con.getNom();
            String num = con.getNum();

            //3: et remplir le content values
            ContentValues cv = new ContentValues();
            cv.put(champ_nom, nom);
            cv.put(champ_num, num);

            //4: insérer
            db.insert(table_name, null, cv);
            //5: fermer DB
            db.close();
        }

        public List<Contact> getAll(){
            //création d'une liste pour y stocker le résutat
            List<Contact> listResult = new ArrayList<>();
            //1: accéder à la BD
            SQLiteDatabase db = this.getReadableDatabase();
            //2: requête de sélection
            String req = "select * from "+table_name;
            //3: exécuter la requête
            Cursor curseur = db.rawQuery(req, null);
            //4: se rassurer que curseur n'est pas vide
            if(curseur.moveToFirst()){
                do{
                    Contact c = new Contact();
                    int id_ligne = curseur.getInt(0);
                    c.setId(id_ligne);
                    c.setNom(curseur.getString(1));
                    c.setNum(curseur.getString(2));
                    listResult.add(c);
                }while (curseur.moveToNext());
            }
            return listResult;
        }

}







