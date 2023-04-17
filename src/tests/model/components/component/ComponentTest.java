package tests.model.components.component;

import model.components.Component;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComponentTest {

    Component component0;
    Component component1;

    /**
     * Método que configura os atributos de component0 antes de cada teste
     */
    @BeforeEach
    public void setUp(){
        component0 = new Component(300, 10, 2000);
    }

    /**
     * Método que testa o método "copy" de Component.java
     */
    @Test void copy(){
        component1 = component0.copy();
        Assertions.assertEquals(component1.getPrice(), component0.getPrice());
        Assertions.assertEquals(component1.getCost(), component0.getCost());
        Assertions.assertEquals(component1.getQuantity(), component0.getQuantity());
    }

    /**
     * Método que testa os métodos get e set de Component.java
     */
    @Test
    public void gettersAndSetters(){
        component0.setPrice(100);
        component0.setCost(5);
        component0.setQuantity(553);
        component0.setId(87);

        Assertions.assertEquals(100, component0.getPrice());
        Assertions.assertEquals(5, component0.getCost());
        Assertions.assertEquals(553, component0.getQuantity());
        Assertions.assertEquals(87, component0.getId());
    }
}
