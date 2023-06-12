package com.uefs.pbl2.controller.usersController;

import com.uefs.pbl2.HelloApplication;
import com.uefs.pbl2.controller.registerController.users.CustomerRegisterController;
import com.uefs.pbl2.model.users.Recepcionist;
import com.uefs.pbl2.model.users.Technician;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class RecepcionistController {

    private Recepcionist recepcionist;

    @FXML
    private Button customerBTT;

    @FXML
    private Label emailLabel;

    @FXML
    private Button logoutBTT;

    @FXML
    private Label nameLabel;

    @FXML
    private Button registerWorkOrderBTT;

    @FXML
    private Button searchCustomerBTT;

    @FXML
    private Button searchTechnicianBTT;

    @FXML
    private Button searchWorkOrderBTT;

    @FXML
    private Button stockBTT;

    private Stage dialogStage;

    @FXML
    void customerBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registerViews/" +
                    "customerRegister-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registro de cliente");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            CustomerRegisterController customerRegisterController = fxmlLoader.getController();
            customerRegisterController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void logoutBTTAction(ActionEvent event) {

    }

    @FXML
    void registerWorkOrderBTTAction(ActionEvent event) {

    }

    @FXML
    void searchCustomerBTTAction(ActionEvent event) {

    }

    @FXML
    void searchTechnicianBTTAction(ActionEvent event) {

    }

    @FXML
    void searchWorkOrderBTTAction(ActionEvent event) {

    }

    @FXML
    void stockBTTAction(ActionEvent event) {

    }
    public void setRecepcionist(Recepcionist recepcionistobj){
        this.recepcionist = recepcionistobj;
        try {
            this.nameLabel.setText(recepcionist.getName());
            this.emailLabel.setText(recepcionist.getEmail());
        } catch (Exception e){
            this.nameLabel.setText("");
            this.emailLabel.setText("");
        }
    }


    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
