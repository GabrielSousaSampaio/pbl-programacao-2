package tests.model.services.building;

import model.services.Building;
import model.components.ComputerComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BuildingTest {

    Building building;
    ComputerComponent computerComponent0, computerComponent1;

    /**
     * Método que configura os atributos de computerComponent0 e computerComponent1 antes de cada teste
     */
    @BeforeEach
    public void setUp(){
        building = new Building();
        computerComponent0 = new ComputerComponent(50, 25, 50, "Memória Ram", "Kingston");
        computerComponent1 = new ComputerComponent(600, 400, 15, "Placa Mãe", "Asus");
    }

    /**
     * Método que testa o método "addComponent" de Building.java
     */
    @Test
    public void addComponent(){
        building.addComponent(computerComponent0);
        building.addComponent(computerComponent1);
        Assertions.assertEquals(2, building.getUsedComponents().size());
        Assertions.assertEquals(25, building.getUsedComponents().get(0).getCost());
        Assertions.assertEquals(600, building.getUsedComponents().get(1).getPrice());
    }

    /**
     * Método que testa os métodos "getPrice" e "getCost" de Building.java
     */
    @Test
    public void getPriceAndGetCost(){
        building.addComponent(computerComponent0);
        building.addComponent(computerComponent1);
        Assertions.assertEquals(650, building.getPrice());
        Assertions.assertEquals(425, building.getCost());
    }
}