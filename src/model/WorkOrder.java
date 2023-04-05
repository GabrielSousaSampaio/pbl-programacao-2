package model;

import java.util.Date;
import java.util.List;

public class WorkOrder {

    //Attributes
    private int id;
    private Customer customer;
    private Technician technician;
    private String status;
    public List<Service> servicelist;
    public String description;
    public Date createdAt;
    public Date finishedAt;
    public double price;
    public double cost;
    public String paymentMethod;


    //Constructor
    public WorkOrder(Customer customer, List<Service> service, String description) {
        this.setCustomer(customer);
        this.setTechnician(null);
        this.setStatus("Em andamento.");
        this.setServicelist(service);
        this.setDescription(description);
        //this.setCreatedAt();
        //this.setPrice(price);
        //this.setCost(cost);
        this.setPaymentMethod(null);
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Service> getServicelist() {
        return servicelist;
    }

    public void setServicelist(List<Service> servicelist) {
        this.servicelist = servicelist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(Date finishedAt) {
        this.finishedAt = finishedAt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    //Other Methods
    public void addService(Service service){
        this.servicelist.add(service);
    }
    public void finished(){
        this.setStatus("Finalizado.");
    }

    public void cancel(){
        this.setStatus("Cancelado.");
    }

    public boolean isFinshed(){
        if(this.getStatus().equals("Finalizado.")){
            return true;
        }
        return false;
    }

    public boolean isCanceled(){
        if(this.getStatus().equals("Cancelado.")){
            return true;
        }
        return false;
    }

    public boolean isOngoing(){
        if(this.getStatus().equals("Em andamento.")){
            return true;
        }
        return false;
    }

    //public boolean isPaid(){

    //}
}
