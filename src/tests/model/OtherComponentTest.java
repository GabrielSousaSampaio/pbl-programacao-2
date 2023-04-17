package tests.model;

import model.OtherComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OtherComponentTest {

    OtherComponent component0;
    OtherComponent component1;

    @BeforeEach
    public void setUp(){
        component0 = new OtherComponent(60, 20, 95, "Pen Drive 16GB");
    }

    @Test
    public void gettersAndSetters(){
        component0.setPrice(45);
        component0.setCost(8);
        component0.setQuantity(75);
        component0.setId(4);
        component0.setDescription("Pen Drive 8GB");

        Assertions.assertEquals(45, component0.getPrice());
        Assertions.assertEquals(8, component0.getCost());
        Assertions.assertEquals(75, component0.getQuantity());
        Assertions.assertEquals(4, component0.getId());
        Assertions.assertEquals("Pen Drive 8GB", component0.getDescription());
    }
}
