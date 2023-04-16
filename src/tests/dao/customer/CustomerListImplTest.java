package tests.dao.customer;

import dao.DAO;
import model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerListImplTest {

    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    void setUp() {

        customer1 = new Customer("João","joao@email.com","Rua x","(99)9999-9999");
        customer2 = new Customer("Luis","luis@email.com","Rua y","(88)8888-8888");
    }

    @AfterEach
    void tearDown() {

        DAO.getCustomer().clearList();

    }

    @Test
    void create() {

        Customer saveCustomer1 = DAO.getCustomer().create(customer1);
        Customer saveCustomer2 = DAO.getCustomer().create(customer2);

        assertEquals(customer1, saveCustomer1);
        assertEquals(customer2, saveCustomer2);

    }

    @Test
    void findMany() {

        DAO.getCustomer().create(customer1);
        DAO.getCustomer().create(customer2);

        List<Customer> customerList = new ArrayList<Customer>();

        customerList.add(customer1);
        customerList.add(customer2);


        assertEquals(customerList, DAO.getCustomer().FindMany());

    }

    @Test
    void findById() {

        DAO.getCustomer().create(customer1);
        DAO.getCustomer().create(customer2);

        assertEquals(customer1, DAO.getCustomer().FindById(customer1.getId()));
        assertEquals(customer2, DAO.getCustomer().FindById(customer2.getId()));

    }

    @Test
    void update() {

        DAO.getCustomer().create(customer1);
        DAO.getCustomer().create(customer2);

        customer1.setName("João Carlos");
        customer2.setName("Luis Henrique");

        DAO.getCustomer().update(customer1);
        DAO.getCustomer().update(customer2);

        assertEquals(customer1, DAO.getCustomer().FindById(customer1.getId()));
        assertEquals(customer2, DAO.getCustomer().FindById(customer2.getId()));

    }

    @Test
    void delete() {

        DAO.getCustomer().create(customer1);
        DAO.getCustomer().create(customer2);

        int customerId1 = customer1.getId();
        int customerId2 = customer2.getId();


        DAO.getCustomer().delete(customer1.getId());
        DAO.getCustomer().delete(customer2.getId());

        assertNull(DAO.getCustomer().FindById(customerId1));
        assertNull(DAO.getCustomer().FindById(customerId2));

    }

    @Test
    void clearList() {

        DAO.getCustomer().create(customer1);
        DAO.getCustomer().create(customer2);

        DAO.getCustomer().clearList();

        assertEquals(DAO.getCustomer().FindMany().size(), 0);

    }
}