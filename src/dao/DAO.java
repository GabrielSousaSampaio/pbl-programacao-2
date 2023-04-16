package dao;

import dao.cleaning.CleaningDAO;
import dao.cleaning.CleaningListImpl;
import dao.component.ComponentDAO;
import dao.component.ComponentListImpl;
import dao.customer.CustomerDAO;
import dao.customer.CustomerListImpl;
import dao.installation.InstallationDAO;
import dao.installation.InstallationListImpl;
import dao.technician.TechnicianDAO;
import dao.technician.TechnicianListImpl;
import dao.user.UserDAO;
import dao.user.UserListImpl;
import dao.workorder.WorkOrderDAO;
import dao.workorder.WorkOrderListImpl;

public class DAO {

    private static CustomerDAO customerDAO;

    private static TechnicianDAO technicianDAO;

    private static WorkOrderDAO workOrderDAO;

    private static ComponentDAO componentDAO;

    private static UserDAO userDAO;

    private static CleaningDAO  cleaningDAO;

    private static InstallationDAO installationDAO;

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

    public static ComponentDAO getComponent(){

        if(componentDAO == null) {
            componentDAO= new ComponentListImpl();
        }
        return componentDAO;
    }

    public static UserDAO getUser(){

        if(userDAO == null) {
            userDAO = new UserListImpl();
        }
        return userDAO;
    }

    public static CleaningDAO getCleaning(){

        if(cleaningDAO == null) {
            cleaningDAO  = new CleaningListImpl();
        }
        return cleaningDAO;

    }

    public static InstallationDAO getInstallation(){

        if(installationDAO == null) {
            installationDAO  = new InstallationListImpl();
        }
        return installationDAO;

    }
}