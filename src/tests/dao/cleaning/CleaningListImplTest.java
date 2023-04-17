package tests.dao.cleaning;

import dao.DAO;
import model.services.Cleaning;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CleaningListImplTest {

    private Cleaning cleaning1;
    private Cleaning cleaning2;

    @BeforeEach
    void setUp() {

        cleaning1 = new Cleaning(50,20,"Clening1");
        cleaning2 = new Cleaning(50,20,"Clening2");

    }

    @AfterEach
    void tearDown() {

        DAO.getCleaning().clearList();
    }

    @Test
    void create() {

        Cleaning saveCleaning1 = DAO.getCleaning().create(cleaning1);
        Cleaning saveCleaning2 = DAO.getCleaning().create(cleaning2);

        assertEquals(cleaning1, saveCleaning1);
        assertEquals(cleaning2, saveCleaning2);

    }

    @Test
    void findMany() {

        DAO.getCleaning().create(cleaning1);
        DAO.getCleaning().create(cleaning2);

        List<Cleaning> cleaningList = new ArrayList<Cleaning>();

        cleaningList.add(cleaning1);
        cleaningList.add(cleaning2);

        assertEquals(cleaningList, DAO.getCleaning().FindMany());
    }

    @Test
    void findById() {

        DAO.getCleaning().create(cleaning1);
        DAO.getCleaning().create(cleaning2);

        assertEquals(cleaning1, DAO.getCleaning().FindById(cleaning1.getId()));
        assertEquals(cleaning2, DAO.getCleaning().FindById(cleaning2.getId()));
    }

    @Test
    void update() {

        DAO.getCleaning().create(cleaning1);
        DAO.getCleaning().create(cleaning2);

        cleaning1.setCleaningName("NewCleaning1");
        cleaning2.setCleaningName("NewCleaning2");

        DAO.getCleaning().update(cleaning1);
        DAO.getCleaning().update(cleaning2);

        assertEquals(cleaning1, DAO.getCleaning().FindById(cleaning1.getId()));
        assertEquals(cleaning2, DAO.getCleaning().FindById(cleaning2.getId()));
    }

    @Test
    void delete() {

        DAO.getCleaning().create(cleaning1);
        DAO.getCleaning().create(cleaning2);

        int cleaningId1 = cleaning1.getId();
        int cleaningId2 = cleaning2.getId();


        DAO.getCleaning().delete(cleaning1.getId());
        DAO.getCleaning().delete(cleaning2.getId());

        assertNull(DAO.getCleaning().FindById(cleaningId1));
        assertNull(DAO.getCleaning().FindById(cleaningId2));
    }

    @Test
    void clearList() {

        DAO.getCleaning().create(cleaning1);
        DAO.getCleaning().create(cleaning2);

        DAO.getCleaning().clearList();

        assertEquals(DAO.getCleaning().FindMany().size(), 0);

    }
}