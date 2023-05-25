package com.uefs.pblprogramacao2.dao.customer;

import com.uefs.pblprogramacao2.dao.FileHandling;
import com.uefs.pblprogramacao2.model.Customer;
import java.util.List;

/**
 *
 * Classe criada a partir da implementação da interface "CustomerDAO" para a manipulação dos clientes armazenados
 * no sistema através de arquivos.
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class CustomerFileImpl implements CustomerDAO{
    private List<Customer> customerList;
    private int nextId;

    //Constructor

    /**
     * Método cronstrutor que lê ou cria o arquivo e atualiza o id
     *
     */
    public CustomerFileImpl() {
        this.customerList = FileHandling.readFile("src\\filesSaves\\customer.dat");

        if(customerList.size() == 0) {
            this.nextId = 1;
        }else{

            this.nextId = (customerList.get(customerList.size() - 1).getId()) + 1;
        }
    }

    //Methods

    /**
     * Método criado para a adição de um cliente no arquivo
     * @param customer O cliente que deseja inserir no arquivo
     * @return O cliente enviado
     */
    @Override
    public Customer create(Customer customer) {
        customer.setId(nextId);
        this.nextId++;
        this.customerList.add(customer);

        FileHandling.saveInFile(this.customerList,"src\\filesSaves\\customer.dat");

        return customer;
    }

    /**
     * Método criado para adquirir todos os clientes cadastrados no arquivo
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
     * Método criado para atuallizar os dados de um cliente previamente cadastrado no arquivo
     * @param customer O cliente que deseja atuaizar os dados
     */
    @Override
    public void update(Customer customer) {
        int indexOF;
        for(Customer c: this.customerList){
            if(c.getId() == customer.getId()){
                indexOF = this.customerList.indexOf(c);
                this.customerList.set(indexOF, customer);
                FileHandling.saveInFile(this.customerList,"src\\filesSaves\\customer.dat");
                return;
            }
        }
    }

    /**
     * Método criado para deletar um cliente cadastrado no arquivo
     * @param id O id do cliente
     */
    @Override
    public void delete(int id) {
        int indexRemove;
        for(Customer c: this.customerList){
            if(c.getId() == id){
                indexRemove= this.customerList.indexOf(c);
                this.customerList.remove(indexRemove);
                FileHandling.saveInFile(this.customerList,"src\\filesSaves\\customer.dat");
                return;
            }
        }
    }

    /**
     * Método criado para limpar completamente a lista de clientes cadastrados no arquivo
     */
    @Override
    public void clearList(){

        this.customerList.clear();
        FileHandling.saveInFile(this.customerList,"src\\filesSaves\\customer.dat");
    }
}
