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
}
