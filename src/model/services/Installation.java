package model.services;

/**
 *
 * Classe criada para representar um serviço de instalação
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class Installation extends Service {

    //Attributes
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
     * Método criado para retonar o id do serviço de instalação
     * @param id O id do serviço de instalação
     */
    public void setId(int id) {
        this.id = id;
    }
}