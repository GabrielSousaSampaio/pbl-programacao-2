package tests.dao.workorder;

import dao.DAO;
import model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class WorkOrderListImplTest {

    //Atributtes
    private Customer client1;

    private Customer client2;

    private Customer client3;

    private WorkOrder workOrder1;
    private WorkOrder workOrder2;
    private WorkOrder workOrder3;

   @BeforeEach
    void setUp(){

       //Creating clients
       client1 = new Customer("João", "joao123@hotmail.com",
               "Rua 5, Bairro Campo Limpo","(75)92999-3244" );

       client2 = new Customer("Maria", "maria@hotmail.com",
               "Rua 32, Bairro São Judas","(75)92239-3124" );

       client3 = new Customer("Pedro", "PedroCardoso03@hotmail.com",
               "Rua 31, Bairro Centro","(73)92000-2342" );

       //Set id clients
       client1.setId(0);
       client1.setId(1);
       client1.setId(2);

       //Creating workOrders
       workOrder1 = new WorkOrder(client1,"---------------");
       workOrder2 = new WorkOrder(client2,"---------");
       workOrder3 = new WorkOrder(client3,"------------------------------");

       //Registering cleaning service
       Cleaning cleaning01 = new Cleaning(70, 20, "Clear");

       //Registering installation service
       Installation installation01 = new Installation(10,2,"Installation");

       //Registering building service
       Building building01 =  new Building();

       //Add services in service lists
       workOrder1.addService(installation01);
       workOrder2.addService(installation01); workOrder2.addService(building01); workOrder2.addService(cleaning01);
       workOrder3.addService(building01);workOrder3.addService(cleaning01);



    }

    @AfterEach
    void tearDown() {
        DAO.getWorkOrder().clearList();
    }

    @Test
    void create() {

        //Registering in WorkOrderDAO();
        WorkOrder newWorkOrder01 = DAO.getWorkOrder().create(workOrder1);
        WorkOrder newWorkOrder02 = DAO.getWorkOrder().create(workOrder2);
        WorkOrder newWorkOrder03 = DAO.getWorkOrder().create(workOrder3);

        //Asserts: Comparing the WorkOrder objects
        assertEquals(workOrder1,newWorkOrder01);
        assertEquals(workOrder2,newWorkOrder02);
        assertEquals(workOrder3,newWorkOrder03);

    }

    @Test
    void findMany() {

        //Registering in WorkOrderDAO();
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Create workOrderList
        List<WorkOrder> workOrderList = new ArrayList<WorkOrder>();

        //Adding work orderds
        workOrderList.add(workOrder1);
        workOrderList.add(workOrder2);
        workOrderList.add(workOrder3);

        //Assert: Comparing the lists
        assertEquals(DAO.getWorkOrder().FindMany(), workOrderList);

    }

    @Test
    void findById() {

        //Registering in WorkOrderDAO();
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Asserts: Comparing the WorkOrder objects
        assertEquals(workOrder1,DAO.getWorkOrder().FindById(workOrder1.getId()));


    }

    @Test
    void findByTechnicianId(){

        //Registering in WorkOrderDAO();
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Creating new technician
        Technician technician1 =  new Technician("Pedro","Perdro@email.com", "12345");
        technician1.setId(1);


        List<WorkOrder> workOrderList = new ArrayList<WorkOrder>();
        workOrderList.add(workOrder1);
        workOrderList.add(workOrder2);
        workOrderList.add(workOrder3);


        workOrder1.setTechnicianId(technician1);
        workOrder2.setTechnicianId(technician1);
        workOrder3.setTechnicianId(technician1);

        //Assert
        assertEquals(workOrderList, DAO.getWorkOrder().FindByTechnicianId(workOrder1.getTechnicianId()));


    }

    @Test
    void findByCustomerId(){

        //Registering in WorkOrderDAO();
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        Customer customer1 =  new Customer("Gabriel","Gabriel@email.com", "Rua x", "(99)9999-9999");
        customer1.setId(1);

        List<WorkOrder> workOrderList = new ArrayList<WorkOrder>();
        workOrderList.add(workOrder1);
        workOrderList.add(workOrder2);
        workOrderList.add(workOrder3);


        workOrder1.setCustomerId(customer1);
        workOrder2.setCustomerId(customer1);
        workOrder3.setCustomerId(customer1);


        assertEquals(workOrderList, DAO.getWorkOrder().FindByCustomerId(workOrder1.getCustomerId()));

    }

    @Test
    void getFinishedWorkOrders(){

        //Registering in WorkOrderDAO();
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        workOrder1.finished();
        workOrder2.finished();
        workOrder3.finished();

        List<WorkOrder> workOrderFinishedList = new ArrayList<WorkOrder>();
        workOrderFinishedList.add(workOrder1);
        workOrderFinishedList.add(workOrder2);
        workOrderFinishedList.add(workOrder3);

        assertEquals(workOrderFinishedList, DAO.getWorkOrder().getFinishedWorkOrders());


    }

    @Test
    void getFinishedWorkOrdersTotalPrice(){


        //Registering in WorkOrderDAO();
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        workOrder1.finished();
        workOrder2.finished();
        workOrder3.finished();

        List<WorkOrder> workOrderFinishedList = new ArrayList<WorkOrder>();
        workOrderFinishedList.add(workOrder1);
        workOrderFinishedList.add(workOrder2);
        workOrderFinishedList.add(workOrder3);

        double totalPrice = 0;
        for (WorkOrder w: workOrderFinishedList){
            totalPrice += w.getPrice();
        }


        assertEquals(totalPrice, DAO.getWorkOrder().getFinishedWorkOrdersTotalPrice());


    }

    @Test
    void getFinishedWorkOrdersTotalCost(){

        //Registering in WorkOrderDAO();
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        workOrder1.finished();
        workOrder2.finished();
        workOrder3.finished();

        List<WorkOrder> workOrderFinishedList = new ArrayList<WorkOrder>();
        workOrderFinishedList.add(workOrder1);
        workOrderFinishedList.add(workOrder2);
        workOrderFinishedList.add(workOrder3);

        double totalCost = 0;
        for (WorkOrder w: workOrderFinishedList){
            totalCost += w.getCost();
        }


        assertEquals(totalCost, DAO.getWorkOrder().getFinishedWorkOrdersTotalCost());


    }

    @Test
    void getFinishedWorkOrdersAverageTime(){

        //Registering in WorkOrderDAO();
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        workOrder1.finished();
        workOrder2.finished();
        workOrder3.finished();

        List<WorkOrder> workOrderFinishedList = new ArrayList<WorkOrder>();
        workOrderFinishedList.add(workOrder1);
        workOrderFinishedList.add(workOrder2);
        workOrderFinishedList.add(workOrder3);



        double avarageTime = 0;
        for (WorkOrder w: workOrderFinishedList){

            avarageTime += w.waitingTime();

        }
        avarageTime /= workOrderFinishedList.size();

        assertEquals(avarageTime, DAO.getWorkOrder().getFinishedWorkOrdersAverageTime());

    }

    @Test
    void getFinishedWorkOrdersAverageRating(){

        //Registering in WorkOrderDAO();
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        workOrder1.finished();
        workOrder2.finished();
        workOrder3.finished();

        workOrder1.setSatisfaction(5);
        workOrder1.setSatisfaction(2);
        workOrder1.setSatisfaction(3);


        List<WorkOrder> workOrderFinishedList = new ArrayList<WorkOrder>();
        workOrderFinishedList.add(workOrder1);
        workOrderFinishedList.add(workOrder2);
        workOrderFinishedList.add(workOrder3);



        double avarageRating = 0;
        for (WorkOrder w: workOrderFinishedList){

            avarageRating += w.getSatisfaction();

        }
        avarageRating /= workOrderFinishedList.size();

        assertEquals(avarageRating, DAO.getWorkOrder().getFinishedWorkOrdersAverageRating());

    }

    @Test
    void getFinishedWorkOrdersUsedComponents(){

        //Registering in WorkOrderDAO();
        DAO.getWorkOrder().create(workOrder1);

        Building building02 =  new Building();

        building02.addComponent(new ComputerComponent(300,50,20,"RAM_16GB","XXXXX"));

        workOrder1.addService(building02);
        workOrder1.finished();


        assertEquals(building02.getUsedComponents(), DAO.getWorkOrder().getFinishedWorkOrdersUsedComponents());

    }

    @Test
    void update() {

        //Registering in WorkOrderDAO();
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        workOrder1.setDescription("++++++");
        DAO.getWorkOrder().update(workOrder1);

        assertEquals(workOrder1, DAO.getWorkOrder().FindById(workOrder1.getId()));
    }

    @Test
    void delete() {

        //Registering in WorkOrderDAO();
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        int workOrderId1 = workOrder1.getId();
        int workOrderId2 = workOrder2.getId();
        int workOrderId3 = workOrder3.getId();

        DAO.getWorkOrder().delete(workOrder1.getId());
        DAO.getWorkOrder().delete(workOrder2.getId());
        DAO.getWorkOrder().delete(workOrder3.getId());

        assertNull(DAO.getWorkOrder().FindById(workOrderId1));
        assertNull(DAO.getWorkOrder().FindById(workOrderId2));
        assertNull(DAO.getWorkOrder().FindById(workOrderId3));


    }

    @Test
    void clearList(){

        //Registering in WorkOrderDAO();
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        DAO.getWorkOrder().clearList();

        assertEquals(DAO.getWorkOrder().FindMany().size(), 0);

    }
}