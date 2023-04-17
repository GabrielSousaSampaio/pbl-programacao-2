package tests.model;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class WorkOrderTest {

    Customer customer;
    WorkOrder workOrder;
    Technician technician;
    Installation installation;
    Cleaning cleaning;

    @BeforeEach
    public void setUp(){
        installation = new Installation(100, 20, "Windows Vista");
        cleaning = new Cleaning(70, 0,"Limpeza com ventinho");
        technician = new Technician("Flavio", "flavinManutencaoChapaQuente2010@uol.com", "123456");
        customer = new Customer("João", "joao123@hotmail.com", "Rua 5, Bairro Campo Limpo","(75)92999-3244" );
        workOrder = new WorkOrder(customer, "Serviço teste");
    }

    @Test
    public void workOrderPaymentMethod(){
        workOrder.setPaymentToCreditCard();
        Assertions.assertEquals("Cartão de Crédito", workOrder.getPaymentMethod());

        workOrder.setPaymentToPix();
        Assertions.assertEquals("Pix", workOrder.getPaymentMethod());

        workOrder.setPaymentToCash();
        Assertions.assertEquals("À vista", workOrder.getPaymentMethod());

        workOrder.setPaymentMethod("TestPaymentMethod");
        Assertions.assertEquals("TestPaymentMethod", workOrder.getPaymentMethod());
    }

    @Test
    public void workOrderStatus(){
        Assertions.assertEquals(true, workOrder.isOngoing());

        workOrder.finished();
        Assertions.assertEquals(true, workOrder.isFinshed());

        workOrder.cancel();
        Assertions.assertEquals(true, workOrder.isCanceled());
    }

    @Test
    public void workOrderSatisfaction(){
        Assertions.assertEquals(0, workOrder.getSatisfaction());

        workOrder.setSatisfaction(5);
        Assertions.assertEquals(5, workOrder.getSatisfaction());
    }

    @Test
    public void addAndRemoveServiceToServiceList(){
        workOrder.addService(installation);
        workOrder.addService(cleaning);
        Assertions.assertEquals(2, workOrder.getServicelist().size());

        workOrder.removeService(installation);
        Assertions.assertEquals(1, workOrder.getServicelist().size());

        workOrder.setServiceList(new ArrayList<Service>());
        Assertions.assertEquals(0, workOrder.getServicelist().size());
    }

    @Test
    public void getprice(){
        workOrder.addService(installation);
        workOrder.addService(cleaning);
        Assertions.assertEquals(170, workOrder.getPrice());
    }

    @Test
    public void getCost(){
        workOrder.addService(installation);
        workOrder.addService(cleaning);
        Assertions.assertEquals(20, workOrder.getCost());
    }

    @Test
    public void waitingTime(){
        workOrder.setCreatedAt();
        workOrder.setFinishedAt();
        Assertions.assertEquals(0, workOrder.waitingTime());
    }

    @Test
    public void gettersAndSetters(){
        workOrder.setId(5);
        customer.setId(10);
        workOrder.setCustomerId(customer);
        technician.setId(15);
        workOrder.setTechnicianId(technician);
        workOrder.setStatus("Status Teste");
        workOrder.setDescription("Descrição");
        workOrder.setPaidOut(true);

        Assertions.assertEquals(5, workOrder.getId());
        Assertions.assertEquals(10, workOrder.getCustomerId());
        Assertions.assertEquals(15, workOrder.getTechnicianId());
        Assertions.assertEquals("Status Teste", workOrder.getStatus());
        Assertions.assertEquals("Descrição", workOrder.getDescription());
        Assertions.assertEquals(true, workOrder.isPaidOut());
    }
}