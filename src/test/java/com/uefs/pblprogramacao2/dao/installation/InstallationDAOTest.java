package com.uefs.pblprogramacao2.dao.installation;

import com.uefs.pblprogramacao2.dao.DAO;
import com.uefs.pblprogramacao2.model.services.Installation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstallationDAOTest {

    //Atributos
    private Installation installation1;
    private Installation installation2;
    Installation saveInstalation1;
    Installation saveInstalation2;

    @BeforeEach
    void setUp() {
        //Criando dois serviços de instalação para os testes
        installation1 = new Installation(30,0,"Program");
        installation2 = new Installation(50,12,"OperationalSystem");

        //Salvando os serviços de instalação no sistema através do DAO
        saveInstalation1 = DAO.getInstallation().create(installation1);
        saveInstalation2 = DAO.getInstallation().create(installation2);
    }

    @AfterEach
    void tearDown() {
        //Limpando a lista após os testes
        DAO.getInstallation().clearList();
    }

    @Test
    void create() {
        //Verificando se os serviços de instalação salvos no sistema e os serviços de instalação enviados são iguais
        assertEquals(installation1, saveInstalation1);
        assertEquals(installation2, saveInstalation2);
    }

    @Test
    void findMany() {
        //Salvando os serviços de instalação em uma lista
        List<Installation> installationList = new ArrayList<Installation>();

        installationList.add(installation1);
        installationList.add(installation2);

        //Verificando se as listas são iguais
        assertEquals(installationList, DAO.getInstallation().FindMany());
    }

    @Test
    void findById() {
        //Verificando se os serviços de instalação encontrados através do id e os serviços de instalação enviados são iguais
        assertEquals(installation1, DAO.getInstallation().FindById(installation1.getId()));
        assertEquals(installation2, DAO.getInstallation().FindById(installation2.getId()));
    }

    @Test
    void update() {
        //Alterando o nome dos serviços de instalação
        installation1.setInstallationName("Program 2");
        installation1.setInstallationName("OperationalSystem 2");

        //Atualizando os dados dos serviços de instalação
        DAO.getInstallation().update(installation1);
        DAO.getInstallation().update(installation2);

        //Verificando se os serviços de instalação são iguais, ou seja, se foram atualizados
        assertEquals(installation1, DAO.getInstallation().FindById(installation1.getId()));
        assertEquals(installation2, DAO.getInstallation().FindById(installation2.getId()));
    }

    @Test
    void delete() {
        //Recebendo os id's dos serviços de instalação
        int installationId1 = installation1.getId();
        int installationId2 = installation2.getId();

        //Deletando os serviços de instalação do sistema
        DAO.getInstallation().delete(installation1.getId());
        DAO.getInstallation().delete(installation2.getId());

        //Verificando se o retorno após a busca é nulo
        assertNull(DAO.getInstallation().FindById(installationId1));
        assertNull(DAO.getInstallation().FindById(installationId2));
    }

    @Test
    void clearList() {
        //Limpando a lista de serviços de instalação
        DAO.getInstallation().clearList();

        //Verificando se o tamanho da lista de serviços de instalação do sistema é 0
        assertEquals(DAO.getInstallation().FindMany().size(), 0);
    }
}