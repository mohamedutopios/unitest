package org.example.service;

import org.example.enums.Categorie;
import org.example.model.Item;
import org.example.model.Produit;

import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private List<Item> items = new ArrayList<>();


    public Item ajouterItem(int id,String nom, double prix, Categorie categorie) {
        // Validation du prix selon la catégorie
        switch (categorie) {
            case ELECTRONIQUE -> {
                if (prix < 100) throw new IllegalArgumentException("Les produits électroniques devraient avoir un prix plus élevé");
            }
            case MEUBLE -> {
                if (prix < 20 || prix > 500) throw new IllegalArgumentException("Les meubles devraient avoir une fourchette de prix spécifique");
            }
            case ALIMENTAIRE -> {
                if (prix >= 10) throw new IllegalArgumentException("Les produits alimentaires devraient avoir un prix plus bas");
            }
        }

        Item item = new Item(id,nom, prix, categorie);
        items.add(item);
        return item;
    }
}
