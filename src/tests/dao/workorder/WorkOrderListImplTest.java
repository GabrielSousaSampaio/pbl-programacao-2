package tests.dao.workorder;

import dao.DAO;
import dao.user.UserDAO;
import dao.user.UserListImpl;
import dao.workorder.WorkOrderDAO;
import dao.workorder.WorkOrderListImpl;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkOrderListImplTest {

  /*  private Customer customer;
    private List<Service> servicos;
    private WorkOrder workOrder;*/

   @BeforeEach
    void setUp(){

    }

    @Test
    void create() {

       //Creating
        WorkOrderDAO workOrderDAO = new WorkOrderListImpl();

        //Creating clients
        Customer cliente1 = new Customer("João", "joao123@hotmail.com",
                "Rua 5, Bairro Campo Limpo","(75)92999-3244" );

        Customer cliente2 = new Customer("Maria", "maria@hotmail.com",
                "Rua 32, Bairro São Judas","(75)92239-3124" );

        Customer cliente3 = new Customer("Pedro", "PedroCardoso03@hotmail.com",
                "Rua 31, Bairro Centro","(73)92000-2342" );


        //Set id clients
        cliente1.setId(0);
        cliente1.setId(1);
        cliente1.setId(2);

        //Creating workOrders
        WorkOrder workOrder1 = new WorkOrder(cliente1,"---------------");
        WorkOrder workOrder2 = new WorkOrder(cliente2,"---------");
        WorkOrder workOrder3 = new WorkOrder(cliente3,"&&&&&&&&&&&&&");

        //Registering cleaning service
        Cleaning cleaning01 = new Cleaning();

        //Registering installation service
        Installation installation01 = new Installation(10,0,50,0);

        //Registering building service
        Building building01 =  new Building();

        //Creating service lists
        List<Service> servicesList01 = new ArrayList<Service>();
        List<Service> servicesList02 = new ArrayList<Service>();
        List<Service> servicesList03 = new ArrayList<Service>();

        //Add services in service lists
        servicesList01.add(installation01);
        servicesList02.add(installation01); servicesList02.add(building01); servicesList02.add(cleaning01);
        servicesList03.add(building01); servicesList03.add(cleaning01);


        //Setting WorkOrder service list
        workOrder1.setServicelist(servicesList01);
        workOrder2.setServicelist(servicesList02);
        workOrder3.setServicelist(servicesList03);

        //Registering in WorkOrderDAO();
        WorkOrder newWorkOrder01 = DAO.getWorkOrder().create(workOrder1);
        WorkOrder newWorkOrder02 = DAO.getWorkOrder().create(workOrder2);
        WorkOrder newWorkOrder03 = DAO.getWorkOrder().create(workOrder3);

        //Asserts
        assertEquals(workOrder1,newWorkOrder01);
        assertEquals(workOrder2,newWorkOrder02);
        assertEquals(workOrder3,newWorkOrder03);

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