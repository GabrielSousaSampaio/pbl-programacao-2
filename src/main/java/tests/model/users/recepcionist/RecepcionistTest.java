package main.java.tests.model.users.recepcionist;

import main.java.model.users.Recepcionist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecepcionistTest {
    Recepcionist recepcionist;

    /**
     * Método que configura os atributos de recepcionist antes de cada teste
     */
    @BeforeEach
    public void setUp(){
        recepcionist = new Recepcionist("Recepcionista", "recepcionista@gmail.com", "recepcionista");
    }

    /**
     * Método que testa os métodos get e set de Recepcionist.java
     */
    @Test
    public void gettersAndSetters(){
        recepcionist.setId(94);
        recepcionist.setName("Josefa");
        recepcionist.setEmail("josefa@gmail.com");
        recepcionist.setPassword("123456");

        Assertions.assertEquals(94, recepcionist.getId());
        Assertions.assertEquals("Josefa", recepcionist.getName());
        Assertions.assertEquals("josefa@gmail.com", recepcionist.getEmail());
        Assertions.assertEquals("123456", recepcionist.getPassword());
    }
}
