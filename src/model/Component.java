package model;

public class Component {

    //Attributes
    private double price;
    private double cost;
    private int quantity;

    //Constructor

    public Component(double price, double cost, int quantity){
        this.price = price;
        this.cost = cost;
        this.quantity = quantity;
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
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}