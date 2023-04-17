package model;

/**
 *
 * Classe criada para representação do recepcionista
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class Recepcionist extends User{

    //Constructor
    /**
     * Método cronstrutor do recepcionista
     * @param name O nome do recepcionista
     * @param email O endereço de e-mail do recepcionista
     * @param password A senha do recepcionista
     */
    public Recepcionist(String name, String email, String password) {
        super(name, email, password);
    }


}
