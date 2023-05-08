package main.java.dao.workorder;

import main.java.model.*;
import main.java.model.components.Component;
import main.java.model.services.Building;
import main.java.model.services.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Classe criada a partir da implementação da interface "WorkOrderDAO" para a manipulação das ordens de serviço
 * armazenadas no sistema através de listas.
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class WorkOrderListImpl implements WorkOrderDAO{

    private List<WorkOrder> workOrderList;
    private int nextId;

    //Constructor

    /**
     * Método cronstrutor que inicializa o array para armazenar as ordens de serviço e inicia o id com o valor 1
     *
     */

    public WorkOrderListImpl() {
        this.workOrderList = new ArrayList<>();
        this.nextId = 1;
    }

    //Methods

    /**
     * Método criado para a adição de uma ordem de serviço na lista do sistema
     * @param workOrder A ordem de serviço que deseja inserir na lista do sistema
     * @return A ordem de serviço enviada
     */

    @Override
    public WorkOrder create(WorkOrder workOrder) {
        workOrder.setId(nextId);
        this.nextId++;
        this.workOrderList.add(workOrder);
        return workOrder;
    }


    /**
     * Método criado para adquirir todas as ordens de serviço cadastradas na lista do sistema
     * @return A lista com todas as ordens de serviços cadastradas
     */

    @Override
    public List<WorkOrder> FindMany() {
        return this.workOrderList;
    }

    /**
     * Método criado para econtrar uma ordem de serviço pelo seu id
     * @param id O id da ordem de serviço
     * @return A ordem de serviço procurada ou nulo (caso ela não esteja cadastrada)
     */
    @Override
    public WorkOrder FindById(int id) {
        for(WorkOrder wo: this.workOrderList){
            if(wo.getId() == id){
                return wo;
            }
        }
        return null;
    }


    @Override
    public List<WorkOrder> FindByTechnicianId(int id){
        List<WorkOrder> workOrderTechinicianList = new ArrayList<>();
        for(WorkOrder wo: this.workOrderList){
            if(wo.getTechnician().getId() == id){
                workOrderTechinicianList.add(wo);
            }
        }
        return workOrderTechinicianList;
    }


    @Override
    public List<WorkOrder> FindByCustomerId(int id){

        List<WorkOrder> workOrderCustomerList = new ArrayList<WorkOrder>();

        for(WorkOrder wo: this.workOrderList){
            if(wo.getCustomer().getId() == id){
                workOrderCustomerList.add(wo);
            }
        }
        return workOrderCustomerList;
    }

    @Override
    public List<WorkOrder> getFinishedWorkOrders(){
        List<WorkOrder> workOrderFinishedList = new ArrayList<WorkOrder>();
        for(WorkOrder wo: this.workOrderList){
            if(wo.isFinshed()){
                workOrderFinishedList.add(wo);
            }
        }
        return workOrderFinishedList;
    }

    @Override
    public List<WorkOrder> getCanceledWorkOrders(){
        List<WorkOrder> workOrderCanceledList = new ArrayList<WorkOrder>();
        for(WorkOrder wo: this.workOrderList){
            if(wo.isCanceled()){
                workOrderCanceledList.add(wo);
            }
        }
        return workOrderCanceledList;

    }

    @Override
    public List<WorkOrder> getOpenedWorkOrders(){
        List<WorkOrder> workOrderOpenedList = new ArrayList<WorkOrder>();
        for(WorkOrder wo: this.workOrderList){
            if(wo.isOngoing()){
                workOrderOpenedList.add(wo);
            }
        }
        return workOrderOpenedList;
    }

    @Override
    public List<WorkOrder> getOpenedAndAllocatedWorkOrders() {
        List<WorkOrder> openedAndAllocatedWorkOrdersList = new ArrayList<>();
        for (WorkOrder wo : this.getOpenedWorkOrders()) {
            if (wo.getTechnician() != null) {
                openedAndAllocatedWorkOrdersList.add(wo);
            }
        }
        return openedAndAllocatedWorkOrdersList;
    }

    @Override
    public WorkOrder getFirstOpenWorkOrder(){

        return this.getOpenedWorkOrders().get(0);
    }

    @Override
    public double getFinishedWorkOrdersTotalPrice(){
        double totalPrice = 0;
        for(WorkOrder wo: this.getFinishedWorkOrders()){
                totalPrice += wo.getPrice();
        }
        return totalPrice;
    }

    @Override
    public double getFinishedWorkOrdersTotalCost(){
        double totalPrice = 0;
        for(WorkOrder wo: this.getFinishedWorkOrders()){
                totalPrice += wo.getCost();
        }
        return totalPrice;
    }

    @Override
    public double getFinishedWorkOrdersAverageTime(){
        double avarageTime = 0;
        for(WorkOrder wo: this.getFinishedWorkOrders()){
            avarageTime += wo.waitingTime();
        }
        if(this.getFinishedWorkOrders().size()!= 0){
            avarageTime /= (this.getFinishedWorkOrders()).size();
        }
        return avarageTime;
    }


    @Override
    public double getFinishedWorkOrdersAverageRating(){
        double avarageRating = 0;
        for(WorkOrder wo: this.getFinishedWorkOrders()){
            avarageRating += wo.getSatisfaction();
        }
        if(this.getFinishedWorkOrders().size()!= 0){
            avarageRating /= (this.getFinishedWorkOrders()).size();
        }
        return avarageRating;
    }


    @Override
    public List<Component> getFinishedWorkOrdersUsedComponents(){
        List<Component> usedComponentList = new ArrayList<>();
        for(WorkOrder wo: this.getFinishedWorkOrders())
            for (Service s : wo.getServicelist()) {
                if (s.getClass().equals(Building.class)) {
                    for (Component c : ((Building) s).getUsedComponents()) {
                        usedComponentList.add(c);
                    }
                }
            }
        return usedComponentList;
    }

    /**
     * Método criado para atuallizar os dados de uma ordem de serviço previamente cadastrada
     * @param workOrder A ordem de serviço que deseja atuaizar os dados
     */
    @Override
    public void update(WorkOrder workOrder) {
        int indexOF;
        for(WorkOrder wo: this.workOrderList){
            if(wo.getId() == workOrder.getId()){
                indexOF = this.workOrderList.indexOf(wo);
                this.workOrderList.set(indexOF, workOrder);
                return;
            }
        }
    }

    /**
     * Método criado para deletar uma ordem de serviço da lista do sistema
     * @param id O id da ordem de serviço
     */
    @Override
    public void delete(int id) {
        int indexRemove;
        for(WorkOrder wo: this.workOrderList){
            if(wo.getId() == id){
                indexRemove = this.workOrderList.indexOf(wo);
                this.workOrderList.remove(indexRemove);
                return;
            }
        }
    }

    /**
     * Método criado para limpar completamente a lista de ordens de serviço
     */
    @Override
    public void clearList(){

        this.workOrderList.clear();
    }

}
