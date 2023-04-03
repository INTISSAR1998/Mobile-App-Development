package com.isima.android.contactlfi3g2;

public class Contact {

    private int id;
    private String nom, num;

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
