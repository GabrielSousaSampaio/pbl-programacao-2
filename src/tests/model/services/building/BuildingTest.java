package tests.model.services.building;

import model.services.Building;
import model.components.ComputerComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BuildingTest {

    Building building;
    ComputerComponent computerComponent0, computerComponent1;

    @BeforeEach
    public void setUp(){
        building = new Building();
        computerComponent0 = new ComputerComponent(50, 25, 50, "Memória Ram", "Kingston");
        computerComponent1 = new ComputerComponent(600, 400, 15, "Placa Mãe", "Asus");
    }

    @Test
    public void addComponent(){
        building.addComponent(computerComponent0);
        building.addComponent(computerComponent1);
        Assertions.assertEquals(2, building.getUsedComponents().size());
        Assertions.assertEquals(25, building.getUsedComponents().get(0).getCost());
        Assertions.assertEquals(600, building.getUsedComponents().get(1).getPrice());
    }
}