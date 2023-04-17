package model;

/**
 *
 * Classe criada para representar outros componentes para o serviço de montagem
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class OtherComponent extends Component{

    //Attributes
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
        super(price, cost, quantity);
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
}
