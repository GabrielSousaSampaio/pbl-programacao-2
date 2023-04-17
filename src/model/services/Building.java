package model.services;

import model.components.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Classe criada para representar um serviço de montagem com as peças utilizadas
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class Building extends Service {

    //Attributes
    private List<Component> usedComponents;


    //Constructor

    /**
     * Método cronstrutor do serviço de montagem
     */
    public Building(){
        this.usedComponents = new ArrayList<>();
    }

    //Methods
    /**
     * Método para adicionar um componente na lista dos componentes utilizados na montagem
     * @param component O componente para ser adicionado
     */
    public void addComponent(Component component){
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
    @Override
    public double getPrice() {
        double aux = 0;
        for (Component i: usedComponents) {
            aux += i.getPrice();
        }
        return aux;
    }

    /**
     * Método criado para retonar o preço dos componentes
     * @return o preço dos componentes
     */
    @Override
    public double getCost() {
        double aux = 0;
        for (Component i: usedComponents) {
            aux += i.getCost();
        }
        return aux;
    }
}
