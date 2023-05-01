package main.java.dao.component;

import main.java.dao.FileHandling;
import main.java.model.components.Component;
import main.java.model.components.ComputerComponent;
import main.java.model.components.OtherComponent;

import java.util.ArrayList;
import java.util.List;

public class ComponentFileImpl implements ComponentDAO{

    private List<Component> componentList;
    private int nextId;

    //Constructor

    /**
     * Método cronstrutor que inicializa o array para armazenar os componentes e inicia o id com o valor 1
     *
     */
    public ComponentFileImpl() {
        this.componentList = FileHandling.readFile("src\\filesSaves\\component.dat");

        if(componentList.size() == 0) {
            this.nextId = 1;
        }else{

            this.nextId = (componentList.get(componentList.size() - 1).getId()) + 1;
        }
    }

    //Methods

    /**
     * Método criado para a adição de um componente na lista do sistema
     * @param component O componente que deseja inserir na lista do sistema
     * @return O componente enviado
     */
    @Override
    public Component create(Component component) {
        component.setId(nextId);
        this.nextId++;
        this.componentList.add(component);

        FileHandling.saveInFile(this.componentList,"src\\filesSaves\\component.dat");
        return component;
    }

    /**
     * Método criado para adquirir todos os componentes cadastrados na lista do sistema
     * @return A lista com todos os componentes cadastrados
     */
    @Override
    public List<Component> FindMany() {
        return this.componentList;
    }

    /**
     * Método criado para econtrar um componente pelo seu id
     * @param id O id do componente
     * @return O componente procurado ou nulo (caso ele não esteja cadastrado)
     */
    @Override
    public Component FindById(int id) {

        for(Component c: this.componentList){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    /**
     * Método criado para atuallizar os dados de um componente previamente cadastrado
     * @param component O componente que deseja atuaizar os dados
     */
    @Override
    public void update(Component component) {
        int indexOF;
        for(Component c: this.componentList){
            if(c.getId() == component.getId()){
                indexOF = this.componentList.indexOf(c);
                this.componentList.set(indexOF, component);
                FileHandling.saveInFile(this.componentList,"src\\filesSaves\\component.dat");
                return;
            }
        }

    }

    /**
     * Método criado para deletar um componente da lista do sistema
     * @param id O id do componente
     */
    @Override
    public void delete(int id) {
        int indexRemove;
        for(Component c: this.componentList){
            if(c.getId() == id){
                indexRemove= this.componentList.indexOf(c);
                this.componentList.remove(indexRemove);
                FileHandling.saveInFile(this.componentList,"src\\filesSaves\\component.dat");
                return;
            }
        }
    }

    /**
     * Método criado para limpar completamente a lista de componentes
     */
    @Override
    public void clearList(){

        this.componentList.clear();
        FileHandling.saveInFile(this.componentList,"src\\filesSaves\\component.dat");
    }


    @Override
    public Component pickingComponent(ComputerComponent component, int quantity){

        if(component.getQuantity() >= quantity){
            component.setQuantity((component.getQuantity() - quantity));
            Component newComponent = component.copy();
            newComponent.setQuantity(quantity);
            FileHandling.saveInFile(this.componentList,"src\\filesSaves\\component.dat");
            return newComponent;
        }
        return null;
    }

    @Override
    public Component pickingComponent(OtherComponent component, int quantity){
        if(component.getQuantity() >= quantity){
            component.setQuantity((component.getQuantity() - quantity));
            Component newComponent = component.copy();
            newComponent.setQuantity(quantity);
            FileHandling.saveInFile(this.componentList,"src\\filesSaves\\component.dat");
            return newComponent;
        }
        return null;
    }
}
