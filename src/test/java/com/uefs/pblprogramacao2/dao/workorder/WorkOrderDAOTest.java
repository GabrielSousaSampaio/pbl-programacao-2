package com.uefs.pblprogramacao2.dao.workorder;

import com.uefs.pblprogramacao2.dao.DAO;
import com.uefs.pblprogramacao2.model.*;
import com.uefs.pblprogramacao2.model.components.ComputerComponent;
import com.uefs.pblprogramacao2.model.components.OtherComponent;
import com.uefs.pblprogramacao2.model.services.Building;
import com.uefs.pblprogramacao2.model.services.Cleaning;
import com.uefs.pblprogramacao2.model.services.Installation;
import com.uefs.pblprogramacao2.model.users.Technician;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class WorkOrderDAOTest {

    //Atributos
    private Customer client1;
    private Customer client2;
    private Customer client3;
    private WorkOrder workOrder1;
    private WorkOrder workOrder2;
    private WorkOrder workOrder3;
    Technician technician1;
    Technician technician2;
    WorkOrder newWorkOrder01;
    WorkOrder newWorkOrder02;
    WorkOrder newWorkOrder03;

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

       //Salvando as ordens de serviço no sistema através do DAO
       newWorkOrder01 = DAO.getWorkOrder().create(workOrder1);
       newWorkOrder02 = DAO.getWorkOrder().create(workOrder2);
       newWorkOrder03 = DAO.getWorkOrder().create(workOrder3);
    }

    @AfterEach
    void tearDown() {
       //Limpando a lista após os testes
       DAO.getWorkOrder().clearList();
    }

    @Test
    void create() {
        //Verificando se as ordens de serviço salvas no sistema e as ordens de serviço enviadas são iguais
        assertEquals(workOrder1,newWorkOrder01);
        assertEquals(workOrder2,newWorkOrder02);
        assertEquals(workOrder3,newWorkOrder03);
    }

    @Test
    void findMany() {
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
        //Verificando se as ordens de serviço encontradas através do id e as ordens de serviço enviadas são iguais
        assertEquals(workOrder1,DAO.getWorkOrder().FindById(workOrder1.getId()));
    }

    @Test
    void findByTechnicianId(){
        //Criando tecnico
        Technician technician1 =  new Technician("Pedro","Perdro@email.com", "12345");
        DAO.getTechnician().create(technician1);
        technician1.setId(1);

        //Salvando as ordens de serviço em uma lista
        List<WorkOrder> workOrderList = new ArrayList<WorkOrder>();
        workOrderList.add(workOrder1);
        workOrderList.add(workOrder2);
        workOrderList.add(workOrder3);

        //Settando as ordens de serviço com o id do tecnico
        workOrder1.setTechnician(technician1);
        workOrder2.setTechnician(technician1);
        workOrder3.setTechnician(technician1);

        //Verificando se as listas são iguais
        assertEquals(workOrderList, DAO.getWorkOrder().FindByTechnicianId(workOrder1.getTechnician().getId()));

        //Limpando arquivo
        DAO.getTechnician().clearList();
    }

    @Test
    void findByCustomerId(){
        //Criando cliente
        Customer customer1 =  new Customer("Gabriel","Gabriel@email.com", "Rua x", "(99)9999-9999");
        DAO.getCustomer().create(customer1);
        customer1.setId(1);

        //Salvando as ordens de serviço em uma lista
        List<WorkOrder> workOrderList = new ArrayList<WorkOrder>();
        workOrderList.add(workOrder1);
        workOrderList.add(workOrder2);
        workOrderList.add(workOrder3);

        //Settando as ordens de serviço com o id do cliente
        workOrder1.setCustomer(customer1);
        workOrder2.setCustomer(customer1);
        workOrder3.setCustomer(customer1);

        //Verificando se as listas são iguais
        assertEquals(workOrderList, DAO.getWorkOrder().FindByCustomerId(workOrder1.getCustomer().getId()));

        //Limpando arquivo
        DAO.getCustomer().clearList();
    }

    @Test
    void getFinishedWorkOrders(){
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

        //Salvando ordens de serviço
        DAO.getTechnician().create(technician1);
        DAO.getTechnician().create(technician2);

        workOrder1.setTechnician(technician1);
        workOrder2.setTechnician(technician2);

        //Finalizando ordem de serviço
        workOrder2.finished();

        //Salvando as ordens de serviço em uma lista
        List<WorkOrder> workOrderOpenedAndAllocatedList = new ArrayList<WorkOrder>();
        workOrderOpenedAndAllocatedList.add(workOrder1);

        //Comparando as listas
        assertEquals(workOrderOpenedAndAllocatedList, DAO.getWorkOrder().getOpenedAndAllocatedWorkOrders());

        DAO.getTechnician().clearList();
    }

    @Test
    void getFirstOpenWorkOrder(){
        //Finalizando a primeira ordem de serviço
        workOrder1.finished();

        //Comparando as ordens de serviço
        assertEquals(workOrder2, DAO.getWorkOrder().getFirstOpenWorkOrder());
    }

    @Test
    void getFinishedWorkOrdersTotalPrice(){
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
        //Alterando a descrição da ordem de serviço
        workOrder1.setDescription("++++++");

        //Atualizando os dados da ordem de serviço
        DAO.getWorkOrder().update(workOrder1);

        //Verificando se as ordens de serviço são iguais, ou seja, se foram atualizados
        assertEquals(workOrder1, DAO.getWorkOrder().FindById(workOrder1.getId()));
    }

    @Test
    void delete() {
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
        //Limpando a lista das ordens de serviço
        DAO.getWorkOrder().clearList();

        //Verificando se o tamanho da lista das ordens de serviço do sistema é 0
        assertEquals(DAO.getWorkOrder().FindMany().size(), 0);
    }
}