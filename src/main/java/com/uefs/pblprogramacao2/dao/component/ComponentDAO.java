package com.uefs.pblprogramacao2.dao.component;

import com.uefs.pblprogramacao2.dao.CRUD;
import com.uefs.pblprogramacao2.model.components.Component;
import com.uefs.pblprogramacao2.model.components.ComputerComponent;
import com.uefs.pblprogramacao2.model.components.OtherComponent;

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
