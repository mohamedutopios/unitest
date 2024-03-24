package org.example.itemTest;

import org.example.enums.Categorie;
import org.example.model.Item;
import org.example.model.Produit;
import org.example.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class ItemServiceTest {

    private ItemService itemService;

    @BeforeEach
    void setUp() {
        itemService = new ItemService();
    }


    // ValueSource

    @ParameterizedTest
    @ValueSource(strings = {"chaise", "table", "bureau"})
    @Tag("Creation")
    void testAjouterItemAvecNomsDifferents(String nom) {

        Item item = itemService.ajouterItem(1,nom, 100.0, Categorie.MEUBLE);
        assertEquals(nom, item.getNom(), "Le nom du produit doit correspondre à l'entrée");
    }

    //EnumSource
    @ParameterizedTest
    @EnumSource(Categorie.class)
    void testCreationProduitAvecPrixValideParCategorie(Categorie categorie) {
        Item item = switch (categorie) {
            case ELECTRONIQUE -> itemService.ajouterItem(1, "Ordinateur", 1000, categorie);
            case MEUBLE -> itemService.ajouterItem(2, "Chaise", 50, categorie);
            case ALIMENTAIRE -> itemService.ajouterItem(3, "Pomme", 1, categorie);
        };

        assertEquals(categorie, item.getCategorie(), "La catégorie du produit doit correspondre");
        if (categorie == Categorie.ELECTRONIQUE) {
            assertTrue(item.getPrix() >= 100, "Les produits électroniques devraient avoir un prix plus élevé");
        } else if (categorie == Categorie.MEUBLE) {
            assertTrue(item.getPrix() >= 20 && item.getPrix() <= 500, "Les meubles devraient avoir une fourchette de prix spécifique");
        } else{
        assertTrue(item.getPrix() < 10, "Les produits alimentaires devraient avoir un prix plus bas");
        }
    }


    //MethodSource

    static Stream<Arguments> fournirDonneesTest() {
        return Stream.of(
                Arguments.of("chaise", 25.0),
                Arguments.of("table", 45.0)
        );
    }

    @ParameterizedTest
    @MethodSource("fournirDonneesTest")
    void testAjouterProduitAvecPrix(String nom, double prix) {
        Item item = itemService.ajouterItem(1,nom, prix, Categorie.MEUBLE);
        assertAll(
                () -> assertEquals(nom, item.getNom()),
                () -> assertEquals(prix, item.getPrix()),
                () -> assertTrue(item.getPrix()<500 && item.getPrix()>20));
    }



    //csvSource

    @ParameterizedTest
    @CsvSource({
            "Ordinateur, 1000, ELECTRONIQUE",
            "Chaise, 50, MEUBLE",
            "Pomme, 1, ALIMENTAIRE"
    })
    void testAjouterItemAvecCsvSource(String nom, double prix, Categorie categorie) {
        Item item = itemService.ajouterItem(1, nom, prix, categorie);

        assertAll("Vérification des propriétés de l'item",
                () -> assertEquals(nom, item.getNom(), "Le nom de l'item doit correspondre"),
                () -> assertEquals(prix, item.getPrix(), "Le prix de l'item doit correspondre"),
                () -> assertEquals(categorie, item.getCategorie(), "La catégorie de l'item doit correspondre"),
                () -> {
                    // Assertions conditionnelles basées sur la catégorie
                    switch (categorie) {
                        case ELECTRONIQUE -> assertTrue(item.getPrix() >= 100, "Les produits électroniques devraient avoir un prix plus élevé");
                        case MEUBLE -> assertTrue(item.getPrix() >= 20 && item.getPrix() <= 500, "Les meubles devraient avoir une fourchette de prix spécifique");
                        case ALIMENTAIRE -> assertTrue(item.getPrix() < 10, "Les produits alimentaires devraient avoir un prix plus bas");
                    }
                }
        );
    }

}
