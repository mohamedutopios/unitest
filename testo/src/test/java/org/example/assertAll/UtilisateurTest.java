package org.example.assertAll;

import org.example.model.Utilisateur;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilisateurTest {

    @Test
    void testAttributsUtilisateur() {
        Utilisateur utilisateur = new Utilisateur("Jean", 30);

        assertAll("Vérification des attributs de l'utilisateur",
                () -> assertEquals("Jean", utilisateur.getNom(), "Le nom de l'utilisateur doit être Jean"),
                () -> assertEquals(30, utilisateur.getAge(), "L'âge de l'utilisateur doit être 30"),
                () -> assertNotEquals("", utilisateur.getNom(), "Le nom de l'utilisateur ne doit pas être vide")
        );
    }
}

