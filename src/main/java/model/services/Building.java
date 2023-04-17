package main.java.model.services;

import main.java.model.components.Component;
import main.java.model.components.ComputerComponent;
import main.java.model.components.OtherComponent;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Classe criada para representar um serviço de montagem com utilizacão de peças
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class Building implements Service {

    //Attribute
    private List<Component> usedComponents;


    //Constructor

    /**
     * Método cronstrutor do serviço de montagem que inicializa a lista de componentes utilizados
     */
    public Building(){
        this.usedComponents = new ArrayList<>();
    }

    //Methods
    /**
     * Método para adicionar um componente na lista dos componentes utilizados na montagem
     * @param component O componente do tipo "outros" para ser adicionado
     */
    public void addComponent(OtherComponent component){
        this.usedComponents.add(component);
    }

    /**
     * Método para adicionar um componente na lista dos componentes utilizados na montagem
     * @param component O componente de computador para ser adicionado
     */
    public void addComponent(ComputerComponent component){
        this.usedComponents.add(component);
    }

    /**
     * Método para retornar a lista de componentes utilizados
     * @return A lista de componentes utilizados
     */
    public List<Component> getUsedComponents() {
        return usedComponents;
    }

    /**
     * Método criado para retonar o preço dos componentes
     * @return o preço dos componentes
     */
    public double getPrice() {
        double aux = 0;
        for (Component i: usedComponents) {
            aux += i.getPrice();
        }
        return aux;
    }

    /**
     * Método criado para retonar o custo dos componentes
     * @return o custo dos componentes
     */
    public double getCost() {
        double aux = 0;
        for (Component i: usedComponents) {
            aux += i.getCost();
        }
        return aux;
    }
}
