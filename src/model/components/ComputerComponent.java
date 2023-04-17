package model.components;

/**
 *
 * Classe criada para representar um componente de computador para o serviço de montagem
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class ComputerComponent extends Component {

    //Attributes
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
    public ComputerComponent(double price, double cost, int quantity, String name, String manufacturer){
        super(price, cost, quantity);
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
}