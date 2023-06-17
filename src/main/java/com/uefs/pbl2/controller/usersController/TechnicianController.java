package com.uefs.pbl2.controller.usersController;

import com.uefs.pbl2.HelloApplication;
import com.uefs.pbl2.controller.ActualWorkOrderController;
import com.uefs.pbl2.controller.ServiceManagerController;
import com.uefs.pbl2.controller.StockFindController;
import com.uefs.pbl2.controller.StockManagerController;
import com.uefs.pbl2.controller.workOrdersController.WorkOrderCanceledFindController;
import com.uefs.pbl2.controller.workOrdersController.WorkOrderFinishedFindController;
import com.uefs.pbl2.controller.workOrdersController.WorkOrderOpenFindController;
import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.WorkOrder;
import com.uefs.pbl2.model.components.Component;
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
import java.util.ArrayList;

import static com.uefs.pbl2.controller.StageController.getStage;


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
    private Label msgLabel;

    @FXML
    private Button findWorkOrderBTT;

    @FXML
    private Button serviceManagerBTT;

    @FXML
    private Button finshedWorkOrdersBTT;

    @FXML
    private TableColumn<WorkOrder, Integer> idColumn;

    @FXML
    private Button nextServiceBTT;

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

        if(this.technician.getWorkingOn() != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("actualWorkOrder-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Ordem de serviço atual");
                stage.setResizable(false);
                stage.centerOnScreen();
                stage.initModality(Modality.APPLICATION_MODAL);

                ActualWorkOrderController actualWorkOrderController = fxmlLoader.getController();
                actualWorkOrderController.setDialogStage(stage);
                actualWorkOrderController.setWorkOrder(this.technician.getWorkingOn());

                stage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            this.msgLabel.setStyle("-fx-text-fill:#f70505");
            this.msgLabel.setText("Você não está trabalhando em um serviço");
        }

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
    void nextServiceBTTAction(ActionEvent event){

        if(DAO.getTechnician().FindById(technician.getId()).getWorkingOn() != null){
            this.msgLabel.setStyle("-fx-text-fill:#f70505");
            this.msgLabel.setText("Você já possui um serviço");
        }else{

            if(observableWorkOrderTList.isEmpty()){
                this.msgLabel.setStyle("-fx-text-fill:#f70505");
                this.msgLabel.setText("Tabela sem serviços!");
            }else{
                WorkOrder workOrder = observableWorkOrderTList.get(0);
                DAO.getWorkOrder().FindById(observableWorkOrderTList.get(0).getId()).setTechnician(this.technician);
                DAO.getTechnician().FindById(this.technician.getId()).setWorkingOn(workOrder);
                System.out.println(DAO.getTechnician().FindById(this.technician.getId()).getWorkingOn());
                msgLabel.setStyle("-fx-text-fill:#03f80f");
                msgLabel.setText("Serviço adcionado!");

            }
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
            this.msgLabel.setStyle("-fx-text-fill:#03f80f");
            this.msgLabel.setText("Erro ao tentar abrir outra tela");

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
    public void initialize() {

        ArrayList<WorkOrder> workOrders = new ArrayList<WorkOrder>();
        for(Technician t: DAO.getTechnician().FindMany()){
            for(WorkOrder w:DAO.getWorkOrder().getOpenedWorkOrders()) {
                    if (t.getWorkingOn() != w){
                        workOrders.add(w);
                    }
            }
        }


        observableWorkOrderTList = FXCollections.observableArrayList(workOrders);

        idColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder,Integer>("id"));
        customerColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("CustomerName"));
        createAtColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, LocalDateTime>("CreatedAt"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("description"));


        tabel.setItems(observableWorkOrderTList);

    }

    public void setTechnician(Technician technicianobj){
        technician = technicianobj;
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
