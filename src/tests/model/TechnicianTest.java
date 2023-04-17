package tests.model;

import model.Customer;
import model.Technician;
import model.WorkOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TechnicianTest {
    Technician technician;
    WorkOrder workOrder;
    Customer customer;

    @BeforeEach
    public void setUp(){
        technician = new Technician("Technician", "technician@gmail.com", "123456");
        customer = new Customer("João", "joao123@hotmail.com", "Rua 5, Bairro Campo Limpo","(75)92999-3244" );
        workOrder = new WorkOrder(customer, "Serviço teste");
    }

    @Test
    public void gettersAndSetters(){
        technician.setId(53);
        technician.setName("Cleber");
        technician.setEmail("clebinBraboDasManutencoes@gmail.com");
        technician.setPassword("123123123");
        technician.setWorkingOn(workOrder);

        Assertions.assertEquals(53, technician.getId());
        Assertions.assertEquals("Cleber", technician.getName());
        Assertions.assertEquals("clebinBraboDasManutencoes@gmail.com", technician.getEmail());
        Assertions.assertEquals("123123123", technician.getPassword());
        Assertions.assertEquals(workOrder.getDescription(), technician.getWorkingOn().getDescription());
    }
}