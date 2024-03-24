package org.example.timeOut;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class TimeOutTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void testAvecTimeout() throws InterruptedException {
        // Simuler une opération qui pourrait prendre du temps
        Thread.sleep(400); // Simule une tâche qui prend 400 millisecondes
    }

    @Test
    @Timeout(1) // Timeout de 1 seconde, TimeUnit.SECONDS est le défaut
    void testAvecTimeoutSecondes() throws InterruptedException {
        // Ce test échouera si l'exécution prend plus d'1 seconde
        Thread.sleep(500); // Simule une tâche qui prend 500 millisecondes
    }

    @Test
    void testEchoueAvecTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            // Simule une tâche qui prend plus de temps que le timeout spécifié
            Thread.sleep(200); // Cette ligne fera échouer le test
        }, "Le test doit échouer si le traitement dépasse 100 millisecondes");
    }

}
