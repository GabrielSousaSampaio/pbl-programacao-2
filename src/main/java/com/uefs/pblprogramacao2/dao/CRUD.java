package com.uefs.pblprogramacao2.dao;

import java.util.List;

/**
 * Interface criada para apresentar os métodos padrões para acesso e manipulação das implementações e aplicações DAO
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */
public interface CRUD<G> {

    /**
     * Método criado para a adição de um objeto na lista do sistema
     * @param object O objeto que deseja inserir na lista do sistema
     * @return O objeto enviado
     */
    public G create(G object);

    /**
     * Método criado para adquirir todos os objetos cadastrados na lista do sistema
     * @return A lista com todos os objetos cadastrados
     */
    public List<G> FindMany();

    /**
     * Método criado para econtrar um objeto pelo seu id
     * @param id O id do objeto
     * @return o objeto procurado ou nulo (caso ele não esteja cadastrado)
     */
    public G FindById(int id);

    /**
     * Método criado para atuallizar os dados de um objeto previamente cadastrado
     * @param object O objeto que deseja atuaizar os dados
     */
    public void update(G object);

    /**
     * Método criado para deletar um objeto da lista do sistema
     * @param id O id do objeto
     */
    public void delete(int id);

    /**
     * Método criado para limpar completamente a lista
     */
    public void clearList();

}
