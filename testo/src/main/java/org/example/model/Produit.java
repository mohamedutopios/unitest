package org.example.model;

public class Produit {
    private int id;

    private static int count = 1;
    private String nom;
    private double prix;

    // Constructeur
    public Produit(String nom, double prix) {
        this.id = count++;
        this.nom = nom;
        this.prix = prix;
    }

    public Produit() {
        this.id = count++;
    }

    // Getters et Setters
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}

