package main.java.tests.dao.customer;

import main.java.dao.DAO;
import main.java.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerListInterfaceTest {

    //Atributos
    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    void setUp() {

        //Criando dois clientes para os testes
        customer1 = new Customer("João","joao@email.com","Rua x","(99)9999-9999");
        customer2 = new Customer("Luis","luis@email.com","Rua y","(88)8888-8888");
    }

    @AfterEach
    void tearDown() {

        //Limpando a lista após os testes
        DAO.getCustomer().clearList();

    }

    @Test
    void create() {

        //Salvando os clientes no sistema através do DAO
        Customer saveCustomer1 = DAO.getCustomer().create(customer1);
        Customer saveCustomer2 = DAO.getCustomer().create(customer2);

        //Verificando se os clientes salvos no sistema e os clientes enviados são iguais
        assertEquals(customer1, saveCustomer1);
        assertEquals(customer2, saveCustomer2);

    }

    @Test
    void findMany() {

        //Salvando os clientes no sistema através do DAO
        DAO.getCustomer().create(customer1);
        DAO.getCustomer().create(customer2);

        //Salvando os clientes em uma lista
        List<Customer> customerList = new ArrayList<Customer>();

        customerList.add(customer1);
        customerList.add(customer2);

        //Verificando se as listas são iguais
        assertEquals(customerList, DAO.getCustomer().FindMany());

    }

    @Test
    void findById() {

        //Salvando os clientes no sistema através do DAO
        DAO.getCustomer().create(customer1);
        DAO.getCustomer().create(customer2);

        //Verificando se os clientes encontrados através do id e os clientes enviados são iguais
        assertEquals(customer1, DAO.getCustomer().FindById(customer1.getId()));
        assertEquals(customer2, DAO.getCustomer().FindById(customer2.getId()));

    }

    @Test
    void update() {

        //Salvando os clientes no sistema através do DAO
        DAO.getCustomer().create(customer1);
        DAO.getCustomer().create(customer2);

        //Alterando o nome dos clientes
        customer1.setName("João Carlos");
        customer2.setName("Luis Henrique");

        //Atualizando os dados dos clientes
        DAO.getCustomer().update(customer1);
        DAO.getCustomer().update(customer2);

        //Verificando se os clientes são iguais, ou seja, se foram atualizados
        assertEquals(customer1, DAO.getCustomer().FindById(customer1.getId()));
        assertEquals(customer2, DAO.getCustomer().FindById(customer2.getId()));

    }

    @Test
    void delete() {

        //Salvando os clientes no sistema através do DAO
        DAO.getCustomer().create(customer1);
        DAO.getCustomer().create(customer2);

        //Recebendo os id's dos clientes
        int customerId1 = customer1.getId();
        int customerId2 = customer2.getId();

        //Deletando os clientes do sistema
        DAO.getCustomer().delete(customer1.getId());
        DAO.getCustomer().delete(customer2.getId());

        //Verificando se o retorno após a busca é nulo
        assertNull(DAO.getCustomer().FindById(customerId1));
        assertNull(DAO.getCustomer().FindById(customerId2));

    }

    @Test
    void clearList() {

        //Salvando os clientes no sistema através do DAO
        DAO.getCustomer().create(customer1);
        DAO.getCustomer().create(customer2);

        //Limpando a lista de clientes
        DAO.getCustomer().clearList();

        //Verificando se o tamanho da lista de clientes do sistema é 0
        assertEquals(DAO.getCustomer().FindMany().size(), 0);

    }
}