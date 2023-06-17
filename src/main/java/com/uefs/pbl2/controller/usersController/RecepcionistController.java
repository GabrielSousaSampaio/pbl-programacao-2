package com.uefs.pbl2.controller.usersController;

import com.uefs.pbl2.HelloApplication;
import com.uefs.pbl2.controller.*;
import com.uefs.pbl2.controller.registerController.WorkOrderRegisterController;
import com.uefs.pbl2.controller.registerController.users.CustomerRegisterController;
import com.uefs.pbl2.model.users.Recepcionist;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static com.uefs.pbl2.controller.StageController.getStage;

public class RecepcionistController {

    private Recepcionist recepcionist;

    @FXML
    private Button customerBTT;

    @FXML
    private Label emailLabel;

    @FXML
    private Button logoutBTT;

    @FXML
    private Button serviceBTT;

    @FXML
    private Label nameLabel;

    @FXML
    private Label msgLabel;

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

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login2-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = getStage(event);

            stage.setScene(scene);
            stage.centerOnScreen();

        } catch (IOException e) {
            this.msgLabel.setStyle("-fx-text-fill:#f70505");
            this.msgLabel.setText("Erro ao tentar abrir outra tela");

        }


    }

    @FXML
    void registerWorkOrderBTTAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registerViews/" +
                    "workOrderRegister-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registro de ordem de serviço");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            WorkOrderRegisterController workOrderRegisterController = fxmlLoader.getController();
            workOrderRegisterController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void searchCustomerBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("findSpecificViews/" +
                    "customerFind-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Busca por cliente");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            CustomerFindController customerFindController = fxmlLoader.getController();
            customerFindController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void searchTechnicianBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("findSpecificViews/" +
                    "technicianFind-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Busca por técnico");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            TechnicianFindController technicianFindController = fxmlLoader.getController();
            technicianFindController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
   void searchWorkOrderBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("findSpecificViews/" +
                    "workOrderFind-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Busca por ordem de serviço");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            WorkOrderFindController workOrderFindController = fxmlLoader.getController();
            workOrderFindController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void stockBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("findSpecificViews/" +
                    "stockFind2-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Estoque");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            StockFindController stockFindController = fxmlLoader.getController();
            stockFindController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void servicesBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("findSpecificViews/" +
                    "serviceFind-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Serviços");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            ServiceFindController serviceFindController = fxmlLoader.getController();
            serviceFindController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

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
