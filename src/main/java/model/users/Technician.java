package main.java.model.users;

import main.java.model.WorkOrder;

/**
 *
 * Classe criada para representação do técnico
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class Technician implements User{

    //Attributes
    private int id;
    private String name;
    private String email;
    private String password;
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
        this.name = name;
        this.email = email;
        this.password = password;
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

    //Getters and Setters
    /**
     * Método criado para retonar o id do técnico
     * @return O id do técnico
     */
    public int getId() {
        return id;
    }

    /**
     * Método criado para alterar o id do técnico
     * @param id O id do técnico
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método criado para retonar o nome do técnico
     * @return O nome do técnico
     */
    public String getName() {
        return name;
    }

    /**
     * Método criado para alterar o nome do técnico
     * @param name O nome do técnico
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método criado para retonar o endereço de e-mail do técnico
     * @return O endereço de e-mail do técnico
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método criado para alterar o endereço de e-mail do técnico
     * @param email O endereço de e-mail do técnico
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método criado para retonar a senha do técnico
     * @return A senha do técnico
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método criado para alterar a senha do técnico
     * @param password A senha do técnico
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
