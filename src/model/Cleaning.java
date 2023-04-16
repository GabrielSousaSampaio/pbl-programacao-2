package model;

public class Cleaning extends Service{

    //Attributes
    private int id;
    private String cleaningName;

    //Constructor
    public Cleaning(double price, double cost, String cleaningName){
        this.setPrice(price);
        this.setCost(cost);
        this.cleaningName = cleaningName;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCleaningName() {
        return cleaningName;
    }

    public void setCleaningName(String cleaningName) {
        this.cleaningName = cleaningName;
    }
}