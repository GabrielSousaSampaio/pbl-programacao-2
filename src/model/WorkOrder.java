package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class WorkOrder {

    //Attributes
    private int id;
    private int customerId;
    private int technicianId;
    private String status;
    private ArrayList<Service> serviceList;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    private String paymentMethod;
    private int satisfaction;
    private boolean paidOut;


    //Constructor
    public WorkOrder(Customer customer, String description) {
        this.setCustomerId(customer);
        this.setStatus("Em andamento.");
        this.setServiceList(new ArrayList<>());
        this.setDescription(description);
        this.setCreatedAt();
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customer) {
        this.customerId = customer.getId();
    }

    public int getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Technician technician) {
        this.technicianId = technician.getId();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Service> getServicelist() {
        return serviceList;
    }

    public void setServiceList (ArrayList<Service> serviceList) {
        this.serviceList = serviceList;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    //Other Methods
    public void setPaymentToCreditCard(){
        this.paymentMethod = ("Cartão de Crédito");
    }

    public void setPaymentToPix(){
        this.paymentMethod = ("Pix");
    }

    public void setPaymentToCash(){
        this.paymentMethod = ("À vista");
    }

    public void addService(Service service){
        this.serviceList.add(service);
    }
    public void finished(){
        this.setStatus("Finalizado.");
    }

    public void cancel(){
        this.setStatus("Cancelado.");
    }

    public boolean isFinshed(){
        return this.getStatus().equals("Finalizado.");
    }

    public boolean isCanceled(){
        return this.getStatus().equals("Cancelado.");
    }

    public boolean isOngoing(){
        return this.getStatus().equals("Em andamento.");
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public boolean isPaidOut() {
        return paidOut;
    }

    public void setPaidOut(boolean paidOut) {
        this.paidOut = paidOut;
    }

    public void removeService(Service service){
        for (Service i : serviceList) {
            if (i.equals(service)){
                this.serviceList.remove(i);
            }
        }
    }

    public double getPrice() {
        double price = 0;
        for (Service i: serviceList) {
            price+=i.getPrice();
        }
        return price;
    }

    public double getCost() {
        double cost = 0;
        for (Service i: serviceList) {
            cost+=i.getCost();
        }
        return cost;
    }

    public double waitingTime(){
        return ChronoUnit.MINUTES.between(getCreatedAt(), getFinishedAt());
    }
}
