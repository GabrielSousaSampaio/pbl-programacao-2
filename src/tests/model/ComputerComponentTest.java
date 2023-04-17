package tests.model;

import model.ComputerComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerComponentTest {
    ComputerComponent computerComponent;

    @BeforeEach
    public void setUp(){
        computerComponent = new ComputerComponent(5000, 4500, 100, "Processador", "AMD");
    }

    @Test
    public void gettersAndSetters(){
        computerComponent.setPrice(200);
        computerComponent.setCost(100);
        computerComponent.setQuantity(10);
        computerComponent.setName("Memória Ram");
        computerComponent.setManufacturer("Kingston");
        computerComponent.setId(3);

        Assertions.assertEquals(200, computerComponent.getPrice());
        Assertions.assertEquals(100, computerComponent.getCost());
        Assertions.assertEquals(10, computerComponent.getQuantity());
        Assertions.assertEquals("Memória Ram", computerComponent.getName());
        Assertions.assertEquals("Kingston", computerComponent.getManufacturer());
        Assertions.assertEquals(3, computerComponent.getId());
    }
}
