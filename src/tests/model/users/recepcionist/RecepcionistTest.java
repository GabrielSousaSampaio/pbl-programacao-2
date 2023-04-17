package tests.model.users.recepcionist;

import model.users.Recepcionist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecepcionistTest {
    Recepcionist recepcionist;

    @BeforeEach
    public void setUp(){
        recepcionist = new Recepcionist("Recepcionista", "recepcionista@gmail.com", "recepcionista");
    }

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
