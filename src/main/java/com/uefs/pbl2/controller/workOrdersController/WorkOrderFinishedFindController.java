package com.uefs.pbl2.controller.workOrdersController;

import com.uefs.pbl2.HelloApplication;
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

public class WorkOrderFinishedFindController {

    @FXML
    private TableColumn<WorkOrder, LocalDateTime> createAtColumn;

    @FXML
    private TableColumn<WorkOrder, String> customerColumn;

    @FXML
    private Button deleteWorkOrderBTT;

    @FXML
    private TableColumn<WorkOrder, String> descriptionColumn;

    @FXML
    private TableColumn<WorkOrder, LocalDateTime> finshAtColumn;

    @FXML
    private TableColumn<WorkOrder, Integer> idColumn;

    @FXML
    private Label labelError;

    @FXML
    private Label deleteLabel;

    @FXML
    private Button newWorkOrderBTT;

    @FXML
    private TableColumn<WorkOrder, String> payedColumn;

    @FXML
    private TextField searchBOX;

    @FXML
    private Button searchBTT;

    @FXML
    private Button searchBTTE;

    @FXML
    private TableView<WorkOrder> table;

    @FXML
    private Button updatePaymentBTT;

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

    }

    @FXML
    void searchBTTAction(ActionEvent event) {

        if(!(searchBOX.getText().isEmpty())){

            try {
                observableWorkOrderList.setAll(DAO.getWorkOrder().FindById(Integer.parseInt(searchBOX.getText())));

            }catch (NumberFormatException e){

                labelError.setText("Digite um número inteiro!");
            }
        }else{
            observableWorkOrderList.setAll(DAO.getWorkOrder().getFinishedWorkOrders());
        }

    }

    @FXML
    void searchBTTEAction(ActionEvent event) {

    }

    @FXML
    void updatePaymentBTTAction(ActionEvent event) {

        WorkOrder workOrder = table.getSelectionModel().getSelectedItem();

        if (workOrder == null) {
            deleteLabel.setText("Selecione uma ordem de serviço");
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("workOrderViews/" +
                        "paymentMethod-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Alterar método de pagamento");
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
    void initialize() {

        observableWorkOrderList = FXCollections.observableArrayList(DAO.getWorkOrder().getFinishedWorkOrders());

        idColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder,Integer>("id"));
        customerColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("CustomerName"));
        createAtColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, LocalDateTime>("CreatedAt"));
        finshAtColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, LocalDateTime>("FinshedAt"));
        payedColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("CreatedAt"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("description"));


        table.setItems(observableWorkOrderList);

    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }



}
