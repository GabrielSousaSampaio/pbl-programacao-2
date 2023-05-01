package main.java.dao.customer;

import main.java.dao.FileHandling;
import main.java.model.Customer;
import java.util.List;

public class CustomerFileImpl implements CustomerDAO{
    private List<Customer> customerList;
    private int nextId;

    //Constructor

    /**
     * Método cronstrutor que inicializa o array para armazenar os clientes e inicia o id com o valor 1
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
     * Método criado para a adição de um cliente na lista do sistema
     * @param customer O cliente que deseja inserir na lista do sistema
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
                FileHandling.saveInFile(this.customerList,"src\\filesSaves\\customer.dat");
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
                FileHandling.saveInFile(this.customerList,"src\\filesSaves\\customer.dat");
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
        FileHandling.saveInFile(this.customerList,"src\\filesSaves\\customer.dat");
    }
}
