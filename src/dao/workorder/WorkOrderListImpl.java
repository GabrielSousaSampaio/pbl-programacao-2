package dao.workorder;

import model.Technician;
import model.WorkOrder;
import java.util.ArrayList;
import java.util.List;

public class WorkOrderListImpl implements WorkOrderDAO{

    private List<WorkOrder> WorkOrderList;

    private int nextID;

    public WorkOrderListImpl() {
        this.WorkOrderList = new ArrayList<WorkOrder>();
        this.nextID = 0;

    }

    @Override
    public WorkOrder create(WorkOrder workOrder) {

        workOrder.setId(nextID);
        this.nextID++;

        this.WorkOrderList.add(workOrder);

        return workOrder;
    }

    @Override
    public List<WorkOrder> FindMany() {
        return this.WorkOrderList;
    }

    @Override
    public WorkOrder FindById(int id) {

        for(WorkOrder wo: this.WorkOrderList){
            if(wo.getId() == id){
                return wo;
            }
        }

        return null;
    }

    public List<WorkOrder> FindByTechnicianId(int id){

        List<WorkOrder> workOrderTechinicianList = new ArrayList<WorkOrder>();

        for(WorkOrder wo: this.WorkOrderList){
            if(wo.getTechnician().getId() == id){

                workOrderTechinicianList.add(wo);

            }
        }

        return workOrderTechinicianList;

    };

    public List<WorkOrder>  FindByCustomerId(int id){

        List<WorkOrder> workOrderTechinicianList = new ArrayList<WorkOrder>();

        for(WorkOrder wo: this.WorkOrderList){
            if(wo.getCustomer().getId() == id){
                workOrderTechinicianList.add(wo);
            }
        }

        return workOrderTechinicianList;


    };

    public List<WorkOrder> getFinishedWorkOrders(){

        List<WorkOrder> workOrderFinishedList = new ArrayList<WorkOrder>();

        for(WorkOrder wo: this.WorkOrderList){
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

    //public double getFinishedWorkOrdersAverageTime()

    //public int getFinishedWorkOrdersAverageRating()

    //public







    @Override
    public void update(WorkOrder workOrder) {

        int indexOF;

        for(WorkOrder wo: this.WorkOrderList){
            if(wo.getId() == workOrder.getId()){
                indexOF = this.WorkOrderList.indexOf(wo);
                this.WorkOrderList.set(indexOF, workOrder);
                return;
            }
        }

    }

    @Override
    public void delete(int id) {

        int indexRemove;
        for(WorkOrder wo: this.WorkOrderList){
            if(wo.getId() == id){
                indexRemove = this.WorkOrderList.indexOf(wo);
                this.WorkOrderList.remove(indexRemove);
                return;
            }
        }

    }
}
