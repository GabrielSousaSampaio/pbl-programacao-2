package model;

public abstract class Service {

    //Attributes
    private double price;
    private double cost;

    //Getters and Setters
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
}