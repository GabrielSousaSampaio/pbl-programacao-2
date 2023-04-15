package model;

public class Installation extends Service{

    //Attributes
    private String installationName;

    //Constructor
    public Installation (String installationName, double price, double cost){
        this.installationName = installationName;
        this.setPrice(price);
        this.setCost(cost);
    }

    //Getters and Setters
    public String getInstallationName() {
        return installationName;
    }

    public void setInstallationName(String installationName) {
        this.installationName = installationName;
    }
}