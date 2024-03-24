package org.example.assertAll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExempleTest {

    @Test
    void testPlusieursConditions() {
        int nombre = 5;
        String chaine = "exemple";
        Object obj = null;

        assertAll("Vérifications multiples",
                () -> assertEquals(5, nombre, "La variable nombre doit être égale à 5"),
                () -> assertTrue(chaine.startsWith("ex"), "La chaîne doit commencer par 'ex'"),
                () -> assertNull(obj, "L'objet doit être null")
        );
    }
}
