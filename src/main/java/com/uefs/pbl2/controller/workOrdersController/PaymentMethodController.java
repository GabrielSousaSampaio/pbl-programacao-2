package com.uefs.pbl2.controller.workOrdersController;

import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.WorkOrder;
import com.uefs.pbl2.model.users.Technician;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class PaymentMethodController {

    private WorkOrder workOrder;

    @FXML
    private Button cancelBTT;

    @FXML
    private Label errorLabel;

    @FXML
    private ComboBox comboBOX;

    @FXML
    private Button saveBTT;

    private Stage dialogStage;

    @FXML
    void cancelBTTAction(ActionEvent event) {
        dialogStage.close();

    }

    @FXML
    void saveBTTAction(ActionEvent event) {

        if(comboBOX.getSelectionModel().getSelectedItem().toString().isEmpty()){

            errorLabel.setStyle("-fx-text-fill:#f70505");
            errorLabel.setText("Selecione alguma opção para confirmar");

        }
        else{

            String s = comboBOX.getSelectionModel().getSelectedItem().toString();

            if(s.equals("Cartão")){

                this.workOrder.setPaymentToCreditCard();

            }else if(s.equals("Dinheiro")){

                this.workOrder.setPaymentToCash();


            }else if(s.equals("Trasferência Bancária")){

                this.workOrder.setPaymentToPix();

            }else if(s.equals("Não pago")){

                this.workOrder.setPaymentMethod(null);

            }
            DAO.getWorkOrder().update(workOrder);
            errorLabel.setStyle("-fx-text-fill:#03f80f");
            errorLabel.setText("Atualizado com sucesso");
        }



    }

    @FXML
    void initialize() {

        ObservableList<String> list = FXCollections.observableArrayList("Cartão","Dinheiro",
                "Trasferência Bancária","Não pago");
        comboBOX.setItems(list);

    }

    public void setWorkOrder(WorkOrder workOrder){

        this.workOrder= workOrder;
    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
