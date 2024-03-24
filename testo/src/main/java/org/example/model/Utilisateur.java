package org.example.model;

public class Utilisateur {

    String nom;

    int age;

    public Utilisateur(String prenom, int age) {
        this.nom = prenom;
        this.age = age;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
