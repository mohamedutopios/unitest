package org.example.assertEquals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExempleTest {

    @Test
    void testAddition() {
        int resultatAttendu = 10;
        int resultatReel = 5 + 5;
        assertEquals(resultatAttendu, resultatReel, "L'addition de 5 et 5 doit être égale à 10");
    }

    @Test
    void testMultiplication() {
        int resultatNonAttendu = 20;
        int resultatReel = 5 * 3;
        assertNotEquals(resultatNonAttendu, resultatReel, "La multiplication de 5 et 3 ne doit pas être égale à 20");
    }

}
