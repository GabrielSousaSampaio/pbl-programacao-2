package tests.dao.technician;

import dao.DAO;
import model.users.Technician;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TechnicianListImplTest {

    private Technician technician1;

    private Technician technician2;

    @BeforeEach
    void setUp() {

        technician1 = new Technician("João","joao@email.com","99999");
        technician2 = new Technician("Pedro","Pedro@email.com","00000");
    }

    @AfterEach
    void tearDown() {

        DAO.getTechnician().clearList();
    }

    @Test
    void create() {

        Technician saveTechnician1 = DAO.getTechnician().create(technician1);
        Technician saveTechnician2 = DAO.getTechnician().create(technician2);

        assertEquals(technician1, saveTechnician1);
        assertEquals(technician2, saveTechnician2);
    }

    @Test
    void findMany() {

        DAO.getTechnician().create(technician1);
        DAO.getTechnician().create(technician2);

        List<Technician> technicianList = new ArrayList<Technician>();

        technicianList.add(technician1);
        technicianList.add(technician2);


        assertEquals(technicianList, DAO.getTechnician().FindMany());
    }

    @Test
    void findById() {

        DAO.getTechnician().create(technician1);
        DAO.getTechnician().create(technician2);

        assertEquals(technician1, DAO.getTechnician().FindById(technician1.getId()));
        assertEquals(technician2, DAO.getTechnician().FindById(technician2.getId()));
    }

    @Test
    void update() {

        DAO.getTechnician().create(technician1);
        DAO.getTechnician().create(technician2);

        technician1.setName("João Silva");
        technician2.setName("Pedro Souza");

        DAO.getTechnician().update(technician1);
        DAO.getTechnician().update(technician2);

        assertEquals(technician1, DAO.getTechnician().FindById(technician1.getId()));
        assertEquals(technician2, DAO.getTechnician().FindById(technician2.getId()));

    }

    @Test
    void delete() {

        DAO.getTechnician().create(technician1);
        DAO.getTechnician().create(technician2);

        int technicianId1 = technician1.getId();
        int technicianId2 = technician2.getId();


        DAO.getTechnician().delete(technician1.getId());
        DAO.getTechnician().delete(technician2.getId());

        assertNull(DAO.getTechnician().FindById(technicianId1));
        assertNull(DAO.getTechnician().FindById(technicianId2));
    }

    @Test
    void clearList() {

        DAO.getTechnician().create(technician1);
        DAO.getTechnician().create(technician2);

        DAO.getTechnician().clearList();

        assertEquals(DAO.getTechnician().FindMany().size(), 0);

    }
}