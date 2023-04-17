package model.services;

/**
 *
 * Classe criada para representar um serviço de limpeza
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class Cleaning implements Service {

    //Attributes
    private double price;
    private double cost;
    private int id;
    private String cleaningName;

    //Constructor
    /**
     * Método cronstrutor do serviço de limpeza
     * @param price O preço do serviço de limpeza
     * @param cost O custo do serviço de limpeza
     * @param cleaningName O nome do serviço de limpeza
     */
    public Cleaning(double price, double cost, String cleaningName){
        this.setPrice(price);
        this.setCost(cost);
        this.cleaningName = cleaningName;
    }


    //Getters and Setters

    /**
     * Método criado para retonar o id do serviço de limpeza
     * @return O id do serviço de limpeza
     */
    public int getId() {
        return id;
    }

    /**
     * Método criado para alterar o id do serviço de limpeza
     * @param id O id do serviço de limpeza
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método criado para retonar o nome do serviço de limpeza
     * @return O nome do serviço de limpeza
     */
    public String getCleaningName() {
        return cleaningName;
    }

    /**
     * Método criado para alterar o nome do serviço de limpeza
     * @param cleaningName O nome do serviço de limpeza
     */
    public void setCleaningName(String cleaningName) {
        this.cleaningName = cleaningName;
    }


    /**
     * Método criado para retonar o preço do serviço de limpeza
     * @return O preço do serviço de limpeza
     */
    public double getPrice() {
        return price;
    }

    /**
     * Método criado para alterar o preço do serviço de limpeza
     * @param price  O preço do serviço de limpeza
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Método criado para retonar o custo do serviço de limpeza
     * @return o custo do serviço de limpeza
     */
    public double getCost() {
        return cost;
    }

    /**
     * Método criado para alterar o custo do serviço de limpeza
     * @param cost O custo do serviço de limpeza
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
}