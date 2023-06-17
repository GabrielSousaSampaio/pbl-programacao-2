package com.uefs.pbl2.controller.usersController;

import com.uefs.pbl2.HelloApplication;
import com.uefs.pbl2.controller.ReportController;
import com.uefs.pbl2.controller.ServiceManagerController;
import com.uefs.pbl2.controller.StockManagerController;
import com.uefs.pbl2.controller.registerController.users.AdministratorRegisterController;
import com.uefs.pbl2.controller.registerController.users.CustomerRegisterController;
import com.uefs.pbl2.controller.registerController.users.RecepcionistRegisterController;
import com.uefs.pbl2.controller.registerController.users.TechnicianRegisterController;
import com.uefs.pbl2.controller.workOrdersController.WorkOrderCanceledFindController;
import com.uefs.pbl2.controller.workOrdersController.WorkOrderFinishedFindController;
import com.uefs.pbl2.controller.workOrdersController.WorkOrderOpenFindController;
import com.uefs.pbl2.model.users.Administrator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static com.uefs.pbl2.controller.StageController.getStage;

public class AdministratorController {

    private Administrator administrator;

    @FXML
    private Button administratorBTT;

    @FXML
    private Button customerBTT;

    @FXML
    private Label emailLabel;

    @FXML
    private Button nextServiceBTT;

    @FXML
    private Button serviceManagerBTT;

    @FXML
    private ImageView l;

    @FXML
    private Button logoutBTT;

    @FXML
    private Label nameLabel;

    @FXML
    private Button recepcionistBTT;

    @FXML
    private Button reportBTT;

    @FXML
    private Button searchCanceledWorkOrderBTT;

    @FXML
    private Label msgLabel;

    @FXML
    private Button searchEWorkOrderBTT;

    @FXML
    private Button searchFinishedWorkOrderBTT;

    @FXML
    private Button searchOpenWorkOrderBTT;

    @FXML
    private Button stockManagerBTT;

    @FXML
    private Button technicianBTT;

    private Stage dialogStage;

    @FXML
    void administratorBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registerViews/" +
                    "administratorRegister-view2.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registro de administrador");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            AdministratorRegisterController administratorRegisterController = fxmlLoader.getController();
            administratorRegisterController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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
    void recepcionistBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registerViews/" +
                    "recepcionistRegister-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registro de recepcionista");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            RecepcionistRegisterController recepcionistRegisterController = fxmlLoader.getController();
            recepcionistRegisterController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void reportBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("report-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Relatório");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            ReportController reportController = fxmlLoader.getController();
            reportController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void searchCanceledWorkOrderBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("workOrderViews/" +
                    "workOrderCancel-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ordens de serviço canceladas");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

           WorkOrderCanceledFindController workOrderCanceledFindController = fxmlLoader.getController();
            workOrderCanceledFindController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void searchFinishedWorkOrderBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("workOrderViews/" +
                    "workOrderFinish-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ordens de serviço finalizadas");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

           WorkOrderFinishedFindController workOrderFinishedFindController = fxmlLoader.getController();
            workOrderFinishedFindController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void searchOpenWorkOrderBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("workOrderViews/workOrderOpen-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ordens de serviço abertas");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            WorkOrderOpenFindController workOrderOpenFindController = fxmlLoader.getController();
            workOrderOpenFindController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void stockManagerBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("stockManager-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Estoque de peças");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            StockManagerController stockManagerController = fxmlLoader.getController();
            stockManagerController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void serviceManagerBTTAction(ActionEvent event){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("serviceManager-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Serviços");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            ServiceManagerController serviceManagerController = fxmlLoader.getController();
            serviceManagerController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void technicianBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registerViews/" +
                    "technicianRegister-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registro de técnico");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            TechnicianRegisterController technicianRegisterController = fxmlLoader.getController();
            technicianRegisterController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setAdministrator(Administrator administratorobj){
        this.administrator = administratorobj;
        try {
            nameLabel.setText(administrator.getName());
            emailLabel.setText(administrator.getEmail());
        } catch (Exception e){
            nameLabel.setText("");
            emailLabel.setText("");
        }
    }


    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }


}
