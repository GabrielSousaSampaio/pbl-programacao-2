package com.uefs.pbl2.controller.registerController;

import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.Customer;
import com.uefs.pbl2.model.WorkOrder;
import com.uefs.pbl2.model.users.Technician;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WorkOrderRegisterController {

    @FXML
    private Button cancelBtt;

    @FXML
    private Label msgLabel;

    @FXML
    private TextField descriptionBox;

    @FXML
    private TextField idBox;

    @FXML
    private Button saveBtn;

    private Stage dialogStage;

    @FXML
    void cancelBttAction(ActionEvent event) {

        dialogStage.close();

    }

    @FXML
    void saveBtnAction(ActionEvent event) {

        if(descriptionBox.getText().isEmpty()  || idBox.getText().isEmpty() ){

            this.msgLabel.setStyle("-fx-text-fill:#f70505");
            msgLabel.setText("ERRO, campos preenchidos incorretamente!");
        }else{
            try {
                Customer customer = DAO.getCustomer().FindById(Integer.parseInt(idBox.getText()));
                if (customer != null) {
                    WorkOrder workOrder = new WorkOrder(customer, descriptionBox.getText());
                    DAO.getWorkOrder().create(workOrder);
                    this.msgLabel.setStyle("-fx-text-fill:#03f80f");
                    msgLabel.setText("Ordem de serviço registrado com sucesso!");
                } else {
                    this.msgLabel.setStyle("-fx-text-fill:#f70505");
                    msgLabel.setText("Cliente inexistente!");
                }

                descriptionBox.clear();
                idBox.clear();
            }catch (Exception e){
                this.msgLabel.setStyle("-fx-text-fill:#f70505");
                msgLabel.setText("ERRO, campos preenchidos incorretamente!");

            }
        }

    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
