package model;

import java.util.ArrayList;
import java.util.List;

public class Building extends Service {

    //Attributes
    private List<Component> usedComponents;

    public Building(){
        this.usedComponents = new ArrayList<>();
    }

    //Getters and Setters


    // Methods
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
