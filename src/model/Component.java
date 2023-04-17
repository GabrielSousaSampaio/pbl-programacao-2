package model;

/**
 *
 * Classe criada para representar um componente para o serviço de montagem
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class Component {

    //Attributes
    private double price;
    private double cost;
    private int quantity;
    private int id;

    //Constructor
    /**
     * Método cronstrutor do componente
     * @param price O preço do componente
     * @param cost O custo do componente
     * @param quantity A quantidade de componentes
     */
    public Component(double price, double cost, int quantity){
        this.price = price;
        this.cost = cost;
        this.quantity = quantity;
    }

    //Getters and Setters
    /**
     * Método criado para retonar o preço do componente
     * @return O preço do componente
     */
    public double getPrice() {
        return price;
    }

    /**
     * Método criado para alterar o preço do componente
     * @param price O preço do componente
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Método criado para retonar o custo do componente
     * @return O custo do componente
     */
    public double getCost() {
        return cost;
    }

    /**
     * Método criado para alterar o custo do componente
     * @param cost O custo do componente
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Método criado para retonar a quantidade de componentes
     * @return A quantidade de componentes
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Método criado para alterar a quantidade de componentes
     * @param quantity A quantidade de componentes
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Método criado para retonar o id do componente
     * @return O id do componente
     */
    public int getId() {
        return id;
    }

    /**
     * Método criado para alterar o id do componente
     * @param id O id do componente
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método criado para retonar uma cópia do componente
     * @return Um novo objeto componente
     */
    public Component copy(){

        Component newComponent = new Component(this.getPrice(), this.getCost(), this.getQuantity());
        newComponent.setId(this.getId());

        return newComponent;
    }
}