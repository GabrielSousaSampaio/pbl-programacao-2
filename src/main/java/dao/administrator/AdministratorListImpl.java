package main.java.dao.administrator;

import main.java.model.users.Administrator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Classe criada a partir da implementação da interface "AdministratorDAO" para a manipulação dos administradores
 * armazenadas no sistema através de listas.
 *
 * @author Gabriel Sousa Sampaio, Gabriel Baptista
 */

public class AdministratorListImpl implements AdministratorDAO {

    private List<Administrator> administratorList;
    private int nextId;

    //Constructor
    /**
     * Método cronstrutor que inicializa o array para armazenar os administradores e inicia o id com o valor 1
     *
     */
    public AdministratorListImpl() {
        this.administratorList = new ArrayList<Administrator>();
        this.nextId = 1;
    }

    //Methods

    /**
     * Método criado para a adição de um administrador na lista do sistema
     * @param administrator O administrador que deseja inserir na lista do sistema
     * @return O administrador enviado
     */
    @Override
    public Administrator create(Administrator administrator) {
        administrator.setId(nextId);
        this.nextId++;
        this.administratorList.add(administrator);
        return administrator;
    }

    /**
     * Método criado para adquirir todos os administradores cadastrados na lista do sistema
     * @return A lista com todos os administradores cadastrados
     */
    @Override
    public List<Administrator> FindMany() {
        return this.administratorList;
    }

    /**
     * Método criado para econtrar um administrador pelo seu id
     * @param id O id do administrador
     * @return O administrador procurado ou nulo (caso ele não esteja cadastrado)
     */
    @Override
    public Administrator FindById(int id) {

        for(Administrator a: this.administratorList){
            if(a.getId() == id){
                return a;
            }
        }
        return null;

    }

    /**
     * Método criado para atuallizar os dados de um administrador previamente cadastrado
     * @param administrator O administrador que deseja atuaizar os dados
     */
    @Override
    public void update(Administrator administrator) {

        int indexOF;
        for(Administrator a: this.administratorList){
            if(a.getId() == administrator.getId()){
                indexOF = this.administratorList.indexOf(a);
                this.administratorList.set(indexOF, administrator);
                return;
            }
        }

    }

    /**
     * Método criado para deletar um administrador da lista do sistema
     * @param id O id do administrador
     */
    @Override
    public void delete(int id) {

        int indexRemove;
        for(Administrator a: this.administratorList){
            if(a.getId() == id){
                indexRemove = this.administratorList.indexOf(a);
                this.administratorList.remove(indexRemove);
                return;
            }
        }

    }

    /**
     * Método criado para limpar completamente a lista de administradores
     */
    @Override
    public void clearList() {

        this.administratorList.clear();

    }
}
