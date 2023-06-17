package com.uefs.pbl2.controller.workOrdersController;

import com.uefs.pbl2.HelloApplication;
import com.uefs.pbl2.controller.registerController.WorkOrderRegisterController;
import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.WorkOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;

public class WorkOrderCanceledFindController {

    @FXML
    private TableColumn<WorkOrder, LocalDateTime> createAtColumn;

    @FXML
    private TableColumn<WorkOrder, String> customerColumn;

    @FXML
    private Button deleteWorkOrderBTT;

    @FXML
    private TableColumn<WorkOrder, String> descriptionColumn;

    @FXML
    private TableColumn<WorkOrder, Integer> idColumn;

    @FXML
    private Label labelError;

    @FXML
    private Label deleteLabel;

    @FXML
    private Button newWorkOrderBTT;

    @FXML
    private TextField searchBOX;

    @FXML
    private Button searchBTT;

    @FXML
    private Button searchBTTE;

    @FXML
    private TableView<WorkOrder> table;

    private ObservableList<WorkOrder> observableWorkOrderList;

    private Stage dialogStage;


    @FXML
    void deleteWorkOrderBTTAction(ActionEvent event) {

        WorkOrder workOrder = table.getSelectionModel().getSelectedItem();

        if(workOrder == null){
            deleteLabel.setText("Selecione uma ordem de serviço");
        }else{

            DAO.getWorkOrder().delete(workOrder.getId());
            observableWorkOrderList.remove(workOrder);
            deleteLabel.setText("Ordem de serviço removida com sucesso");
        }

    }

    @FXML
    void newWorkOrderBTTAction(ActionEvent event) {
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
    void searchBTTAction(ActionEvent event) {

        if(!(searchBOX.getText().isEmpty())){

            try {
                observableWorkOrderList.setAll(DAO.getWorkOrder().FindById(Integer.parseInt(searchBOX.getText())));
                labelError.setText("");
            }catch (NumberFormatException e){

                labelError.setText("Digite um número inteiro!");
            }
        }else{
            observableWorkOrderList.setAll(DAO.getWorkOrder().getCanceledWorkOrders());
        }

    }

    @FXML
    void initialize() {

        observableWorkOrderList = FXCollections.observableArrayList(DAO.getWorkOrder().getCanceledWorkOrders());

        idColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder,Integer>("id"));
        customerColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("CustomerName"));
        createAtColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, LocalDateTime>("CreatedAt"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("description"));


        table.setItems(observableWorkOrderList);

    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
