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
    public void addComponent(Component component){
        this.usedComponents.add(component);
    }

    public List<Component> getUsedComponents() {
        return usedComponents;
    }
}
