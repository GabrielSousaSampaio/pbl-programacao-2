package model;

public class Technician extends User{

    //Attributes

    private WorkOrder WorkingOn;

    //Constructor

    public Technician(int id, String name, String email) {
        super(id, name, email);
    }


    //Getters and Setters

    public WorkOrder getWorkingOn() {
        return WorkingOn;
    }

    public void setWorkingOn(WorkOrder WorkingOn) {
        this.WorkingOn = WorkingOn;
    }

    //Methods

    public void updateOrderStatus(String status){
        this.WorkingOn.setStatus(status);
    }
    public void updateOrder(WorkOrder workOrder){

    }
}
