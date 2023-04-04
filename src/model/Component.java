package model;

public class Component {

    //Attributes
    private double price;
    private double cost;

    //Constructor
    public Component(double price, double cost){
        this.price = price;
        this.cost = cost;
    }

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
