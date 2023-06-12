package com.uefs.pbl2.model.users;

/**
 *
 * Classe criada para representação do recepcionista
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class Recepcionist implements User {

    //Attributes
    private int id;
    private String name;
    private String email;
    private String password;

    //Constructor
    /**
     * Método cronstrutor do recepcionista
     * @param name O nome do recepcionista
     * @param email O endereço de e-mail do recepcionista
     * @param password A senha do recepcionista
     */
    public Recepcionist(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    //Getters and Setters
    /**
     * Método criado para retonar o id do recepcionista
     * @return O id do recepcionista
     */
    public int getId() {
        return id;
    }

    /**
     * Método criado para alterar o id do recepcionista
     * @param id O id do recepcionista
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método criado para retonar o nome do recepcionista
     * @return O nome do recepcionista
     */
    public String getName() {
        return name;
    }

    /**
     * Método criado para alterar o nome do recepcionista
     * @param name O nome do recepcionista
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método criado para retonar o endereço de e-mail do recepcionista
     * @return O endereço de e-mail do recepcionista
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método criado para alterar o endereço de e-mail do recepcionista
     * @param email O endereço de e-mail do recepcionista
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método criado para retonar a senha do recepcionista
     * @return A senha do recepcionista
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método criado para alterar a senha do recepcionista
     * @param password A senha do recepcionista
     */
    public void setPassword(String password) {
        this.password = password;
    }


}
