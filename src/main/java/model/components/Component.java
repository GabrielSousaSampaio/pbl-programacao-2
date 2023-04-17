package main.java.model.components;

/**
 *
 * Interface criada para representar e apresentar os métodos de um componente para o serviço de montagem
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public interface Component {


    //Getters and Setters
    /**
     * Método criado para retonar o preço do componente
     * @return O preço do componente
     */
    public double getPrice();

    /**
     * Método criado para alterar o preço do componente
     * @param price O preço do componente
     */
    public void setPrice(double price);


    /**
     * Método criado para retonar o custo do componente
     * @return O custo do componente
     */
    public double getCost();

    /**
     * Método criado para alterar o custo do componente
     * @param cost O custo do componente
     */
    public void setCost(double cost);

    /**
     * Método criado para retonar a quantidade de componentes
     * @return A quantidade de componentes
     */
    public int getQuantity();

    /**
     * Método criado para alterar a quantidade de componentes
     * @param quantity A quantidade de componentes
     */
    public void setQuantity(int quantity);

    /**
     * Método criado para retonar o id do componente
     * @return O id do componente
     */
    public int getId();

    /**
     * Método criado para alterar o id do componente
     * @param id O id do componente
     */
    public void setId(int id);

    /**
     * Método criado para retonar uma cópia do componente
     * @return Uma cópia do objeto componente
     */
    public Component copy();
}