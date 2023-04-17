package dao.workorder;

import dao.CRUD;
import model.components.Component;
import model.WorkOrder;

import java.util.List;

/**
 * Interface criada para apresentar os métodos a serem implementados pela aplicação referente as ordens de serviço
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public interface WorkOrderDAO extends CRUD<WorkOrder>  {


    /**
     * Método criado para procurar uma ordem de serviço armazenada através do id do técnico
     * @param id O id do técnico
     * @return A lista de ordens de serviços do técnico enviado
     */
    List<WorkOrder> FindByTechnicianId(int id);

    /**
     * Método criado para procurar uma ordem de serviço armazenada através do id do cliente
     * @param id O id do cliente
     * @return A lista de ordens de serviços do cliente enviado
     */
    List<WorkOrder>  FindByCustomerId(int id);

    /**
     * Método criado para adquirir todas as ordens de serviço finalizadas
     * @return A lista de ordens de serviços finalizadas
     */
    List<WorkOrder> getFinishedWorkOrders();

    /**
     * Método criado para calcular o preço total em todas as ordens de serviço finalizadas
     * @return O preço total das ordens de serviços finalizadas
     */
    double getFinishedWorkOrdersTotalPrice();

    /**
     * Método criado para calcular o custo total em todas as ordens de serviço finalizadas
     * @return O custo total das ordens de serviços finalizadas
     */
    double getFinishedWorkOrdersTotalCost();

    /**
     * Método criado para calcular o tempo médio em todas as ordens de serviço finalizadas
     * @return O tempo médio das ordens de serviços finalizadas
     */
    double getFinishedWorkOrdersAverageTime();

    /**
     * Método criado para calcular a média das satisfações dos clientes em todas as ordens de serviços finalizadas
     * @return A média das satisfações dos clientes
     */
    double getFinishedWorkOrdersAverageRating();

    /**
     * Método criado para adquirir os componentes utilizados em todas as ordens de serviços finalizadas
     * @return A lista de componentes utilizados em todas as ordens de serviço
     */
    List<Component> getFinishedWorkOrdersUsedComponents();
}
