package model;

import java.util.ArrayList;
import java.util.List;

public class Building extends Service {

    //Attributes
    private List<Component> usedComponents;

    //Constructor
    public Building(){
        this.usedComponents = new ArrayList<>();
    }

    //Getters and Setters
    private void addComponent(Component computerComponent){
        this.usedComponents.add(computerComponent);
    }

    @Override
    public double getPrice(){
        double aux = 0;
        for (Component i : usedComponents){
            aux += i.getPrice();
        }
        return aux;
    }

    @Override
    public double getCost(){
        double aux = 0;
        for (Component i : usedComponents){
            aux += i.getCost();
        }
        return aux;
    }
}
