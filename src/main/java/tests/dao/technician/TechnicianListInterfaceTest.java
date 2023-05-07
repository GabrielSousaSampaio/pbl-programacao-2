package main.java.tests.dao.technician;

import main.java.dao.DAO;
import main.java.model.users.Technician;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TechnicianListInterfaceTest {

    //Atributos
    private Technician technician1;
    private Technician technician2;
    Technician saveTechnician1;
    Technician saveTechnician2;

    @BeforeEach
    void setUp() {
        //Criando dois tecnicos para os testes
        technician1 = new Technician("João","joao@email.com","99999");
        technician2 = new Technician("Pedro","Pedro@email.com","00000");

        //Salvando os tecnicos no sistema através do DAO
        saveTechnician1 = DAO.getTechnician().create(technician1);
        saveTechnician2 = DAO.getTechnician().create(technician2);
    }

    @AfterEach
    void tearDown() {
        //Limpando a lista após os testes
        DAO.getTechnician().clearList();
    }

    @Test
    void create() {
        //Verificando se os tecnicos salvos no sistema e os tecnicos enviados são iguais
        assertEquals(technician1, saveTechnician1);
        assertEquals(technician2, saveTechnician2);
    }

    @Test
    void findMany() {
        //Salvando os tecnicos em uma lista
        List<Technician> technicianList = new ArrayList<Technician>();

        technicianList.add(technician1);
        technicianList.add(technician2);

        //Verificando se as listas são iguais
        assertEquals(technicianList, DAO.getTechnician().FindMany());
    }

    @Test
    void findById() {
        //Verificando se os tecnicos encontrados através do id e os tecnicos enviados são iguais
        assertEquals(technician1, DAO.getTechnician().FindById(technician1.getId()));
        assertEquals(technician2, DAO.getTechnician().FindById(technician2.getId()));
    }

    @Test
    void update() {
        //Alterando o nome dos tecnicos
        technician1.setName("João Silva");
        technician2.setName("Pedro Souza");

        //Atualizando os dados dos tecnicos
        DAO.getTechnician().update(technician1);
        DAO.getTechnician().update(technician2);

        //Verificando se os tecnicos são iguais, ou seja, se foram atualizados
        assertEquals(technician1, DAO.getTechnician().FindById(technician1.getId()));
        assertEquals(technician2, DAO.getTechnician().FindById(technician2.getId()));
    }

    @Test
    void delete() {
        //Recebendo os id's dos tecnicos
        int technicianId1 = technician1.getId();
        int technicianId2 = technician2.getId();

        //Deletando os tecnicos do sistema
        DAO.getTechnician().delete(technician1.getId());
        DAO.getTechnician().delete(technician2.getId());

        //Verificando se o retorno após a busca é nulo
        assertNull(DAO.getTechnician().FindById(technicianId1));
        assertNull(DAO.getTechnician().FindById(technicianId2));
    }

    @Test
    void clearList() {
        //Limpando a lista dos tecnicos
        DAO.getTechnician().clearList();

        //Verificando se o tamanho da lista dos tecnicos do sistema é 0
        assertEquals(DAO.getTechnician().FindMany().size(), 0);
    }
}