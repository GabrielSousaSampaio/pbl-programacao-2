package tests.dao.workorder;

import model.Customer;
import model.Service;
import model.WorkOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkOrderListImplTest {

    private Customer customer;
    private List<Service> servicos;
    private WorkOrder workOrder;

    @BeforeEach
    void setUp(){

        this.servicos.add();


        this.customer = new Customer("João", "joao123@hotmail.com",
                "Rua 5, Bairro Campo Limpo","(75)92999-3244" );

        this.workOrder = new WorkOrder(this.customer,"",  );
    }

    @Test
    void create() {
    }

    @Test
    void findMany() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}