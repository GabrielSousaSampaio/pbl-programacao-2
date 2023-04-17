package main.java.tests.dao.cleaning;

import main.java.dao.DAO;
import main.java.model.services.Cleaning;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CleaningListImplTest {

    //Atributos
    private Cleaning cleaning1;
    private Cleaning cleaning2;

    @BeforeEach
    void setUp() {

        //Criando dois serviços de limpeza para os testes
        cleaning1 = new Cleaning(50,20,"Clening1");
        cleaning2 = new Cleaning(50,20,"Clening2");

    }

    @AfterEach
    void tearDown() {

        //Limpando a lista após os testes
        DAO.getCleaning().clearList();
    }

    @Test
    void create() {

        //Salvando os serviços de limpeza no sistema através do DAO
        Cleaning saveCleaning1 = DAO.getCleaning().create(cleaning1);
        Cleaning saveCleaning2 = DAO.getCleaning().create(cleaning2);

        //Verificando se os serviços de limpeza salvos no sistema e os serviços de limpeza enviados são iguais
        assertEquals(cleaning1, saveCleaning1);
        assertEquals(cleaning2, saveCleaning2);

    }

    @Test
    void findMany() {

        //Salvando os serviços de limpeza no sistema através do DAO
        DAO.getCleaning().create(cleaning1);
        DAO.getCleaning().create(cleaning2);

        //Salvando os serviços de limpeza em uma lista
        List<Cleaning> cleaningList = new ArrayList<Cleaning>();

        cleaningList.add(cleaning1);
        cleaningList.add(cleaning2);

        //Verificando se as listas são iguais
        assertEquals(cleaningList, DAO.getCleaning().FindMany());
    }

    @Test
    void findById() {

        //Salvando os serviços de limpeza no sistema através do DAO
        DAO.getCleaning().create(cleaning1);
        DAO.getCleaning().create(cleaning2);

        //Verificando se os serviços de limpeza encontrados através do id e os serviços de limpeza enviados são iguais
        assertEquals(cleaning1, DAO.getCleaning().FindById(cleaning1.getId()));
        assertEquals(cleaning2, DAO.getCleaning().FindById(cleaning2.getId()));
    }

    @Test
    void update() {

        //Salvando os serviços de limpeza no sistema através do DAO
        DAO.getCleaning().create(cleaning1);
        DAO.getCleaning().create(cleaning2);

        //Alterando o nome dos serviços de limpeza
        cleaning1.setCleaningName("NewCleaning1");
        cleaning2.setCleaningName("NewCleaning2");

        //Atualizando os dados dos serviços de limpeza
        DAO.getCleaning().update(cleaning1);
        DAO.getCleaning().update(cleaning2);

        //Verificando se os serviços de limpeza são iguais, ou seja, se foram atualizados
        assertEquals(cleaning1, DAO.getCleaning().FindById(cleaning1.getId()));
        assertEquals(cleaning2, DAO.getCleaning().FindById(cleaning2.getId()));
    }

    @Test
    void delete() {

        //Salvando os serviços de limpeza no sistema através do DAO
        DAO.getCleaning().create(cleaning1);
        DAO.getCleaning().create(cleaning2);

        //Recebendo os id's dos serviços de limpeza
        int cleaningId1 = cleaning1.getId();
        int cleaningId2 = cleaning2.getId();

        //Deletando os serviços de limpeza do sistema
        DAO.getCleaning().delete(cleaning1.getId());
        DAO.getCleaning().delete(cleaning2.getId());

        //Verificando se o retorno após a busca é nulo
        assertNull(DAO.getCleaning().FindById(cleaningId1));
        assertNull(DAO.getCleaning().FindById(cleaningId2));
    }

    @Test
    void clearList() {

        //Salvando os serviços de limpeza no sistema através do DAO
        DAO.getCleaning().create(cleaning1);
        DAO.getCleaning().create(cleaning2);

        //Limpando a lista de serviços de limpeza
        DAO.getCleaning().clearList();

        //Verificando se o tamanho da lista de serviços de limpeza do sistema é 0
        assertEquals(DAO.getCleaning().FindMany().size(), 0);

    }
}