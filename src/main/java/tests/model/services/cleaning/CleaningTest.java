package main.java.tests.model.services.cleaning;

import main.java.model.services.Cleaning;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CleaningTest {

    Cleaning cleaning;

    /**
     * Método que configura os atributos de cleaning antes de cada teste
     */
    @BeforeEach
    public void setUp(){
        cleaning = new Cleaning(1000, 10, "Limpeza Profunda");
    }

    /**
     * Método que testa os métodos get e set de Cleaning.java
     */
    @Test
    public void gettersAndSetters(){
        cleaning.setId(1);
        cleaning.setPrice(500);
        cleaning.setCost(5);
        cleaning.setCleaningName("Limpeza meio profunda");

        Assertions.assertEquals(1, cleaning.getId());
        Assertions.assertEquals(500, cleaning.getPrice());
        Assertions.assertEquals(5, cleaning.getCost());
        Assertions.assertEquals("Limpeza meio profunda", cleaning.getCleaningName());
    }
}
