package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WorkOrder {

    //Attributes
    private int id;
    private Customer customer;
    private Technician technician;
    private String status;
    public List<Service> servicelist;
    public String description;
    public LocalDateTime createdAt;
    public LocalDateTime finishedAt;
    public double price;
    public double cost;
    public String paymentMethod;


    //Constructor
    public WorkOrder(Customer customer, String description) {
        this.setCustomer(customer);
        this.setTechnician(null);
        this.setStatus("Em andamento.");
        this.setServicelist(new ArrayList<>());
        this.setDescription(description);
        this.setCreatedAt();
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt() {
        this.finishedAt = LocalDateTime.now();
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
