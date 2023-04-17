package tests.model;

import model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    Customer customer;

    @BeforeEach
    public void setUp(){
        customer = new Customer("Customer", "customer@gmail.com", "Rua: Cliente, número: cliente", "(75) 999999999");
    }

    @Test
    public void gettersAndSetters(){
        customer.setId(10);
        customer.setName("Jorgin");
        customer.setEmail("jorgin@gmail.com");
        customer.setPhone("(71) 990000000");
        customer.setAdress("Rua: do jorgin, número: do jorgin");

        Assertions.assertEquals(10, customer.getId());
        Assertions.assertEquals("Jorgin", customer.getName());
        Assertions.assertEquals("jorgin@gmail.com", customer.getEmail());
        Assertions.assertEquals("(71) 990000000", customer.getPhone());
        Assertions.assertEquals("Rua: do jorgin, número: do jorgin", customer.getAdress());
    }
}
