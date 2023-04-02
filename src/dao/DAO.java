package dao;

import dao.component.ComponentDAO;
import dao.customer.CustomerDAO;
import dao.customer.CustomerListImpl;
import dao.technician.TechnicianDAO;
import dao.technician.TechnicianListImpl;
import dao.workorder.WorkOrderDAO;
import dao.workorder.WorkOrderListImpl;

public class DAO {

    private static CustomerDAO customerDAO;

    private static TechnicianDAO technicianDAO;

    private static WorkOrderDAO workOrderDAO;

    private static ComponentDAO componentDAO;

    //Methods
    public static WorkOrderDAO getWorkOrder(){

        if(workOrderDAO == null) {
            workOrderDAO = new WorkOrderListImpl();
        }
        return workOrderDAO;
    }

    public static CustomerDAO getCustomer(){

        if(customerDAO == null) {
            customerDAO = new CustomerListImpl();
        }
        return customerDAO;
    }

    public static TechnicianDAO getTechnician(){

        if(technicianDAO == null) {
            technicianDAO = new TechnicianListImpl();
        }
        return technicianDAO;
    }

}
