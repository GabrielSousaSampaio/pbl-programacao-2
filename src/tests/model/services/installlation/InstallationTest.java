package tests.model.services.installlation;

import model.services.Installation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InstallationTest {

    Installation installation;

    @BeforeEach
    public void setUp(){
        installation = new Installation(1000, 200, "Instalação de HD");
    }

    @Test
    public void gettersAndSetters(){
        installation.setPrice(800);
        installation.setCost(150);
        installation.setInstallationName("Instalação SSD");
        installation.setId(99);

        Assertions.assertEquals(800, installation.getPrice());
        Assertions.assertEquals(150, installation.getCost());
        Assertions.assertEquals("Instalação SSD", installation.getInstallationName());
        Assertions.assertEquals(99, installation.getId());
    }
}
