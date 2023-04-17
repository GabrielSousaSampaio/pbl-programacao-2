package tests.dao.component;

import dao.DAO;
import model.components.Component;
import model.components.ComputerComponent;
import model.components.OtherComponent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComponentListImplTest {

    private ComputerComponent component1;
    private OtherComponent component2;

    @BeforeEach
    void setUp() {

        component1 = new ComputerComponent(30,0,50,"GPU XXX","PPPPPP");
        component2 = new OtherComponent(50,12,20,"LLLLLLLLLLLLLLLLLLLL");

    }

    @AfterEach
    void tearDown() {

        DAO.getComponent().clearList();

    }

    @Test
    void create() {

        Component saveComponent1 = DAO.getComponent().create(component1);
        Component saveComponent2 = DAO.getComponent().create(component2);

        assertEquals(component1, saveComponent1);
        assertEquals(component2, saveComponent2);

    }

    @Test
    void findMany() {

        DAO.getComponent().create(component1);
        DAO.getComponent().create(component2);

        List<Component> componentList = new ArrayList<Component>();

        componentList.add(component1);
        componentList.add(component2);

        assertEquals(componentList, DAO.getComponent().FindMany());

    }

    @Test
    void findById() {

        DAO.getComponent().create(component1);
        DAO.getComponent().create(component2);

        assertEquals(component1, DAO.getComponent().FindById(component1.getId()));
        assertEquals(component2, DAO.getComponent().FindById(component2.getId()));

    }

    @Test
    void update() {

        DAO.getComponent().create(component1);
        DAO.getComponent().create(component2);

        component1.setQuantity(200);
        component2.setQuantity(300);

        DAO.getComponent().update(component1);
        DAO.getComponent().update(component2);

        assertEquals(component1, DAO.getComponent().FindById(component1.getId()));
        assertEquals(component2, DAO.getComponent().FindById(component2.getId()));

    }

    @Test
    void delete() {

        DAO.getComponent().create(component1);
        DAO.getComponent().create(component2);

        int componentId1 = component1.getId();
        int componentId2 = component2.getId();


        DAO.getComponent().delete(component1.getId());
        DAO.getComponent().delete(component2.getId());

        assertNull(DAO.getComponent().FindById(componentId1));
        assertNull(DAO.getComponent().FindById(componentId2));

    }

    @Test
    void clearList() {

        DAO.getComponent().create(component1);
        DAO.getComponent().create(component2);

        DAO.getComponent().clearList();

        assertEquals(DAO.getComponent().FindMany().size(), 0);
    }

    @Test
    void pickingComponent() {

        DAO.getComponent().create(component1);
        DAO.getComponent().create(component2);

        Component componentCopy1 = component1.copy();
        Component componentCopy2 = component2.copy();



        assertEquals(2, DAO.getComponent().pickingComponent(component1, 2).getQuantity());
        assertEquals(48, DAO.getComponent().FindById(component1.getId()).getQuantity());

        assertEquals(4, DAO.getComponent().pickingComponent(component2, 4).getQuantity());
        assertEquals(16, DAO.getComponent().FindById(component2.getId()).getQuantity());

    }
}