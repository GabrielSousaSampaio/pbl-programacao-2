package model;

import java.util.ArrayList;
import java.util.List;

public class Building extends Service {

    //Attributes
    private List<Integer> usedComponents;

    //Constructor
    public Building(){
        this.usedComponents = new ArrayList<>();
    }

    //Getters and Setters
    private void addComponent(Component computerComponent){
        this.usedComponents.add(computerComponent.getId());
    }
}
