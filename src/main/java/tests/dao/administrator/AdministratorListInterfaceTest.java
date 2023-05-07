package main.java.tests.dao.administrator;

import main.java.dao.DAO;
import main.java.model.users.Administrator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdministratorListInterfaceTest {


    //Atributos
    private Administrator administrator1;
    private Administrator administrator2;

    @BeforeEach
    void setUp() {

        //Criando dois administradores para os testes
        administrator1 = new Administrator("João","joao@emal.com","22222");
        administrator2 = new Administrator("Maria","maria@emal.com","33333");
    }

    @AfterEach
    void tearDown() {

        //Limpando a lista após os testes
        DAO.getAdministrator().clearList();
    }

    @Test
    void create() {

        //Salvando os administradores no sistema através do DAO
        Administrator saveAdministrator1 = DAO.getAdministrator().create(administrator1);
        Administrator saveAdministrator2 = DAO.getAdministrator().create(administrator2);

        //Verificando se o administrador salvo no sistema e o administrador enviado são iguais
        assertEquals(administrator1, saveAdministrator1);
        assertEquals(administrator2, saveAdministrator2);
    }

    @Test
    void findMany() {

        //Salvando os administradores no sistema através do DAO
        DAO.getAdministrator().create(administrator1);
        DAO.getAdministrator().create(administrator2);

        //Salvando os administradores em uma lista
        List<Administrator> administratorList = new ArrayList<Administrator>();

        administratorList.add(administrator1);
        administratorList.add(administrator2);

        //Verificando se as listas são iguais
        assertEquals(administratorList, DAO.getAdministrator().FindMany());
    }

    @Test
    void findById() {

        //Salvando os administradores no sistema através do DAO
        DAO.getAdministrator().create(administrator1);
        DAO.getAdministrator().create(administrator2);

        //Verificando se o administrador encontrado através do id e o administrador enviado são iguais
        assertEquals(administrator1, DAO.getAdministrator().FindById(administrator1.getId()));
        assertEquals(administrator2, DAO.getAdministrator().FindById(administrator2.getId()));
    }

    @Test
    void update() {

        //Salvando os administradores no sistema através do DAO
        DAO.getAdministrator().create(administrator1);
        DAO.getAdministrator().create(administrator2);

        //Alterando o nome dos adminstradores
        administrator1.setName("João Silva");
        administrator2.setName("Maria Almeida");

        //Atualizando os dados dos administradores
        DAO.getAdministrator().update(administrator1);
        DAO.getAdministrator().update(administrator2);

        //Verificando se os administradores são iguais, ou seja, se foram atualizados
        assertEquals(administrator1, DAO.getAdministrator().FindById(administrator1.getId()));
        assertEquals(administrator2, DAO.getAdministrator().FindById(administrator2.getId()));
    }

    @Test
    void delete() {

        //Salvando os administradores no sistema através do DAO
        DAO.getAdministrator().create(administrator1);
        DAO.getAdministrator().create(administrator2);

        //Recebendo os id's do administradores
        int administratorId1 = administrator1.getId();
        int administratorId2 = administrator2.getId();

        //Deletando os administradores do sistema
        DAO.getAdministrator().delete(administrator1.getId());
        DAO.getAdministrator().delete(administrator2.getId());

        //Verificando se o retorno após a busca é nulo
        assertNull(DAO.getAdministrator().FindById(administratorId1));
        assertNull(DAO.getAdministrator().FindById(administratorId2));
    }

    @Test
    void clearList() {

        //Salvando os administradores no sistema através do DAO
        DAO.getAdministrator().create(administrator1);
        DAO.getAdministrator().create(administrator2);

        //Limpando a lista de administradores
        DAO.getAdministrator().clearList();

        //Verificando se o tamanho da lista de administradores do sistema é 0
        assertEquals(DAO.getAdministrator().FindMany().size(), 0);


    }
}