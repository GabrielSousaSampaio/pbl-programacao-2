package dao;

import dao.administrator.AdministratorDAO;
import dao.administrator.AdministratorListImpl;
import dao.cleaning.CleaningDAO;
import dao.cleaning.CleaningListImpl;
import dao.component.ComponentDAO;
import dao.component.ComponentListImpl;
import dao.customer.CustomerDAO;
import dao.customer.CustomerListImpl;
import dao.installation.InstallationDAO;
import dao.installation.InstallationListImpl;
import dao.recepcionist.RecepcionistDAO;
import dao.recepcionist.RecepcionistListImpl;
import dao.technician.TechnicianDAO;
import dao.technician.TechnicianListImpl;
import dao.user.UserDAO;
import dao.user.UserListImpl;
import dao.workorder.WorkOrderDAO;
import dao.workorder.WorkOrderListImpl;


/**
 *
 * Classe DAO criada para poder ter acesso aos dados armazenados
 *
 * @author Gabriel Sousa Sampaio, Gabriel Baptista
 */

public class DAO {

    private static CustomerDAO customerDAO;

    private static TechnicianDAO technicianDAO;

    private static WorkOrderDAO workOrderDAO;

    private static ComponentDAO componentDAO;

    private static UserDAO userDAO;

    private static CleaningDAO  cleaningDAO;

    private static InstallationDAO installationDAO;

    private static RecepcionistDAO recepcionistDAO;

    private static AdministratorDAO administratorDAO;

    //Methods

    /**
     * Método criado para acessar os objetos do tipo "WorkOrder" armazenados no sistema
     */

    public static WorkOrderDAO getWorkOrder(){

        if(workOrderDAO == null) {
            workOrderDAO = new WorkOrderListImpl();
        }
        return workOrderDAO;
    }

    /**
     * Método criado para acessar os objetos do tipo "Customer" armazenados no sistema
     */

    public static CustomerDAO getCustomer(){

        if(customerDAO == null) {
            customerDAO = new CustomerListImpl();
        }
        return customerDAO;
    }

    /**
     * Método criado para acessar os objetos do tipo "Technician" armazenados no sistema
     */
    public static TechnicianDAO getTechnician(){

        if(technicianDAO == null) {
            technicianDAO = new TechnicianListImpl();
        }
        return technicianDAO;
    }

    /**
     * Método criado para acessar os objetos do tipo "Component" armazenados no sistema
     */

    public static ComponentDAO getComponent(){

        if(componentDAO == null) {
            componentDAO= new ComponentListImpl();
        }
        return componentDAO;
    }

    /**
     * Método criado para acessar os objetos do tipo "User" armazenados no sistema
     */

    public static UserDAO getUser(){

        if(userDAO == null) {
            userDAO = new UserListImpl();
        }
        return userDAO;
    }

    /**
     * Método criado para acessar os objetos do tipo "Cleaning" armazenados no sistema
     */

    public static CleaningDAO getCleaning(){

        if(cleaningDAO == null) {
            cleaningDAO  = new CleaningListImpl();
        }
        return cleaningDAO;

    }

    /**
     * Método criado para acessar os objetos do tipo "Installation" armazenados no sistema
     */

    public static InstallationDAO getInstallation(){

        if(installationDAO == null) {
            installationDAO  = new InstallationListImpl();
        }
        return installationDAO;

    }

    /**
     * Método criado para acessar os objetos do tipo "Recepcionist" armazenados no sistema
     */
    public static RecepcionistDAO getRecepcionist(){

        if(recepcionistDAO == null) {
            recepcionistDAO  = new RecepcionistListImpl();
        }
        return recepcionistDAO;

    }

    /**
     * Método criado para acessar os objetos do tipo "Administrator" armazenados no sistema
     */
    public static AdministratorDAO getAdministrator(){

        if(administratorDAO == null) {
            administratorDAO   = new AdministratorListImpl();
        }
        return administratorDAO ;

    }
}