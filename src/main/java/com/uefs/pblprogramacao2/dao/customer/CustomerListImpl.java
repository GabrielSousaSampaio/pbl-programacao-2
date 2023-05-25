package com.uefs.pblprogramacao2.dao.customer;

import com.uefs.pblprogramacao2.model.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Classe criada a partir da implementação da interface "CustomerDAO" para a manipulação dos clientes armazenados
 * no sistema através de listas.
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class CustomerListImpl implements CustomerDAO {

    private List<Customer> customerList;
    private int nextId;

    //Constructor

    /**
     * Método cronstrutor que inicializa o array para armazenar os clientes e inicia o id com o valor 1
     *
     */
    public CustomerListImpl() {
        this.customerList = new ArrayList<Customer>();
        this.nextId = 1;
    }

    //Methods

    /**
     * Método criado para a adição de um cliente na lista do sistema
     * @param customer O cliente que deseja inserir na lista do sistema
     * @return O cliente enviado
     */
    @Override
    public Customer create(Customer customer) {
        customer.setId(nextId);
        this.nextId++;
        this.customerList.add(customer);
        return customer;
    }

    /**
     * Método criado para adquirir todos os clientes cadastrados na lista do sistema
     * @return A lista com todos os clientes cadastrados
     */
    @Override
    public List<Customer> FindMany() {
        return this.customerList;
    }

    /**
     * Método criado para econtrar um cliente pelo seu id
     * @param id O id do cliente
     * @return O cliente procurado ou nulo (caso ele não esteja cadastrado)
     */
    @Override
    public Customer FindById(int id) {
        for(Customer c: this.customerList){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    /**
     * Método criado para atuallizar os dados de um cliente previamente cadastrado
     * @param customer O cliente que deseja atuaizar os dados
     */
    @Override
    public void update(Customer customer) {
        int indexOF;
        for(Customer c: this.customerList){
            if(c.getId() == customer.getId()){
                indexOF = this.customerList.indexOf(c);
                this.customerList.set(indexOF, customer);
                return;
            }
        }
    }

    /**
     * Método criado para deletar um cliente da lista do sistema
     * @param id O id do cliente
     */
    @Override
    public void delete(int id) {
        int indexRemove;
        for(Customer c: this.customerList){
            if(c.getId() == id){
                indexRemove= this.customerList.indexOf(c);
                this.customerList.remove(indexRemove);
                return;
            }
        }
    }

    /**
     * Método criado para limpar completamente a lista de clientes
     */
    @Override
    public void clearList(){

        this.customerList.clear();
    }
}