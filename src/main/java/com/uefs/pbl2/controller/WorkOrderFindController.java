package com.uefs.pbl2.controller;

import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.WorkOrder;
import com.uefs.pbl2.model.components.Component;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class WorkOrderFindController {


    @FXML
    private TableColumn<WorkOrder, LocalDateTime> createAtColumn;

    @FXML
    private TableColumn<WorkOrder, String> customerColumn;

    @FXML
    private TableColumn<WorkOrder, String> descriptionColumn;

    @FXML
    private TableColumn<WorkOrder, LocalDateTime> finshAtColumn;

    @FXML
    private TableColumn<WorkOrder, Integer> idColumn;

    @FXML
    private Label labelError1;

    @FXML
    private Label msgLabel;

    @FXML
    private TableColumn<WorkOrder, String> payedColumn;

    @FXML
    private TextField searchBox;

    @FXML
    private Button searchBtt;

    @FXML
    private TableView<WorkOrder> table;

    private ObservableList<WorkOrder> workOrderObservableList;

    private Stage dialogStage;

    @FXML
    void searchBttAction(ActionEvent event) {

        if(!(searchBox.getText().isEmpty())){

            try {
                workOrderObservableList.setAll(DAO.getWorkOrder().FindById(Integer.parseInt(searchBox.getText())));
                msgLabel.setText("");
            }catch (NumberFormatException e){
                msgLabel.setStyle("-fx-text-fill:#f70505");
                msgLabel.setText("Digite um número inteiro!");
            }
        }else{
            workOrderObservableList.setAll(DAO.getWorkOrder().FindMany());
        }



    }

    @FXML
    void initialize() {

        workOrderObservableList = FXCollections.observableArrayList(DAO.getWorkOrder().FindMany());

        idColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder,Integer>("id"));
        customerColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("CustomerName"));
        createAtColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, LocalDateTime>("CreatedAt"));
        finshAtColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, LocalDateTime>("FinshedAt"));
        payedColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("CreatedAt"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("description"));


        table.setItems(workOrderObservableList);

    }
    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
