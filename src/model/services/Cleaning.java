package model.services;

/**
 *
 * Classe criada para representar um serviço de limpeza
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class Cleaning extends Service {

    //Attributes
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
     * Método criado para alterar o id do serviço de limpeza
     * @param cleaningName O nome do serviço de limpeza
     */
    public void setCleaningName(String cleaningName) {
        this.cleaningName = cleaningName;
    }
}