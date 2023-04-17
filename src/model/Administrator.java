package model;

/**
 *
 * Classe criada para representação do administrador
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class Administrator extends User{

    //Constructor
    /**
     * Método cronstrutor do administrador
     * @param name O nome do adminstrador
     * @param email O endereço de e-mail do administrador
     * @param password A senha do administrador
     *
     */
    public Administrator(String name, String email, String password) {
        super(name, email, password);
    }


}
