package main.java.tests.dao.workorder;

import main.java.dao.DAO;
import main.java.model.*;
import main.java.model.components.ComputerComponent;
import main.java.model.components.OtherComponent;
import main.java.model.services.Building;
import main.java.model.services.Cleaning;
import main.java.model.services.Installation;
import main.java.model.users.Technician;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class WorkOrderListImplTest {

    //Atributos
    private Customer client1;

    private Customer client2;

    private Customer client3;

    private WorkOrder workOrder1;
    private WorkOrder workOrder2;
    private WorkOrder workOrder3;

    Technician technician1;
    Technician technician2;
    Technician technician3;

   @BeforeEach
    void setUp(){

       //Criando clientes
       client1 = new Customer("João", "joao123@hotmail.com",
               "Rua 5, Bairro Campo Limpo","(75)92999-3244" );

       client2 = new Customer("Maria", "maria@hotmail.com",
               "Rua 32, Bairro São Judas","(75)92239-3124" );

       client3 = new Customer("Pedro", "PedroCardoso03@hotmail.com",
               "Rua 31, Bairro Centro","(73)92000-2342" );

       //Criando técnicos
       technician1 = new Technician("Pedro", "PedrinDaAssistencia@uol.com.br", "123123");
       technician2 = new Technician("João","joao@email.com","99999");

       //Settando o id dos clientes
       client1.setId(0);
       client1.setId(1);
       client1.setId(2);

       //Criando ordens de serviço
       workOrder1 = new WorkOrder(client1,"---------------");
       workOrder2 = new WorkOrder(client2,"---------");
       workOrder3 = new WorkOrder(client3,"------------------------------");

       //Criando serviço de limpeza
       Cleaning cleaning01 = new Cleaning(70, 20, "Clear");

       //Criando serviço de instalação
       Installation installation01 = new Installation(10,2,"Installation");

       //Criando serviço de montagem
       Building building01 =  new Building();

       //Adicionado serviços nas ordens de serviço
       workOrder1.addService(installation01);
       workOrder2.addService(installation01); workOrder2.addService(building01); workOrder2.addService(cleaning01);
       workOrder3.addService(building01);workOrder3.addService(cleaning01);



    }

    @AfterEach
    void tearDown() {

       //Limpando a lista após os testes
       DAO.getWorkOrder().clearList();
    }

    @Test
    void create() {

        //Salvando as ordens de serviço no sistema através do DAO
        WorkOrder newWorkOrder01 = DAO.getWorkOrder().create(workOrder1);
        WorkOrder newWorkOrder02 = DAO.getWorkOrder().create(workOrder2);
        WorkOrder newWorkOrder03 = DAO.getWorkOrder().create(workOrder3);

        //Verificando se as ordens de serviço salvas no sistema e as ordens de serviço enviadas são iguais
        assertEquals(workOrder1,newWorkOrder01);
        assertEquals(workOrder2,newWorkOrder02);
        assertEquals(workOrder3,newWorkOrder03);

    }

    @Test
    void findMany() {

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Salvando as ordens de serviço em uma lista
        List<WorkOrder> workOrderList = new ArrayList<WorkOrder>();

        workOrderList.add(workOrder1);
        workOrderList.add(workOrder2);
        workOrderList.add(workOrder3);

        //Verificando se as listas são iguais
        assertEquals(DAO.getWorkOrder().FindMany(), workOrderList);

    }

    @Test
    void findById() {

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Verificando se as ordens de serviço encontradas através do id e as ordens de serviço enviadas são iguais
        assertEquals(workOrder1,DAO.getWorkOrder().FindById(workOrder1.getId()));


    }

    @Test
    void findByTechnicianId(){

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Criando tecnico
        Technician technician1 =  new Technician("Pedro","Perdro@email.com", "12345");
        technician1.setId(1);

        //Salvando as ordens de serviço em uma lista
        List<WorkOrder> workOrderList = new ArrayList<WorkOrder>();
        workOrderList.add(workOrder1);
        workOrderList.add(workOrder2);
        workOrderList.add(workOrder3);

        //Settando as ordens de serviço com o id do tecnico
        workOrder1.setTechnicianId(technician1);
        workOrder2.setTechnicianId(technician1);
        workOrder3.setTechnicianId(technician1);

        //Verificando se as listas são iguais
        assertEquals(workOrderList, DAO.getWorkOrder().FindByTechnicianId(workOrder1.getTechnicianId()));


    }

    @Test
    void findByCustomerId(){

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Criando cliente
        Customer customer1 =  new Customer("Gabriel","Gabriel@email.com", "Rua x", "(99)9999-9999");
        customer1.setId(1);

        //Salvando as ordens de serviço em uma lista
        List<WorkOrder> workOrderList = new ArrayList<WorkOrder>();
        workOrderList.add(workOrder1);
        workOrderList.add(workOrder2);
        workOrderList.add(workOrder3);

        //Settando as ordens de serviço com o id do cliente
        workOrder1.setCustomerId(customer1);
        workOrder2.setCustomerId(customer1);
        workOrder3.setCustomerId(customer1);

        //Verificando se as listas são iguais
        assertEquals(workOrderList, DAO.getWorkOrder().FindByCustomerId(workOrder1.getCustomerId()));

    }

    @Test
    void getFinishedWorkOrders(){

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Finalizando as ordens de serviço
        workOrder1.finished();
        workOrder2.finished();
        workOrder3.finished();

        //Salvando as ordens de serviço em uma lista
        List<WorkOrder> workOrderFinishedList = new ArrayList<WorkOrder>();
        workOrderFinishedList.add(workOrder1);
        workOrderFinishedList.add(workOrder2);
        workOrderFinishedList.add(workOrder3);

        //Comparando as listas
        assertEquals(workOrderFinishedList, DAO.getWorkOrder().getFinishedWorkOrders());


    }

    @Test
    void getCanceledWorkOrders(){

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Finalizando as ordens de serviço
        workOrder1.cancel();
        workOrder2.cancel();

        //Salvando as ordens de serviço em uma lista
        List<WorkOrder> workOrderFinishedList = new ArrayList<WorkOrder>();
        workOrderFinishedList.add(workOrder1);
        workOrderFinishedList.add(workOrder2);

        //Comparando as listas
        assertEquals(workOrderFinishedList, DAO.getWorkOrder().getCanceledWorkOrders());


    }

    @Test
    void getOpenedWorkOrders(){

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Finalizando uma única ordem de serviço
        workOrder1.finished();


        //Salvando as ordens de serviço abertas em uma lista
        List<WorkOrder> workOrderOpenedList = new ArrayList<WorkOrder>();
        workOrderOpenedList.add(workOrder2);
        workOrderOpenedList.add(workOrder3);

        //Comparando as listas
        assertEquals(workOrderOpenedList, DAO.getWorkOrder().getOpenedWorkOrders());


    }

    @Test
    void getOpenedAndAllocatedWorkOrders(){

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Setando id dos técnicos
        technician1.setId(1);
        technician2.setId(2);

        //Atribuindo técnicos a ordens de serviço
        workOrder1.setTechnicianId(technician1);
        workOrder2.setTechnicianId(technician2);

        //Finalizando ordem de serviço
        workOrder2.finished();

        //Salvando as ordens de serviço em uma lista
        List<WorkOrder> workOrderOpenedAndAllocatedList = new ArrayList<WorkOrder>();
        workOrderOpenedAndAllocatedList.add(workOrder1);

        //Comparando as listas
        assertEquals(workOrderOpenedAndAllocatedList, DAO.getWorkOrder().getOpenedAndAllocatedWorkOrders());
    }

    @Test
    void getFirstOpenWorkOrder(){

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Finalizando a primeira ordem de serviço
        workOrder1.finished();

        //Comparando as ordens de serviço
        assertEquals(workOrder2, DAO.getWorkOrder().getFirstOpenWorkOrder());

    }

    @Test
    void getFinishedWorkOrdersTotalPrice(){


        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Finalizando as ordens de serviço
        workOrder1.finished();
        workOrder2.finished();
        workOrder3.finished();

        //Salvando as ordens de serviço em uma lista
        List<WorkOrder> workOrderFinishedList = new ArrayList<WorkOrder>();
        workOrderFinishedList.add(workOrder1);
        workOrderFinishedList.add(workOrder2);
        workOrderFinishedList.add(workOrder3);

        //Calculando o preço total das ordens de serviço
        double totalPrice = 0;
        for (WorkOrder w: workOrderFinishedList){
            totalPrice += w.getPrice();
        }

        //Comparando os preços
        assertEquals(totalPrice, DAO.getWorkOrder().getFinishedWorkOrdersTotalPrice());


    }

    @Test
    void getFinishedWorkOrdersTotalCost(){

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Finalizando as ordens de serviço
        workOrder1.finished();
        workOrder2.finished();
        workOrder3.finished();

        //Salvando as ordens de serviço em uma lista
        List<WorkOrder> workOrderFinishedList = new ArrayList<WorkOrder>();
        workOrderFinishedList.add(workOrder1);
        workOrderFinishedList.add(workOrder2);
        workOrderFinishedList.add(workOrder3);

        //Calculando o custo total das ordens de serviço
        double totalCost = 0;
        for (WorkOrder w: workOrderFinishedList){
            totalCost += w.getCost();
        }

        //Comparando os custos
        assertEquals(totalCost, DAO.getWorkOrder().getFinishedWorkOrdersTotalCost());


    }

    @Test
    void getFinishedWorkOrdersAverageTime(){

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Finalizando as ordens de serviço
        workOrder1.finished();
        workOrder2.finished();
        workOrder3.finished();

        //Salvando as ordens de serviço em uma lista
        List<WorkOrder> workOrderFinishedList = new ArrayList<WorkOrder>();
        workOrderFinishedList.add(workOrder1);
        workOrderFinishedList.add(workOrder2);
        workOrderFinishedList.add(workOrder3);

        //Calculando o tempo médio das ordens de serviço
        double avarageTime = 0;
        for (WorkOrder w: workOrderFinishedList){

            avarageTime += w.waitingTime();

        }
        avarageTime /= workOrderFinishedList.size();

        //Comparando os tempos médios
        assertEquals(avarageTime, DAO.getWorkOrder().getFinishedWorkOrdersAverageTime());

    }

    @Test
    void getFinishedWorkOrdersAverageRating(){

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Finalizando as ordens de serviço
        workOrder1.finished();
        workOrder2.finished();
        workOrder3.finished();

        //Avaliando as ordens de serviço com núemros de 0 a 5
        workOrder1.setSatisfaction(5);
        workOrder1.setSatisfaction(2);
        workOrder1.setSatisfaction(3);

        //Salvando as ordens de serviço em uma lista
        List<WorkOrder> workOrderFinishedList = new ArrayList<WorkOrder>();
        workOrderFinishedList.add(workOrder1);
        workOrderFinishedList.add(workOrder2);
        workOrderFinishedList.add(workOrder3);


        //Calculando a média das satisfações
        double avarageRating = 0;
        for (WorkOrder w: workOrderFinishedList){

            avarageRating += w.getSatisfaction();

        }
        avarageRating /= workOrderFinishedList.size();

        //Comparando a média das avaliações
        assertEquals(avarageRating, DAO.getWorkOrder().getFinishedWorkOrdersAverageRating());

    }

    @Test
    void getFinishedWorkOrdersUsedComponents(){

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);

        //Criando um serviço de montagem
        Building building02 =  new Building();

        //Adicionando componentes
        building02.addComponent(new OtherComponent(300,50,20,"RAM_16GB"));
        building02.addComponent(new ComputerComponent(300,50,20,"RAM_16GB","XXXXX"));

        //Adicionando o serviço de montagem na ordem de serviço
        workOrder1.addService(building02);

        //Finalizando ordem de serviço
        workOrder1.finished();

        //Avaliando as listas de componenstes usados
        assertEquals(building02.getUsedComponents(), DAO.getWorkOrder().getFinishedWorkOrdersUsedComponents());

    }

    @Test
    void update() {

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Alterando a descrição da ordem de serviço
        workOrder1.setDescription("++++++");

        //Atualizando os dados da ordem de serviço
        DAO.getWorkOrder().update(workOrder1);

        //Verificando se as ordens de serviço são iguais, ou seja, se foram atualizados
        assertEquals(workOrder1, DAO.getWorkOrder().FindById(workOrder1.getId()));
    }

    @Test
    void delete() {

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Recebendo os id's das ordens de serviço
        int workOrderId1 = workOrder1.getId();
        int workOrderId2 = workOrder2.getId();
        int workOrderId3 = workOrder3.getId();

        //Deletando as ordens de serviço do sistema
        DAO.getWorkOrder().delete(workOrder1.getId());
        DAO.getWorkOrder().delete(workOrder2.getId());
        DAO.getWorkOrder().delete(workOrder3.getId());

        //Verificando se o retorno após a busca é nulo
        assertNull(DAO.getWorkOrder().FindById(workOrderId1));
        assertNull(DAO.getWorkOrder().FindById(workOrderId2));
        assertNull(DAO.getWorkOrder().FindById(workOrderId3));


    }

    @Test
    void clearList(){

        //Salvando as ordens de serviço no sistema através do DAO
        DAO.getWorkOrder().create(workOrder1);
        DAO.getWorkOrder().create(workOrder2);
        DAO.getWorkOrder().create(workOrder3);

        //Limpando a lista das ordens de serviço
        DAO.getWorkOrder().clearList();

        //Verificando se o tamanho da lista das ordens de serviço do sistema é 0
        assertEquals(DAO.getWorkOrder().FindMany().size(), 0);

    }
}