package com.uefs.pbl2.controller.usersController;

import com.uefs.pbl2.HelloApplication;
import com.uefs.pbl2.controller.workOrdersController.WorkOrderCanceledFindController;
import com.uefs.pbl2.controller.workOrdersController.WorkOrderFinishedFindController;
import com.uefs.pbl2.controller.workOrdersController.WorkOrderOpenFindController;
import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.WorkOrder;
import com.uefs.pbl2.model.users.Technician;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


public class TechnicianController{

    private Technician technician;

    @FXML
    private Button actualWorkOrderBTT;

    @FXML
    private Button canceledWorkOrdersBTT;

    @FXML
    private TableColumn<WorkOrder, LocalDateTime> createAtColumn;

    @FXML
    private TableColumn<WorkOrder, String> customerColumn;

    @FXML
    private TableColumn<WorkOrder, String> descriptionColumn;

    @FXML
    private Label emailLabel;

    @FXML
    private Button findWorkOrderBTT;

    @FXML
    private Button finshedWorkOrdersBTT;

    @FXML
    private TableColumn<WorkOrder, Integer> idColumn;

    @FXML
    private Button invoiceBTT;

    @FXML
    private Button logoutBTT;

    @FXML
    private Label nameLabel;

    @FXML
    private Button stockManagerBTT;

    @FXML
    private TableView<WorkOrder> tabel;

    private ObservableList<WorkOrder> observableWorkOrderTList;

    private Stage dialogStage;

    @FXML
    void actualWorkOrderBTTAction(ActionEvent event) {




    }

    @FXML
    void canceledWorkOrdersBTTAction(ActionEvent event) {

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
    void findWorkOrderBTTAction(ActionEvent event) {

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
    void finshedWorkOrdersBTTAction(ActionEvent event) {

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
    void invoiceBTTAction(ActionEvent event) {

    }

    @FXML
    void logoutBTTAction(ActionEvent event) {

    }

    @FXML
    void stockManagerBTTAction(ActionEvent event) {

    }

    @FXML
    public void initialize() {

        observableWorkOrderTList = FXCollections.observableArrayList(DAO.getWorkOrder().getOpenedWorkOrders());

        idColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder,Integer>("id"));
        customerColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("CustomerName"));
        createAtColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, LocalDateTime>("CreatedAt"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("description"));


        tabel.setItems(observableWorkOrderTList);

    }

    public void setTechnician(Technician technicianobj){
        this.technician = technicianobj;
        try {
            this.nameLabel.setText(technician.getName());
            this.emailLabel.setText(technician.getEmail());
        } catch (Exception e){
            this.nameLabel.setText("");
            this.emailLabel.setText("");
        }
    }


    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }
}
