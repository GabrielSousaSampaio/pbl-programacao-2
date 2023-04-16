package tests.model;

import model.Customer;
import model.WorkOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class WorkOrderTest {

    Customer customer = new Customer("João", "joao123@hotmail.com", "Rua 5, Bairro Campo Limpo","(75)92999-3244" );
    WorkOrder workOrder = new WorkOrder(customer, "Serviço teste");

    /*@BeforeEach
    public void setUp(){

    }*/

    /*@Test
    public void setCreatedAt(){
        Assertions.assertEquals(LocalDateTime.now(), workOrder.getCreatedAt());
    }*/

    @Test
    public void workOrderPaymentMethod(){
        workOrder.setPaymentToCreditCard();
        Assertions.assertEquals(workOrder.getPaymentMethod(), "Cartão de Crédito");
        workOrder.setPaymentToPix();
        Assertions.assertEquals(workOrder.getPaymentMethod(), "Pix");
        workOrder.setPaymentToCash();
        Assertions.assertEquals(workOrder.getPaymentMethod(), "À vista");
    }

    @Test
    public void workOrderStatus(){
        Assertions.assertEquals(workOrder.isOngoing(), true);
        workOrder.finished();
        Assertions.assertEquals(workOrder.isFinshed(), true);
        workOrder.cancel();
        Assertions.assertEquals(workOrder.isCanceled(), true);
    }

    @Test
    public void workOrderSatisfaction(){
        Assertions.assertEquals(workOrder.getSatisfaction(), 0);
        workOrder.setSatisfaction(5);
        Assertions.assertEquals(workOrder.getSatisfaction(), 5);
    }
}