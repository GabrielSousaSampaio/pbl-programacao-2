package com.uefs.pblprogramacao2.model.components;

/**
 *
 * Classe criada para representar outros componentes para o serviço de montagem
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class OtherComponent implements Component{

    //Attributes
    private double price;
    private double cost;
    private int quantity;
    private int id;
    private String description;

    //Constructor
    /**
     * Método cronstrutor do outro componente
     * @param price O preço de outro componente
     * @param cost O custo de outro componente
     * @param quantity A quantidade de outros componentes
     * @param description A descrição sobre o outro componente
     */
    public OtherComponent(double price, double cost, int quantity, String description) {
        this.price = price;
        this.cost = cost;
        this.quantity = quantity;
        this.description = description;
    }

    //Getters and Setters
    /**
     * Método criado para retonar a descrição do outro componente
     * @return A descrição do outro componente
     */
    public String getDescription() {
        return description;
    }

    /**
     * Método criado para alterar a descrição do outro componente
     * @param description A descrição do outro componente
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Método criado para retonar o preço do outro componente
     * @return O preço do outro componente
     */
    public double getPrice() {
        return price;
    }

    /**
     * Método criado para alterar o preço do outro componente
     * @param price O preço do outro componente
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Método criado para retonar o custo do outro componente
     * @return O custo do outro componente
     */
    public double getCost() {
        return cost;
    }

    /**
     * Método criado para alterar o custo do outro componente
     * @param cost O custo do outro componente
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Método criado para retonar a quantidade de outros componentes
     * @return A quantidade de outros componentes
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Método criado para alterar a quantidade de outros componentes
     * @param quantity A quantidade de outros componentes
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Método criado para retonar o id do outro componente
     * @return O id do outro componente
     */
    public int getId() {
        return id;
    }

    /**
     * Método criado para alterar o id do outro componente
     * @param id O id do outro componente
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Método criado para retonar uma cópia do "outro componente"
     * @return Um novo objeto do "outro componente"
     */
    public Component copy(){

        OtherComponent newComponent = new OtherComponent(this.getPrice(), this.getCost(), this.getQuantity(),
                this.getDescription());
        newComponent.setId(this.getId());

        return newComponent;
    }
}
