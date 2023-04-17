package dao.component;

import dao.CRUD;
import model.components.Component;
import model.components.ComputerComponent;
import model.components.OtherComponent;

/**
 * Interface criada para apresentar os métodos a serem implementados pela aplicação referente aos componentes do estoque
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */
public interface ComponentDAO extends CRUD<Component> {

    /**
     * Método criado para retirar uma certa quantidade de componentes de computador armazenados no estoque
     */
    Component pickingComponent(ComputerComponent component, int quantity);

    /**
     * Método criado para retirar uma certa quantidade de "outros componentes" armazenados no estoque
     */
    Component pickingComponent(OtherComponent component, int quantity);


}
