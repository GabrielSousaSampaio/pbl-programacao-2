package com.uefs.pbl2.controller;

import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.Customer;
import com.uefs.pbl2.model.WorkOrder;
import com.uefs.pbl2.model.users.Recepcionist;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class WorkOrderUpdateController {

    private WorkOrder workOrder;

    @FXML
    private Button cancelBtt;

    @FXML
    private Button finishedBTT;

    @FXML
    private Button cancelWorkOrderBTT;

    @FXML
    private TextField descriptionBox;

    @FXML
    private Label msgLabel;

    @FXML
    private Label idCustomerLabel;

    @FXML
    private Button saveBtn;

    private Stage dialogStage;

    @FXML
    void cancelBttAction(ActionEvent event) {

        dialogStage.close();

    }

    @FXML
    void saveBtnAction(ActionEvent event) {

        if(descriptionBox.getText().isEmpty()){

            this.msgLabel.setStyle("-fx-text-fill:#f70505");
            msgLabel.setText("ERRO, campos preenchidos incorretamente!");
        }else{

            //WorkOrder workOrder = new WorkOrder(this.workOrder.getCustomer(), descriptionBox.getText());
            workOrder.setDescription(descriptionBox.getText());
            DAO.getWorkOrder().update(workOrder);
            this.msgLabel.setStyle("-fx-text-fill:#03f80f");
            msgLabel.setText("Ordem de serviço registrado com sucesso!");


            descriptionBox.clear();
            dialogStage.close();
        }



    }

    @FXML
    void cancelWorkOrderBTTAction(ActionEvent event){
        this.workOrder.cancel();
        DAO.getWorkOrder().update(workOrder);
        dialogStage.close();

    }

    @FXML
    void finishedBTTAction(ActionEvent event){
        this.workOrder.finished();
        DAO.getWorkOrder().update(workOrder);
        dialogStage.close();


    }

    public void setWorkOrder(WorkOrder workOrder){
        this.workOrder = workOrder;
        try {
            this.idCustomerLabel.setText(Integer.toString(workOrder.getCustomer().getId()));
        } catch (Exception e){
            this.idCustomerLabel.setText("");

        }
    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
