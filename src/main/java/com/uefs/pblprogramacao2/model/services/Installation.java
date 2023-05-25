package com.uefs.pblprogramacao2.model.services;

/**
 *
 * Classe criada para representar um serviço de instalação
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class Installation implements Service {

    //Attributes
    private double price;
    private double cost;
    private int id;
    private String installationName;

    //Constructor
    /**
     * Método cronstrutor do serviço de instalação
     */
    public Installation (double price, double cost,String installationName){
        this.setPrice(price);
        this.setCost(cost);
        this.installationName = installationName;
    }

    //Getters and Setters
    /**
     * Método criado para retonar o nome do serviço de instalação
     * @return O nome do serviço de instalação
     */
    public String getInstallationName() {
        return installationName;
    }

    /**
     * Método criado para alterar o nome do serviço de instalação
     * @param installationName O nome do serviço de instalação
     */
    public void setInstallationName(String installationName) {
        this.installationName = installationName;
    }

    /**
     * Método criado para retonar o id do serviço de instalação
     * @return O id do serviço de instalação
     */
    public int getId() {
        return id;
    }

    /**
     * Método criado para alterar o id do serviço de instalação
     * @param id O id do serviço de instalação
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método criado para retonar o preço do serviço de instalação
     * @return O preço do serviço de instalação
     */
    public double getPrice() {
        return price;
    }

    /**
     * Método criado para alterar o preço do serviço de instalação
     * @param price  O preço do serviço de instalação
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Método criado para retonar o custo do serviço de instalação
     * @return o custo do serviço de instalação
     */
    public double getCost() {
        return cost;
    }

    /**
     * Método criado para alterar o custo do serviço de instalação
     * @param cost O custo do serviço de instalação
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
}