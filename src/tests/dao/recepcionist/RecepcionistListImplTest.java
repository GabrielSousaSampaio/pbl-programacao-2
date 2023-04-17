package tests.dao.recepcionist;

import dao.DAO;
import model.users.Recepcionist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecepcionistListImplTest {

    private Recepcionist recepcionist1;
    private Recepcionist recepcionist2;


    @BeforeEach
    void setUp() {

        recepcionist1 = new Recepcionist("Marcos","marcos@email.com","00001");
        recepcionist2 = new Recepcionist("Leonardo","leonardo@email.com","11111");

    }

    @AfterEach
    void tearDown() {

        DAO.getRecepcionist().clearList();
    }

    @Test
    void create() {

        Recepcionist saveRecepcionist1 = DAO.getRecepcionist().create(recepcionist1);
        Recepcionist saveRecepcionist2 = DAO.getRecepcionist().create(recepcionist2);

        assertEquals(recepcionist1, saveRecepcionist1);
        assertEquals(recepcionist2, saveRecepcionist2);

    }

    @Test
    void findMany() {

        DAO.getRecepcionist().create(recepcionist1);
        DAO.getRecepcionist().create(recepcionist2);

        List<Recepcionist> recepcionistList = new ArrayList<Recepcionist>();

        recepcionistList.add(recepcionist1);
        recepcionistList.add(recepcionist2);


        assertEquals(recepcionistList, DAO.getRecepcionist().FindMany());

    }

    @Test
    void findById() {

        DAO.getRecepcionist().create(recepcionist1);
        DAO.getRecepcionist().create(recepcionist2);

        assertEquals(recepcionist1, DAO.getRecepcionist().FindById(recepcionist1.getId()));
        assertEquals(recepcionist2, DAO.getRecepcionist().FindById(recepcionist2.getId()));

    }

    @Test
    void update() {

        DAO.getRecepcionist().create(recepcionist1);
        DAO.getRecepcionist().create(recepcionist2);

        recepcionist1.setName("Marcos Silva");
        recepcionist2.setName("Leonardo Souza");

        DAO.getRecepcionist().update(recepcionist1);
        DAO.getRecepcionist().update(recepcionist2);

        assertEquals(recepcionist1, DAO.getRecepcionist().FindById(recepcionist1.getId()));
        assertEquals(recepcionist2, DAO.getRecepcionist().FindById(recepcionist2.getId()));

    }

    @Test
    void delete() {

        DAO.getRecepcionist().create(recepcionist1);
        DAO.getRecepcionist().create(recepcionist2);

        int recepcionistId1 = recepcionist1.getId();
        int recepcionistId2 = recepcionist2.getId();

        DAO.getRecepcionist().delete(recepcionist1.getId());
        DAO.getRecepcionist().delete(recepcionist2.getId());

        assertNull(DAO.getRecepcionist().FindById(recepcionistId1));
        assertNull(DAO.getRecepcionist().FindById(recepcionistId2));
    }

    @Test
    void clearList() {

        DAO.getRecepcionist().create(recepcionist1);
        DAO.getRecepcionist().create(recepcionist2);

        DAO.getRecepcionist().clearList();

        assertEquals(DAO.getRecepcionist().FindMany().size(), 0);

    }
}