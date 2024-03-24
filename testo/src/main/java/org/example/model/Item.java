package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.Categorie;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private int id;
    private String nom;
    private double prix;
    private Categorie categorie;


}
