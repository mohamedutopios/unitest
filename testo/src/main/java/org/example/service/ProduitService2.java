package org.example.service;

import org.example.model.Produit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProduitService2 {
    private List<Produit> produits = new ArrayList<>();


    // Create
    public Produit ajouterProduit(String nom, double prix) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du produit ne peut pas être vide.");
        }
        if (prix <= 0) {
            throw new IllegalArgumentException("Le prix doit être supérieur à 0.");
        }
        Produit produit = new Produit(nom, prix);
        produits.add(produit);
        return produit;
    }


    // Read
    public Produit trouverParId(int id) {
        return produits.stream()
                .filter(produit -> produit.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Produit avec l'id " + id + " n'existe pas"));
    }

    // Update
    public Produit mettreAJourProduit(int id, String nom, double prix) {
        Produit produit = trouverParId(id);
        produit.setNom(nom);
        produit.setPrix(prix);
        return produit;
    }

    // Delete
    public void supprimerProduit(int id) {
        produits.removeIf(produit -> produit.getId() == id);
    }

    // List all products
    public List<Produit> listerProduits() {
        return produits;
    }
}

