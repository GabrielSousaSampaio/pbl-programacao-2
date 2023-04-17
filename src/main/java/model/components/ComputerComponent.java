package main.java.model.components;

/**
 *
 * Classe criada para representar um componente de computador para o serviço de montagem
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class ComputerComponent implements Component {

    //Attributes
    private double price;
    private double cost;
    private int quantity;
    private int id;
    private String name;
    private String manufacturer;

    //Constructor
    /**
     * Método cronstrutor do componente de computador
     * @param price O preço do componente de computador
     * @param cost O custo do componente de computador
     * @param quantity A quantidade de componentes de computador
     * @param name O nome do componente de compuador
     * @param manufacturer O nome do fabricante do componente de computador
     */
    public ComputerComponent(double price, double cost, int quantity, String name, String manufacturer) {
        this.price = price;
        this.cost = cost;
        this.quantity = quantity;
        this.name = name;
        this.manufacturer = manufacturer;
    }

    //Getters and Setters
    /**
     * Método criado para retonar o nome do componente de computador
     * @return O nome do componente de computador
     */
    public String getName() {
        return name;
    }

    /**
     * Método criado para alterar o nome do componente de computador
     * @param name O nome do componente de computador
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método criado para retonar o nome do fabricante do componente de computador
     * @return O nome do fabricante do componente de computador
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Método criado para alterar o nome do fabricante do componente de computador
     * @param manufacturer O nome do fabricante do componente de computador
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    /**
     * Método criado para retonar o preço do componente de computador
     * @return O preço do componente de computador
     */
    public double getPrice() {
        return price;
    }

    /**
     * Método criado para alterar o preço do componente de computador
     * @param price O preço do componente de computador
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Método criado para retonar o custo do componente de computador
     * @return O custo do componente de computador
     */
    public double getCost() {
        return cost;
    }

    /**
     * Método criado para alterar o custo do componente de computador
     * @param cost O custo do componente de computador
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Método criado para retonar a quantidade de componentes de computador
     * @return A quantidade de componentes de computador
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Método criado para alterar a quantidade de componentes de computador
     * @param quantity A quantidade de componentes de computador
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Método criado para retonar o id do componente de computador
     * @return O id do componente de computador
     */
    public int getId() {
        return id;
    }

    /**
     * Método criado para alterar o id do componente de computador
     * @param id O id do componente de computador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método criado para retonar uma cópia do componente de computador
     * @return Uma cópia do objeto componente de computador
     */
    public Component copy(){

        ComputerComponent newComponent = new ComputerComponent(this.getPrice(), this.getCost(), this.getQuantity(),
                this.getName(), this.getManufacturer());
        newComponent.setId(this.getId());

        return newComponent;
    }
}