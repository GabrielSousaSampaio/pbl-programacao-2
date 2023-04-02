package model;

import java.util.List;

public class Building extends Service {

    //Attributes
    private List<Component> usedComponents;

    //Getters and Setters


    // Methods
    private void addComponent(Component computerComponent){

        this.usedComponents.add(computerComponent);

    }
}
