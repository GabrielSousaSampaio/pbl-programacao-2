package com.uefs.pblprogramacao2.model.users;

import java.io.Serializable;

/**
 *
 * Interface criada para representação do usuário e apresentar os métodos referentes aos mesmos
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public interface User extends Serializable {

    /**
     * Método criado para retonar o id do usuário
     * @return O id do usuário
     */
    public int getId();

    /**
     * Método criado para alterar o id do usuário
     * @param id O id do usuário
     */
    public void setId(int id);

    /**
     * Método criado para retonar o nome do usuário
     * @return O nome do usuário
     */
    public String getName();

    /**
     * Método criado para alterar o nome do usuário
     * @param name O nome do usuário
     */
    public void setName(String name);

    /**
     * Método criado para retonar o endereço de e-mail do usuário
     * @return O endereço de e-mail do usuário
     */
    public String getEmail();

    /**
     * Método criado para alterar o endereço de e-mail do usuário
     * @param email O endereço de e-mail do usuário
     */
    public void setEmail(String email);

    /**
     * Método criado para retonar a senha do usuário
     * @return A sennha do usuário
     */
    public String getPassword();

    /**
     * Método criado para alterar a senha do usuário
     * @param password A sennha do usuário
     */
    public void setPassword(String password);
}
