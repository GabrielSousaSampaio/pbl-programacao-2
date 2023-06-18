package com.uefs.pbl2.controller;

import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.WorkOrder;
import com.uefs.pbl2.model.components.Component;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDateTime;

import static java.lang.Math.round;

public class ReportController {

    @FXML
    private Label componentPriceBOX;

    @FXML
    private TableColumn<Component, Double> costColumn;

    @FXML
    private TableColumn<Component, Integer> idColumn;

    @FXML
    private TableColumn<Component, Double> priceColumn;

    @FXML
    private TableColumn<Component, Integer> quantityColumn;

    @FXML
    private Label quantityServiceBOX;

    @FXML
    private Label satisfactionAverageBOX;

    @FXML
    private TableView<Component> table;

    @FXML
    private Label timeAverageBOX;

    @FXML
    private Label totalValorBOX;

    private ObservableList<Component> componentObservableList;

    private Stage dialogStage;

    @FXML
    void initialize() {


        int quantity = 0;
        double price = 0;
        double cost = 0;

        for(WorkOrder workOrder: DAO.getWorkOrder().getFinishedWorkOrders()) {
            quantity++;
        }
        for(Component component: DAO.getWorkOrder().getFinishedWorkOrdersUsedComponents()){
           price += component.getPrice();
           cost += component.getCost();

        }
        
        quantityServiceBOX.setText(Integer.toString(quantity));
        timeAverageBOX.setText(Double.toString(DAO.getWorkOrder().getFinishedWorkOrdersAverageTime()));
        componentPriceBOX.setText("R$ " + Double.toString(cost));
        totalValorBOX.setText("R$ " + Double.toString(price - cost));


    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
