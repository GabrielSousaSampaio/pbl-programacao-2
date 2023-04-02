package dao.workorder;

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

    //public WorkOrder FindByTechnician();

    //public WorkOrder FindByCustomer();

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
