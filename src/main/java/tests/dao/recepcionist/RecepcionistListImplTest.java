package main.java.tests.dao.recepcionist;

import main.java.dao.DAO;
import main.java.model.users.Recepcionist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecepcionistListImplTest {

    //Atributos
    private Recepcionist recepcionist1;
    private Recepcionist recepcionist2;


    @BeforeEach
    void setUp() {

        //Criando dois recepcionistas para os testes
        recepcionist1 = new Recepcionist("Marcos","marcos@email.com","00001");
        recepcionist2 = new Recepcionist("Leonardo","leonardo@email.com","11111");

    }

    @AfterEach
    void tearDown() {

        //Limpando a lista após os testes
        DAO.getRecepcionist().clearList();
    }

    @Test
    void create() {

        //Salvando os recepcionistas no sistema através do DAO
        Recepcionist saveRecepcionist1 = DAO.getRecepcionist().create(recepcionist1);
        Recepcionist saveRecepcionist2 = DAO.getRecepcionist().create(recepcionist2);

        //Verificando se os recepcionistas salvos no sistema e os recepcionistas enviados são iguais
        assertEquals(recepcionist1, saveRecepcionist1);
        assertEquals(recepcionist2, saveRecepcionist2);

    }

    @Test
    void findMany() {

        //Salvando os recepcionistas no sistema através do DAO
        DAO.getRecepcionist().create(recepcionist1);
        DAO.getRecepcionist().create(recepcionist2);

        //Salvando os recepcionistas de instalação em uma lista
        List<Recepcionist> recepcionistList = new ArrayList<Recepcionist>();

        recepcionistList.add(recepcionist1);
        recepcionistList.add(recepcionist2);

        //Verificando se as listas são iguais
        assertEquals(recepcionistList, DAO.getRecepcionist().FindMany());

    }

    @Test
    void findById() {

        //Salvando os recepcionistas no sistema através do DAO
        DAO.getRecepcionist().create(recepcionist1);
        DAO.getRecepcionist().create(recepcionist2);

        //Verificando se os recepcionistas encontrados através do id e os recepcionistas enviados são iguais
        assertEquals(recepcionist1, DAO.getRecepcionist().FindById(recepcionist1.getId()));
        assertEquals(recepcionist2, DAO.getRecepcionist().FindById(recepcionist2.getId()));

    }

    @Test
    void update() {

        //Salvando os recepcionistas no sistema através do DAO
        DAO.getRecepcionist().create(recepcionist1);
        DAO.getRecepcionist().create(recepcionist2);

        //Alterando o nome dos recepcionistas
        recepcionist1.setName("Marcos Silva");
        recepcionist2.setName("Leonardo Souza");

        //Atualizando os dados dos recepcionistas
        DAO.getRecepcionist().update(recepcionist1);
        DAO.getRecepcionist().update(recepcionist2);

        //Verificando se os recepcionistas são iguais, ou seja, se foram atualizados
        assertEquals(recepcionist1, DAO.getRecepcionist().FindById(recepcionist1.getId()));
        assertEquals(recepcionist2, DAO.getRecepcionist().FindById(recepcionist2.getId()));

    }

    @Test
    void delete() {

        //Salvando os recepcionistas no sistema através do DAO
        DAO.getRecepcionist().create(recepcionist1);
        DAO.getRecepcionist().create(recepcionist2);

        //Recebendo os id's dos recepcionistas
        int recepcionistId1 = recepcionist1.getId();
        int recepcionistId2 = recepcionist2.getId();

        //Deletando os recepcionistas do sistema
        DAO.getRecepcionist().delete(recepcionist1.getId());
        DAO.getRecepcionist().delete(recepcionist2.getId());

        //Verificando se o retorno após a busca é nulo
        assertNull(DAO.getRecepcionist().FindById(recepcionistId1));
        assertNull(DAO.getRecepcionist().FindById(recepcionistId2));
    }

    @Test
    void clearList() {

        //Salvando os recepcionistas no sistema através do DAO
        DAO.getRecepcionist().create(recepcionist1);
        DAO.getRecepcionist().create(recepcionist2);

        //Limpando a lista dos recepcionistas
        DAO.getRecepcionist().clearList();

        //Verificando se o tamanho da lista dos recepcionistas do sistema é 0
        assertEquals(DAO.getRecepcionist().FindMany().size(), 0);

    }
}