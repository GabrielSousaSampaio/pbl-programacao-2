package tests.dao.component;

import dao.DAO;
import model.components.Component;
import model.components.ComputerComponent;
import model.components.OtherComponent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComponentListImplTest {

    //Atributos
    private ComputerComponent component1;
    private OtherComponent component2;

    @BeforeEach
    void setUp() {

        //Criando dois componentes para os testes
        component1 = new ComputerComponent(30,0,50,"GPU XXX","PPPPPP");
        component2 = new OtherComponent(50,12,20,"LLLLLLLLLLLLLLLLLLLL");

    }

    @AfterEach
    void tearDown() {

        //Limpando a lista após os testes
        DAO.getComponent().clearList();

    }

    @Test
    void create() {

        //Salvando os componentes no sistema através do DAO
        Component saveComponent1 = DAO.getComponent().create(component1);
        Component saveComponent2 = DAO.getComponent().create(component2);

        //Verificando se os componentes salvos no sistema e os componentes enviados são iguais
        assertEquals(component1, saveComponent1);
        assertEquals(component2, saveComponent2);

    }

    @Test
    void findMany() {

        //Salvando os componentes no sistema através do DAO
        DAO.getComponent().create(component1);
        DAO.getComponent().create(component2);

        //Salvando os componentes em uma lista
        List<Component> componentList = new ArrayList<Component>();

        componentList.add(component1);
        componentList.add(component2);

        //Verificando se as listas são iguais
        assertEquals(componentList, DAO.getComponent().FindMany());

    }

    @Test
    void findById() {

        //Salvando os componentes no sistema através do DAO
        DAO.getComponent().create(component1);
        DAO.getComponent().create(component2);

        //Verificando se os componentes encontrados através do id e os componentes enviados são iguais
        assertEquals(component1, DAO.getComponent().FindById(component1.getId()));
        assertEquals(component2, DAO.getComponent().FindById(component2.getId()));

    }

    @Test
    void update() {

        //Salvando os componentes no sistema através do DAO
        DAO.getComponent().create(component1);
        DAO.getComponent().create(component2);

        //Alterando a quantidade dos componentes
        component1.setQuantity(200);
        component2.setQuantity(300);

        //Atualizando os dados dos componentes
        DAO.getComponent().update(component1);
        DAO.getComponent().update(component2);

        //Verificando se os componentes são iguais, ou seja, se foram atualizados
        assertEquals(component1, DAO.getComponent().FindById(component1.getId()));
        assertEquals(component2, DAO.getComponent().FindById(component2.getId()));

    }

    @Test
    void delete() {

        //Salvando os componentes no sistema através do DAO
        DAO.getComponent().create(component1);
        DAO.getComponent().create(component2);

        //Recebendo os id's dos componentes
        int componentId1 = component1.getId();
        int componentId2 = component2.getId();

        //Deletando os componentes do sistema
        DAO.getComponent().delete(component1.getId());
        DAO.getComponent().delete(component2.getId());

        //Verificando se o retorno após a busca é nulo
        assertNull(DAO.getComponent().FindById(componentId1));
        assertNull(DAO.getComponent().FindById(componentId2));

    }

    @Test
    void clearList() {

        //Salvando os componentes no sistema através do DAO
        DAO.getComponent().create(component1);
        DAO.getComponent().create(component2);

        //Limpando a lista de componentes
        DAO.getComponent().clearList();

        //Verificando se o tamanho da lista de componentes do sistema é 0
        assertEquals(DAO.getComponent().FindMany().size(), 0);
    }

    @Test
    void pickingComponent() {

        //Salvando os componentes no sistema através do DAO
        DAO.getComponent().create(component1);
        DAO.getComponent().create(component2);

        //Copiando os componentes
        Component componentCopy1 = component1.copy();
        Component componentCopy2 = component2.copy();

        //Verificando a quantidade dos componentes retirados e as armazenadas ainda no sistema
        assertEquals(2, DAO.getComponent().pickingComponent(component1, 2).getQuantity());
        assertEquals(48, DAO.getComponent().FindById(component1.getId()).getQuantity());

        assertEquals(4, DAO.getComponent().pickingComponent(component2, 4).getQuantity());
        assertEquals(16, DAO.getComponent().FindById(component2.getId()).getQuantity());

    }
}