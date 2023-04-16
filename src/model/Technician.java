package model;

public class Technician extends User{

    //Attributes
    private WorkOrder WorkingOn;

    //Constructor
    public Technician(String name, String email) {
        super(name, email);
    }

    //Getters and Setters
    public WorkOrder getWorkingOn() {
        return WorkingOn;
    }

    public void setWorkingOn(WorkOrder WorkingOn) {
        this.WorkingOn = WorkingOn;
    }
}
