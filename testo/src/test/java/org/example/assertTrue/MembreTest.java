package org.example.assertTrue;

import org.example.model.Membre;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MembreTest {

    @Test
    void membreAPayeCotisation() {
        Membre membre = new Membre("Alice");
        membre.payerCotisation(); // Le membre paye sa cotisation.
        assertTrue(membre.aPayeCotisation(), "Le membre doit avoir payé sa cotisation");
    }

    @Test
    void membreAAtteintQuotaLivres() {
        Membre membre = new Membre("Bob");
        for (int i = 0; i < 5; i++) {
            membre.ajouterLivreLu(); // Simule la lecture de 5 livres.
        }
        assertTrue(membre.aAtteintQuotaLivres(5), "Le membre doit avoir atteint son quota de livres pour le mois");
    }
}

