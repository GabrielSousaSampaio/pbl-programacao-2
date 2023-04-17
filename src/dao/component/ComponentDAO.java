package dao.component;

import dao.CRUD;
import model.Component;

/**
 * Interface criada para apresentar os métodos a serem implementados pela aplicação referente aos componentes do estoque
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */
public interface ComponentDAO extends CRUD<Component> {

    /**
     * Método criado para retirar uma certa quantidade de componentes armazenados no estoque
     */
    Component pickingComponent(Component component, int quantity);
}
