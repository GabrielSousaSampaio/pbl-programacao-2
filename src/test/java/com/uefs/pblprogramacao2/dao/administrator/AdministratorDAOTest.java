package com.uefs.pblprogramacao2.dao.administrator;

import com.uefs.pblprogramacao2.dao.DAO;
import com.uefs.pblprogramacao2.model.users.Administrator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdministratorDAOTest {


    //Atributos
    private Administrator administrator1;
    private Administrator administrator2;
    Administrator saveAdministrator1;
    Administrator saveAdministrator2;

    @BeforeEach
    void setUp() {

        //Criando dois administradores para os testes
        administrator1 = new Administrator("João","joao@emal.com","22222");
        administrator2 = new Administrator("Maria","maria@emal.com","33333");

        //Salvando administradores com DAO
        saveAdministrator1 = DAO.getAdministrator().create(administrator1);
        saveAdministrator2 = DAO.getAdministrator().create(administrator2);
    }

    @AfterEach
    void tearDown() {

        //Limpando a lista após os testes
        DAO.getAdministrator().clearList();
    }

    @Test
    void create() {
        //Verificando se o administrador salvo no sistema e o administrador enviado são iguais
        assertEquals(administrator1, saveAdministrator1);
        assertEquals(administrator2, saveAdministrator2);
    }

    @Test
    void findMany() {
        //Salvando os administradores em uma lista
        List<Administrator> administratorList = new ArrayList<Administrator>();

        administratorList.add(administrator1);
        administratorList.add(administrator2);

        //Verificando se as listas são iguais
        assertEquals(administratorList, DAO.getAdministrator().FindMany());
    }

    @Test
    void findById() {
        //Verificando se o administrador encontrado através do id e o administrador enviado são iguais
        assertEquals(administrator1, DAO.getAdministrator().FindById(administrator1.getId()));
        assertEquals(administrator2, DAO.getAdministrator().FindById(administrator2.getId()));
    }

    @Test
    void update() {
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
        //Limpando a lista de administradores
        DAO.getAdministrator().clearList();

        //Verificando se o tamanho da lista de administradores do sistema é 0
        assertEquals(DAO.getAdministrator().FindMany().size(), 0);
    }
}