package main.java.dao.workorder;

import main.java.dao.FileHandling;
import main.java.model.WorkOrder;
import main.java.model.components.Component;
import main.java.model.services.Building;
import main.java.model.services.Service;

import java.util.ArrayList;
import java.util.List;

public class WorkOrderFileImpl implements WorkOrderDAO{

    private List<WorkOrder> workOrderList;
    int nextId;

    //Constructor

    /**
     * Método cronstrutor que inicializa o array para armazenar as ordens de serviço e inicia o id com o valor 1
     *
     */

    public WorkOrderFileImpl() {
        workOrderList = FileHandling.readFile("src\\filesSaves\\workOrders.dat");

        if(workOrderList.size() == 0) {
            this.nextId = 1;
        }else{

            this.nextId = (workOrderList.get(workOrderList.size() - 1).getId()) + 1;
        }
    }

    @Override
    public WorkOrder create(WorkOrder workOrder) {

        workOrder.setId(nextId);
        this.nextId++;
        this.workOrderList.add(workOrder);

        FileHandling.saveInFile(this.workOrderList,"src\\filesSaves\\workOrders.dat");
        return workOrder;


    }

    /**
     * Método criado para adquirir todas as ordens de serviço cadastrados na lista do sistema
     * @return A lista com todas as ordens de serviços cadastrados
     */

    @Override
    public List<WorkOrder> FindMany() {
        return this.workOrderList;
    }

    /**
     * Método criado para econtrar uma ordem de serviço pelo seu id
     * @param id O id da ordem de serviço
     * @return A ordem de serviço procurada ou nulo (caso ele não esteja cadastrado)
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
            if(wo.getTechnicianId() == id){
                workOrderTechinicianList.add(wo);
            }
        }
        return workOrderTechinicianList;
    }


    @Override
    public List<WorkOrder> FindByCustomerId(int id){

        List<WorkOrder> workOrderCustomerList = new ArrayList<WorkOrder>();

        for(WorkOrder wo: this.workOrderList){
            if(wo.getCustomerId()== id){
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
                FileHandling.saveInFile(this.workOrderList,"src\\filesSaves\\workOrders.dat");
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
                FileHandling.saveInFile(this.workOrderList,"src\\filesSaves\\workOrders.dat");
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
        FileHandling.saveInFile(this.workOrderList,"src\\filesSaves\\workOrders.dat");
    }
}
