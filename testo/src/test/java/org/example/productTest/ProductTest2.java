package org.example.productTest;

import org.example.model.Produit;
import org.example.service.ProduitService2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test de la classe ServiceProduct")
//@Disabled
public class ProductTest2 {

    private ProduitService2 produitService;

    @BeforeEach
    void setUp(){
        produitService = new ProduitService2();
    }

    @Test
    @DisplayName("Ajout de produits dans la liste")
    void testAddProduitList() {
        Produit produit = produitService.ajouterProduit("chaise", 23);
        Produit produit1 = produitService.ajouterProduit("Table", 45);

        assertAll("Vérification après ajout de produits",
                () -> assertFalse(produitService.listerProduits().isEmpty(), "La liste ne devrait pas être vide"),
                () -> assertTrue(produit.getId() > 0, "L'ID du premier produit doit être positif"),
                () -> assertTrue(produit1.getId() > produit.getId(), "L'ID du deuxième produit doit être supérieur à celui du premier"),
                () -> assertEquals(2, produitService.listerProduits().size(), "La liste devrait contenir deux produits")
        );
    }

    @Test
    @DisplayName("Lève IllegalArgumentException si le nom du produit est vide")
    void testAjouterProduitAvecNomVide() {

        assertThrows(IllegalArgumentException.class, () -> {
            produitService.ajouterProduit("", 100.0);
        }, "Une IllegalArgumentException doit être levée si le nom est vide");
    }

    @Test
    //@Disabled("Pas encore traité ce test")
    @DisplayName("Lève IllegalArgumentException si le prix est inférieur ou égal à 0")
    void testAjouterProduitAvecPrixInvalide() {

        assertThrows(IllegalArgumentException.class, () -> {
            produitService.ajouterProduit("Chaise", -1.0);
        }, "Une IllegalArgumentException doit être levée si le prix est inférieur ou égal à 0");
    }



    @Test
    @DisplayName("La liste de produits est initialement vide")
    void testEmptyList() {
        assertTrue(produitService.listerProduits().isEmpty(), "La liste devrait être vide au début");
    }

    @Test
    @DisplayName("Création de produits et vérification de l'incrémentation des ID")
    void testCreationProduitEtIncre() {
        Produit produit = produitService.ajouterProduit("chaise", 23);
        Produit produit1 = produitService.ajouterProduit("table", 45);

        assertAll("Vérification des propriétés des produits ajoutés",
                () -> assertEquals("chaise", produit.getNom(), "Le nom du premier produit doit être correct"),
                () -> assertEquals(23, produit.getPrix(), "Le prix du premier produit doit être correct"),
                () -> assertTrue(produit.getId() > 0, "L'ID du premier produit doit être positif"),
                () -> assertTrue(produit1.getId() > produit.getId(), "L'ID du deuxième produit doit être supérieur à celui du premier")
        );
    }

    @Test
    @DisplayName("Mise à jour d'un produit")
    void testUpdateProduit() {
        Produit produit = produitService.ajouterProduit("chaise", 23);
        produitService.mettreAJourProduit(produit.getId(), "mobile", 23);
        Produit produitMisAJour = produitService.trouverParId(produit.getId());

        assertAll("Vérification après mise à jour du produit",
                () -> assertEquals("mobile", produitMisAJour.getNom(), "Le nom du produit doit être mis à jour"),
                () -> assertEquals(23, produitMisAJour.getPrix(), "Le prix du produit doit rester inchangé")
        );
    }

    @Test
    @DisplayName("Suppression d'un produit")
    void testDeleteProduit() {
        Produit produit = produitService.ajouterProduit("chaise", 23);
        produitService.supprimerProduit(produit.getId());

        assertThrows(NoSuchElementException.class, () -> produitService.trouverParId(produit.getId()), "Une NoSuchElementException doit être levée si le produit n'est pas trouvé");
    }

    @Test
    @DisplayName("Récupération de tous les produits")
    void testGetAllProduit() {
        produitService.ajouterProduit("chaise", 23);
        produitService.ajouterProduit("table", 45);

        assertEquals(2, produitService.listerProduits().size(), "La liste devrait contenir deux produits");
    }

    @Test
    @DisplayName("Trouver un produit par son ID")
    void testGetProductById() {
        Produit produit = produitService.ajouterProduit("chaise", 23);
        Produit produit1 = produitService.ajouterProduit("table", 45);

        assertAll("Vérification de la récupération par ID",
                () -> assertEquals(produit, produitService.trouverParId(produit.getId()), "Devrait retrouver le premier produit par son ID"),
                () -> assertEquals(produit1, produitService.trouverParId(produit1.getId()), "Devrait retrouver le deuxième produit par son ID"),
                () -> assertThrows(NoSuchElementException.class, () -> produitService.trouverParId(5), "Une NoSuchElementException doit être levée si le produit n'est pas trouvé")
        );
    }
}
