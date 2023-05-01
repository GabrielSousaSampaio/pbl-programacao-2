package main.java.model.services;

import java.io.Serializable;

/**
 *
 * Interface criada para apresentar os métodos e representar a generalização dos serviços
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public interface Service extends Serializable {


    /**
     * Método criado para retonar o preço do serviço
     * @return O preço do serviço
     */
    public double getPrice();

    /**
     * Método criado para retonar o custo do serviço
     * @return O custo do serviço
     */
    public double getCost();

}