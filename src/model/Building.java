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

    public List<Component> getUsedComponents() {
        return usedComponents;
    }
}
