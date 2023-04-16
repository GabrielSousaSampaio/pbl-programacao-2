package dao.customer;

import model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerListImpl implements CustomerDAO {

    private List<Customer> CustomerList;
    private int nextID;

    public CustomerListImpl() {
        this.CustomerList = new ArrayList<Customer>();
        this.nextID = 0;
    }

    @Override
    public Customer create(Customer customer) {
        customer.setId(nextID);
        this.nextID++;
        this.CustomerList.add(customer);
        return customer;
    }

    @Override
    public List<Customer> FindMany() {
        return this.CustomerList;
    }

    @Override
    public Customer FindById(int id) {
        for(Customer c: this.CustomerList){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    @Override
    public void update(Customer customer) {
        int indexOF;
        for(Customer c: this.CustomerList){
            if(c.getId() == customer.getId()){
                indexOF = this.CustomerList.indexOf(c);
                this.CustomerList.set(indexOF, customer);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        int indexRemove;
        for(Customer c: this.CustomerList){
            if(c.getId() == id){
                indexRemove= this.CustomerList.indexOf(c);
                this.CustomerList.remove(indexRemove);
                return;
            }
        }
    }
}