package model;

public class Installation extends Service{

    //Attributes
    private int id;
    private String installationName;

    //Constructor
    public Installation (double price, double cost,String installationName){
        this.setPrice(price);
        this.setCost(cost);
        this.installationName = installationName;
    }

    //Getters and Setters
    public String getInstallationName() {
        return installationName;
    }

    public void setInstallationName(String installationName) {
        this.installationName = installationName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}