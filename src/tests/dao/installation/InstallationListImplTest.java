package tests.dao.installation;

import dao.DAO;
import model.services.Installation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstallationListImplTest {

    private Installation installation1;
    private Installation installation2;

    @BeforeEach
    void setUp() {

        installation1 = new Installation(30,0,"Program");
        installation2 = new Installation(50,12,"OperationalSystem");
    }

    @AfterEach
    void tearDown() {

        DAO.getInstallation().clearList();
    }

    @Test
    void create() {

        Installation saveInstalation1 = DAO.getInstallation().create(installation1);
        Installation saveInstalation2 = DAO.getInstallation().create(installation2);

        assertEquals(installation1, saveInstalation1);
        assertEquals(installation2, saveInstalation2);

    }

    @Test
    void findMany() {

        DAO.getInstallation().create(installation1);
        DAO.getInstallation().create(installation2);

        List<Installation> installationList = new ArrayList<Installation>();

        installationList.add(installation1);
        installationList.add(installation2);


        assertEquals(installationList, DAO.getInstallation().FindMany());

    }

    @Test
    void findById() {

        DAO.getInstallation().create(installation1);
        DAO.getInstallation().create(installation2);

        assertEquals(installation1, DAO.getInstallation().FindById(installation1.getId()));
        assertEquals(installation2, DAO.getInstallation().FindById(installation2.getId()));

    }

    @Test
    void update() {

        DAO.getInstallation().create(installation1);
        DAO.getInstallation().create(installation2);

        installation1.setInstallationName("Program 2");
        installation1.setInstallationName("OperationalSystem 2");

        DAO.getInstallation().update(installation1);
        DAO.getInstallation().update(installation2);

        assertEquals(installation1, DAO.getInstallation().FindById(installation1.getId()));
        assertEquals(installation2, DAO.getInstallation().FindById(installation2.getId()));

    }

    @Test
    void delete() {

        DAO.getInstallation().create(installation1);
        DAO.getInstallation().create(installation2);

        int installationId1 = installation1.getId();
        int installationId2 = installation2.getId();


        DAO.getInstallation().delete(installation1.getId());
        DAO.getInstallation().delete(installation2.getId());

        assertNull(DAO.getInstallation().FindById(installationId1));
        assertNull(DAO.getInstallation().FindById(installationId2));

    }

    @Test
    void clearList() {

        DAO.getInstallation().create(installation1);
        DAO.getInstallation().create(installation2);

        DAO.getInstallation().clearList();

        assertEquals(DAO.getInstallation().FindMany().size(), 0);

    }
}