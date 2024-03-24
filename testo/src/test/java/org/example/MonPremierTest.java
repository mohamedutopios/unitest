package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MonPremierTest {


    @Test
    @DisplayName("Test sur l'egalité")
    void testEgalite() {
        assertEquals(4, 2 + 2, "2 + 2 doit être égal à 4");
    }


    @Test
    @DisplayName("Test sur la non egalité")
    void testNonEgalite() {
        assertNotEquals(5, 2 + 2, "2 + 2 ne doit pas être égal à 5");
    }


    @Test
    @DisplayName("Test est ce vrai ?")
    void testVrai() {
        assertTrue(2 + 2 == 4, "2 + 2 doit être égal à 4");
    }

    @Test
    void testFaux() {
        assertFalse(2 + 2 == 5, "2 + 2 ne doit pas être égal à 5");
    }


    @Test
    void testNull() {
        Object obj = null;
        assertNull(obj, "L'objet doit être null");
    }

    @Test
    void testNonNull() {
        Object obj = new Object();
        assertNotNull(obj, "L'objet ne doit pas être null");
    }

    @Test
    void testException() {
        assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Un message d'erreur");
        }, "Une IllegalArgumentException doit être levée");
    }


    @Test
    void testMultiple() {
        assertAll("Plusieurs tests",
                () -> assertEquals(4, 2 + 2, "2 + 2 doit être égal à 4"),
                () -> assertTrue(3 + 3 == 6, "3 + 3 doit être égal à 6")
        );
    }




}
