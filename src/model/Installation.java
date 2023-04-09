package model;

import java.util.ArrayList;
import java.util.List;

public class Installation extends Service{

    //Attributes
    private List<String> programs;
    private String operatingSystem;
    private double programPrice;
    private double operatingSystemPrice;
    private double programCost;
    private double operatingSystemCost;

    //Constructor
    public Installation (double programPrice, double programCost, double operatingSystemPrice, double operatingSystemCost){
        this.programs = new ArrayList<String>();
        this.programPrice = programPrice;
        this.programCost = programCost;
        this.operatingSystemPrice = operatingSystemPrice;
        this.operatingSystemCost = operatingSystemCost;
    }

    //Getters and Setters
    public List<String> getPrograms() {
        return programs;
    }

    public void setPrograms(List<String> programs) {
        this.programs = programs;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getProgramPrice() {
        return programPrice;
    }

    public void setProgramPrice(double programPrice) {
        this.programPrice = programPrice;
    }

    public double getOperatingSystemPrice() {
        return operatingSystemPrice;
    }

    public void setOperatingSystemPrice(double operatingSystemPrice) {
        this.operatingSystemPrice = operatingSystemPrice;
    }

    public double getProgramCost() {
        return programCost;
    }

    public void setProgramCost(double programCost) {
        this.programCost = programCost;
    }

    public double getOperatingSystemCost() {
        return operatingSystemCost;
    }

    public void setOperatingSystemCost(double operatingSystemCost) {
        this.operatingSystemCost = operatingSystemCost;
    }

    @Override
    public double getPrice(){
        double aux = 0;
        for(String i : programs){
            aux+=getProgramPrice();
        }
        if (operatingSystem != null){
            aux+=getOperatingSystemPrice();
        }
        return aux;
    }

    @Override
    public double getCost(){
        double aux = getProgramCost()*programs.size();
        if (operatingSystem != null){
            aux+=getOperatingSystemCost();
        }
        return aux;
    }
}