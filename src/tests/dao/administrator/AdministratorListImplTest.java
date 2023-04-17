package tests.dao.administrator;

import dao.DAO;
import model.Administrator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdministratorListImplTest {

    private Administrator administrator1;
    private Administrator administrator2;

    @BeforeEach
    void setUp() {

        administrator1 = new Administrator("João","joao@emal.com","22222");
        administrator2 = new Administrator("Maria","maria@emal.com","33333");
    }

    @AfterEach
    void tearDown() {

        DAO.getAdministrator().clearList();
    }

    @Test
    void create() {

        Administrator saveAdministrator1 = DAO.getAdministrator().create(administrator1);
        Administrator saveAdministrator2 = DAO.getAdministrator().create(administrator2);

        assertEquals(administrator1, saveAdministrator1);
        assertEquals(administrator2, saveAdministrator2);
    }

    @Test
    void findMany() {

        DAO.getAdministrator().create(administrator1);
        DAO.getAdministrator().create(administrator2);

        List<Administrator> administratorList = new ArrayList<Administrator>();

        administratorList.add(administrator1);
        administratorList.add(administrator2);

        assertEquals(administratorList, DAO.getAdministrator().FindMany());
    }

    @Test
    void findById() {

        DAO.getAdministrator().create(administrator1);
        DAO.getAdministrator().create(administrator2);

        assertEquals(administrator1, DAO.getAdministrator().FindById(administrator1.getId()));
        assertEquals(administrator2, DAO.getAdministrator().FindById(administrator2.getId()));
    }

    @Test
    void update() {

        DAO.getAdministrator().create(administrator1);
        DAO.getAdministrator().create(administrator2);

        administrator1.setName("João Silva");
        administrator2.setName("Maria Almeida");

        DAO.getAdministrator().update(administrator1);
        DAO.getAdministrator().update(administrator2);

        assertEquals(administrator1, DAO.getAdministrator().FindById(administrator1.getId()));
        assertEquals(administrator2, DAO.getAdministrator().FindById(administrator2.getId()));
    }

    @Test
    void delete() {

        DAO.getAdministrator().create(administrator1);
        DAO.getAdministrator().create(administrator2);

        int administratorId1 = administrator1.getId();
        int administratorId2 = administrator2.getId();


        DAO.getAdministrator().delete(administrator1.getId());
        DAO.getAdministrator().delete(administrator2.getId());

        assertNull(DAO.getAdministrator().FindById(administratorId1));
        assertNull(DAO.getAdministrator().FindById(administratorId2));
    }

    @Test
    void clearList() {

        DAO.getAdministrator().create(administrator1);
        DAO.getAdministrator().create(administrator2);

        DAO.getAdministrator().clearList();

        assertEquals(DAO.getAdministrator().FindMany().size(), 0);


    }
}