package com.isima.android.typeexamen;

public class Contact {

    private int id;
    private String nom;
    private String num;

    public Contact() {
    }

    public Contact(String nom, String num) {
        this.nom = nom;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

}
