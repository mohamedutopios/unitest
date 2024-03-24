package org.example.assertArrayEquals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExempleTest {

    @Test
    void testEgaliteTableauxEntiers() {
        int[] attendu = {1, 2, 3, 4, 5};
        int[] resultat = {1, 2, 3, 4, 5};
        assertArrayEquals(attendu, resultat, "Les tableaux doivent être égaux");
    }

    @Test
    void testEgaliteTableauxChaines() {
        String[] attendu = {"un", "deux", "trois"};
        String[] resultat = {"un", "deux", "trois"};
        assertArrayEquals(attendu, resultat, "Les tableaux de chaînes doivent être égaux");
    }


    @Test
    void testEgaliteTableauxDoublesAvecTolerance() {
        double[] attendu = {1.0, 2.1, 3.2};
        double[] resultat = {1.0, 2.099, 3.201};
        assertArrayEquals(attendu, resultat, 0.01, "Les tableaux de doubles doivent être égaux avec une tolérance de 0.01");
    }

}
