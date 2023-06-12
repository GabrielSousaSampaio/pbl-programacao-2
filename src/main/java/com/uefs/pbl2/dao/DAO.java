package com.uefs.pbl2.dao;

import com.uefs.pbl2.dao.administrator.AdministratorDAO;
import com.uefs.pbl2.dao.administrator.AdministratorFileImpl;
import com.uefs.pbl2.dao.cleaning.CleaningDAO;
import com.uefs.pbl2.dao.cleaning.CleaningFileImpl;
import com.uefs.pbl2.dao.component.ComponentDAO;
import com.uefs.pbl2.dao.component.ComponentFileImpl;
import com.uefs.pbl2.dao.customer.CustomerDAO;
import com.uefs.pbl2.dao.customer.CustomerFileImpl;
import com.uefs.pbl2.dao.installation.InstallationDAO;
import com.uefs.pbl2.dao.installation.InstallationFileImpl;
import com.uefs.pbl2.dao.recepcionist.RecepcionistDAO;
import com.uefs.pbl2.dao.recepcionist.RecepcionistFileImpl;
import com.uefs.pbl2.dao.technician.TechnicianDAO;
import com.uefs.pbl2.dao.technician.TechnicianFileImpl;
import com.uefs.pbl2.dao.workorder.WorkOrderDAO;
import com.uefs.pbl2.dao.workorder.WorkOrderFileImpl;

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
            workOrderDAO = new WorkOrderFileImpl();
        }
        return workOrderDAO;
    }

    /**
     * Método criado para acessar os objetos do tipo "Customer" armazenados no sistema
     */

    public static CustomerDAO getCustomer(){

        if(customerDAO == null) {
            customerDAO = new CustomerFileImpl();
        }
        return customerDAO;
    }

    /**
     * Método criado para acessar os objetos do tipo "Technician" armazenados no sistema
     */
    public static TechnicianDAO getTechnician(){

        if(technicianDAO == null) {
            technicianDAO = new TechnicianFileImpl();
        }
        return technicianDAO;
    }

    /**
     * Método criado para acessar os objetos do tipo "Component" armazenados no sistema
     */

    public static ComponentDAO getComponent(){

        if(componentDAO == null) {
            componentDAO= new ComponentFileImpl();
        }
        return componentDAO;
    }

    /**
     * Método criado para acessar os objetos do tipo "Cleaning" armazenados no sistema
     */

    public static CleaningDAO getCleaning(){

        if(cleaningDAO == null) {
            cleaningDAO  = new CleaningFileImpl();
        }
        return cleaningDAO;

    }

    /**
     * Método criado para acessar os objetos do tipo "Installation" armazenados no sistema
     */

    public static InstallationDAO getInstallation(){

        if(installationDAO == null) {
            installationDAO  = new InstallationFileImpl();
        }
        return installationDAO;

    }

    /**
     * Método criado para acessar os objetos do tipo "Recepcionist" armazenados no sistema
     */
    public static RecepcionistDAO getRecepcionist(){

        if(recepcionistDAO == null) {
            recepcionistDAO  = new RecepcionistFileImpl();
        }
        return recepcionistDAO;

    }

    /**
     * Método criado para acessar os objetos do tipo "Administrator" armazenados no sistema
     */
    public static AdministratorDAO getAdministrator(){

        if(administratorDAO == null) {
            administratorDAO   = new AdministratorFileImpl();
        }
        return administratorDAO ;

    }
}