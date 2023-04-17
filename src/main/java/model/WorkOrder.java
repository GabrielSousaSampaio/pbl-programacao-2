package main.java.model;

import main.java.model.services.Service;
import main.java.model.users.Technician;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * Classe criada para representação de uma ordem de serviço
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class WorkOrder {

    //Attributes
    private int id;
    private int customerId;
    private int technicianId;
    private String status;
    private ArrayList<Service> serviceList;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    private String paymentMethod;
    private int satisfaction;
    private boolean paidOut;


    //Constructor
    /**
     * Método cronstrutor da ordem de serviço
     * @param customer O cliente da ordem
     * @param description A descrição da ordem
     */
    public WorkOrder(Customer customer, String description) {
        this.setCustomerId(customer);
        this.status = "Em andamento.";
        this.serviceList = new ArrayList<Service>();
        this.description = description;
        this.setCreatedAt(); // Inicia o contador da criação da ordem
    }

    //Getters and Setters
    /**
     * Método criado para retonar o id da ordem de serviço
     * @return O id da ordem de serviço
     */
    public int getId() {
        return id;
    }

    /**
     * Método criado para alterar o id da ordem de serviço
     * @param id O id da ordem de serviço
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método criado para retonar o id do cliente da ordem de serviço
     * @return O id do cliente da ordem de serviço
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Método criado para alterar o id cliente da ordem de serviço
     * @param customer O id do cliente da ordem de serviço
     */

    public void setCustomerId(Customer customer) {
        this.customerId = customer.getId();
    }

    /**
     * Método criado para retonar o id do técnico da ordem de serviço
     * @return O id do técnico da ordem de serviço
     */
    public int getTechnicianId() {
        return technicianId;
    }

    /**
     * Método criado para alterar o id do técnico da ordem de serviço
     * @param technician O id do técnico da ordem de serviço
     */
    public void setTechnicianId(Technician technician) {
        this.technicianId = technician.getId();
    }

    /**
     * Método criado para retonar o status da ordem de serviço
     * @return O status da ordem de serviço
     */
    public String getStatus() {
        return status;
    }

    /**
     * Método criado para alterar o status da ordem de serviço
     * @param status O status da ordem de serviço
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Método criado para retonar a lista de serviços da ordem de serviço
     * @return A lista de serviços da ordem de serviço
     */
    public ArrayList<Service> getServicelist() {
        return serviceList;
    }

    /**
     * Método criado para alterar a lista de serviços da ordem de serviço
     * @param serviceList A lista de serviços para a ordem de serviço
     */
    public void setServiceList (ArrayList<Service> serviceList) {
        this.serviceList = serviceList;
    }

    /**
     * Método criado para retonar a descrição da ordem de serviço
     * @return A descrição da ordem de serviço
     */
    public String getDescription() {
        return description;
    }

    /**
     * Método criado para alterar a descrição da ordem de serviço
     * @param description A descrição da ordem de serviço
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Método criado para retonar quando foi criada a ordem de serviço
     * @return Quando foi criada a ordem de serviço
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Método criado para iniciar o tempo de criação a ordem de serviço
     */
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Método criado para retonar quando a ordem de serviço foi finalizada
     * @return Quando a ordem de serviço foi finalizada
     */
    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    /**
     * Método criado para finalizar uma ordem de serviço
     */
    public void setFinishedAt() {
        this.finishedAt = LocalDateTime.now();
    }

    /**
     * Método criado para retonar o método de pagamento daquela ordem de serviço
     * @return O método de pagamento daquela da ordem de serviço
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Método criado para alterar o método de pagamento daquela ordem de serviço
     * @param paymentMethod O método de pagamento daquela da ordem de serviço
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    //Other Methods

    /**
     * Método criado para alterar o método de pagamento daquela ordem de serviço para "Cartão de crédito"
     */
    public void setPaymentToCreditCard(){
        this.paymentMethod = ("Cartão de Crédito");
    }

    /**
     * Método criado para alterar o método de pagamento daquela ordem de serviço para "Pix"
     */
    public void setPaymentToPix(){
        this.paymentMethod = ("Pix");
    }
    /**
     * Método criado para alterar o método de pagamento daquela ordem de serviço para "À vista"
     */
    public void setPaymentToCash(){
        this.paymentMethod = ("À vista");
    }

    /**
     * Método para adicionar um serviço na lista de serviços
     * @param service O serviço para ser adicionado
     */
    public void addService(Service service){
        this.serviceList.add(service);
    }

    /**
     * Método para finzaliar a ordem de serviço
     */
    public void finished(){
        this.setStatus("Finalizado.");
        this.setFinishedAt();
    }

    /**
     * Método para cancelar a ordem de serviço
     */
    public void cancel(){
        this.setStatus("Cancelado.");
        this.setFinishedAt();
    }

    /**
     * Método para verificar se a ordem de serviço foi finalizada
     * @return Verdadeiro se estiver finalizado e falso se não estiver
     */
    public boolean isFinshed(){
        return this.getStatus().equals("Finalizado.");
    }

    /**
     * Método para verificar se a ordem de serviço foi cancelada
     * @return Verdadeiro se estiver cancelada e falso se não estiver
     */
    public boolean isCanceled(){
        return this.getStatus().equals("Cancelado.");
    }

    /**
     * Método para verificar se a ordem de serviço está em andamento
     * @return Verdadeiro se estiver em andamento e falso se não estiver
     */
    public boolean isOngoing(){
        return this.getStatus().equals("Em andamento.");
    }

    /**
     * Método criado para retonar o grau de satisfação do cliente
     * @return O grau de satisfação do cliente
     */
    public int getSatisfaction() {
        return satisfaction;
    }

    /**
     * Método criado para alterar o grau de satisfação do cliente
     * @param satisfaction  O grau de satisfação do cliente
     */
    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    /**
     * Método para verificar se a ordem de serviço está paga
     * @return Verdadeiro se estiver paga e falso se não estiver
     */
    public boolean isPaidOut() {
        return paidOut;
    }

    /**
     * Método criado para alterar o status em relação à ordem de serviço ter sido paga ou não
     * @param paidOut O status em relação à ordem de serviço ter sido paga ou não
     */
    public void setPaidOut(boolean paidOut) {
        this.paidOut = paidOut;
    }

    /**
     * Método criado para remover um serviço da ordem de serviços
     * @param service O serviço que deve ser removido
     */
    public void removeService(Service service){
        for (Service i : serviceList) {
            if (i.equals(service)){
                this.serviceList.remove(i);
            }
        }
    }

    /**
     * Método criado para retonar o preço total da ordem de serviço
     * @return O preço total da ordem de serviço
     */
    public double getPrice() {
        double price = 0;
        for (Service i: serviceList) {
            price+=i.getPrice();
        }
        return price;
    }

    /**
     * Método criado para retonar o custo total da ordem de serviço
     * @return O custo total da ordem de serviço
     */
    public double getCost() {
        double cost = 0;
        for (Service i: serviceList) {
            cost+=i.getCost();
        }
        return cost;
    }

    /**
     * Método criado para retonar a diferença entre o tempo em que foi criada a ordem de serviço e quando foi finalizada
     * @return A diferença entre o tempo em que foi criada a ordem de serviço e quando foi finalizada
     */
    public double waitingTime(){
        return ChronoUnit.MINUTES.between(getCreatedAt(), getFinishedAt());
    }
}
