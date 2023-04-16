package dao.component;

import model.Component;
import java.util.ArrayList;
import java.util.List;

public class ComponentListImpl implements ComponentDAO {

    private List<Component> ComponentList;
    private int nextID;

    //Constructor
    public ComponentListImpl() {
        this.ComponentList = new ArrayList<Component>();
        this.nextID = 0;
    }


    //Methods
    @Override
    public Component create(Component component) {
        component.setId(nextID);
        this.nextID++;
        this.ComponentList.add(component);
        return component;
    }

    @Override
    public List<Component> FindMany() {
        return this.ComponentList;
    }

    @Override
    public Component FindById(int id) {

        for(Component c: this.ComponentList){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    @Override
    public void update(Component component) {
        int indexOF;
        for(Component c: this.ComponentList){
            if(c.getId() == component.getId()){
                indexOF = this.ComponentList.indexOf(c);
                this.ComponentList.set(indexOF, component);
                return;
            }
        }

    }

    @Override
    public void delete(int id) {
        int indexRemove;
        for(Component c: this.ComponentList){
            if(c.getId() == id){
                indexRemove= this.ComponentList.indexOf(c);
                this.ComponentList.remove(indexRemove);
                return;
            }
        }
    }

    public Component pickingComponent(Component component, int quantity){
        if(component.getQuantity() >= quantity){
            component.setQuantity((component.getQuantity() - quantity));
            Component newComponent = component.copy();
            newComponent.setQuantity(quantity);
            return newComponent;
        }
        return null;
    }
}
