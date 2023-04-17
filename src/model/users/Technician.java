package model.users;

import model.WorkOrder;

/**
 *
 * Classe criada para representação do técnico
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class Technician extends User{

    //Attributes
    private WorkOrder WorkingOn;

    //Constructor
    /**
     * Método cronstrutor do técnico
     * @param name O nome do técnico
     * @param email O endereço de e-mail do técnico
     * @param password A senha do técnico
     *
     */
    public Technician(String name, String email, String password) {
        super(name, email, password);
    }

    //Getters and Setters
    /**
     * Método criado para retonar a ordem de serviço em que o técnico trabalha no momento
     * @return A ordem de serviço que o técnico trabalha no momento ou nulo, caso não esteja
     * tabalhando em nenhuma
     */
    public WorkOrder getWorkingOn() {
        return WorkingOn;
    }

    /**
     * Método criado para alterar a ordem de serviço em que o técnico trabalha no momento
     * @param WorkingOn A ordem de serviço que o técnico trabalha no momento ou nulo, caso não esteja
     * tabalhando em nenhuma
     */
    public void setWorkingOn(WorkOrder WorkingOn) {
        this.WorkingOn = WorkingOn;
    }
}
