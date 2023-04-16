package dao.workorder;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class WorkOrderListImpl implements WorkOrderDAO{

    private List<WorkOrder> workOrderList;
    private int nextID;

    public WorkOrderListImpl() {
        this.workOrderList = new ArrayList<>();
        this.nextID = 1;
    }

    @Override
    public WorkOrder create(WorkOrder workOrder) {
        workOrder.setId(nextID);
        this.nextID++;
        this.workOrderList.add(workOrder);
        return workOrder;
    }

    @Override
    public List<WorkOrder> FindMany() {
        return this.workOrderList;
    }

    @Override
    public WorkOrder FindById(int id) {
        for(WorkOrder wo: this.workOrderList){
            if(wo.getId() == id){
                return wo;
            }
        }
        return null;
    }

    public List<WorkOrder> FindByTechnicianId(int id){
        List<WorkOrder> workOrderTechinicianList = new ArrayList<>();
        for(WorkOrder wo: this.workOrderList){
            if(wo.getTechnicianId() == id){
                workOrderTechinicianList.add(wo);
            }
        }
        return workOrderTechinicianList;
    }

    public List<WorkOrder>  FindByCustomerId(int id){

        List<WorkOrder> workOrderTechinicianList = new ArrayList<WorkOrder>();

        for(WorkOrder wo: this.workOrderList){
            if(wo.getCustomerId()== id){
                workOrderTechinicianList.add(wo);
            }
        }
        return workOrderTechinicianList;
    }

    public List<WorkOrder> getFinishedWorkOrders(){
        List<WorkOrder> workOrderFinishedList = new ArrayList<WorkOrder>();
        for(WorkOrder wo: this.workOrderList){
            if(wo.isFinshed()){
                workOrderFinishedList.add(wo);
            }
        }
        return workOrderFinishedList;
    }

    public double getFinishedWorkOrdersTotalPrice(){
        double totalPrice = 0;
        for(WorkOrder wo: this.getFinishedWorkOrders()){
                totalPrice += wo.getPrice();
        }
        return totalPrice;
    }

    public double getFinishedWorkOrdersTotalCost(){
        double totalPrice = 0;
        for(WorkOrder wo: this.getFinishedWorkOrders()){
                totalPrice += wo.getCost();
        }
        return totalPrice;
    }

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
}
