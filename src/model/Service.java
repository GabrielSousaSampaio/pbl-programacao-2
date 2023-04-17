package model;

/**
 *
 * Classe abstrata criada para representação da generalização dos serviços
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public abstract class Service {

    //Attributes
    private double price;
    private double cost;

    //Getters and Setters
    /**
     * Método criado para retonar o preço do serviço
     * @return O preço do serviço
     */
    public double getPrice() {
        return price;
    }

    /**
     * Método criado para alterar o preço do serviço
     * @param price  O preço do serviço
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Método criado para retonar o custo do serviço
     * @return O custo do serviço
     */
    public double getCost() {
        return cost;
    }

    /**
     * Método criado para alterar o custo do serviço
     * @param cost O custo do serviço
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
}