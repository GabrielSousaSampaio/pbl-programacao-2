package com.uefs.pbl2.controller;

import com.uefs.pbl2.HelloApplication;
import com.uefs.pbl2.controller.workOrdersController.PaymentMethodController;
import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.WorkOrder;
import com.uefs.pbl2.model.users.Technician;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class InvoiceController {

    private WorkOrder workOrder;

    @FXML
    private Button cancelBTT;

    @FXML
    private Label idBOX;

    @FXML
    private Label msgLabel;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private Button payBTT;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private TableView<?> table;

    @FXML
    private Label totalBOX;

    private Stage dialogStage;

    @FXML
    void cancelBTTAction(ActionEvent event) {

        dialogStage.close();

    }

    @FXML
    void payBTTAction(ActionEvent event) {

        WorkOrder workOrder = this.workOrder;

        if (workOrder == null) {
            msgLabel.setText("Selecione uma ordem de serviço");
        } else {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("workOrderViews/" +
                        "paymentMethod-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Atualizar pagamento!");
                stage.setResizable(false);
                stage.centerOnScreen();
                stage.initModality(Modality.APPLICATION_MODAL);

                PaymentMethodController paymentMethodController = fxmlLoader.getController();
                paymentMethodController.setDialogStage(stage);
                paymentMethodController.setWorkOrder(workOrder);

                stage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    public void initialize() {

    }

    public void setWorkOrder(WorkOrder workOrder){

        this.workOrder = workOrder;
        this.idBOX.setText(Integer.toString(workOrder.getId()));
        this.totalBOX.setText(Double.toString(workOrder.getPrice()));

    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
