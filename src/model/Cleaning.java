package model;

public class Cleaning extends Service{

    //Attributes
    private String cleaningName;

    //Constructor
    public Cleaning(String cleaningName, double price, double cost){
        this.cleaningName = cleaningName;
        this.setPrice(price);
        this.setCost(cost);
    }

    //Getters and Setters
    public String getCleaningName() {
        return cleaningName;
    }

    public void setCleaningName(String cleaningName) {
        this.cleaningName = cleaningName;
    }
}