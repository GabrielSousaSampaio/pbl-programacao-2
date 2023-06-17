package com.uefs.pbl2.controller.workOrdersController;

import com.uefs.pbl2.HelloApplication;
import com.uefs.pbl2.controller.WorkOrderUpdateController;
import com.uefs.pbl2.controller.registerController.WorkOrderRegisterController;

import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.Customer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import com.uefs.pbl2.model.WorkOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;

public class WorkOrderOpenFindController {

    @FXML
    private TableColumn<WorkOrder, LocalDateTime> createAtColumn;

    @FXML
    private TableColumn<WorkOrder, String> customerColumn;

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
    private Button deleteBTT;

    @FXML
    private TextField searchBOX;

    @FXML
    private Button searchBTT;

    @FXML
    private Button searchBTTE;

    @FXML
    private TableView<WorkOrder> table;

    @FXML
    private Button updateWorkOrderBTT;
    

    private ObservableList<WorkOrder> observableWorkOrderList;

    private Stage dialogStage;

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
            observableWorkOrderList.setAll(DAO.getWorkOrder().getOpenedWorkOrders());
        }

    }



    @FXML
    void updateWorkOrderBTTAction(ActionEvent event) {

        WorkOrder workOrder = table.getSelectionModel().getSelectedItem();

        if(workOrder == null) {
            labelError.setText("Selecione um cliente");
        } else{
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(
                        "workOrderUpdate-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Atualizar uma ordem de serviço");
                stage.setResizable(false);
                stage.centerOnScreen();
                stage.initModality(Modality.APPLICATION_MODAL);

                WorkOrderUpdateController workOrderUpdateController = fxmlLoader.getController();
                workOrderUpdateController.setDialogStage(stage);
                workOrderUpdateController.setWorkOrder(workOrder);
                stage.showAndWait();

                dialogStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @FXML
    void deleteBTTAction(ActionEvent event){

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
    void initialize() {

        observableWorkOrderList = FXCollections.observableArrayList(DAO.getWorkOrder().getOpenedWorkOrders());

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
