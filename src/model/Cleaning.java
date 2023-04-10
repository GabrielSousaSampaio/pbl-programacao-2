package model;

public class Cleaning extends Service{

    public Cleaning(double price, double cost){
        setPrice(price);
        setCost(cost);
    }

    public void addService(){
        this.getPrice();
    }
}
