package com.uefs.pbl2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StockManagerController {

    @FXML
    private Label CCmsgLabel;

    @FXML
    private Label OCmsgLabel;

    @FXML
    private TableColumn<?, ?> costCCColumn;

    @FXML
    private TableColumn<?, ?> costOCColumn;

    @FXML
    private TableColumn<?, ?> descriptionOCColumn;

    @FXML
    private Button homeBTT;

    @FXML
    private TableColumn<?, ?> idCCColumn;

    @FXML
    private TableColumn<?, ?> idOCColumn;

    @FXML
    private Label labelError1;

    @FXML
    private TableColumn<?, ?> manefacturedCCColumn;

    @FXML
    private TableColumn<?, ?> nameCCColumn;

    @FXML
    private TableColumn<?, ?> priceCCColumn;

    @FXML
    private TableColumn<?, ?> priceOCColumn;

    @FXML
    private TableColumn<?, ?> quantityCCColumn;

    @FXML
    private TableColumn<?, ?> quantityOCColumn;

    @FXML
    private TextField searchCCBox;

    @FXML
    private Button searchCCBtt;

    @FXML
    private Button searchCustomerBTT;

    @FXML
    private TextField searchOCBox;

    @FXML
    private Button searchOCBtt;

    @FXML
    private Button searchTechnicianBTT;

    @FXML
    private TableView<?> tableComputerComponent;

    @FXML
    private TableView<?> tableOtherComponents;

    private Stage dialogStage;

    @FXML
    void homeBTTAction(ActionEvent event) {

    }

    @FXML
    void searchCCBttAction(ActionEvent event) {

    }

    @FXML
    void searchCustomerBTTAction(ActionEvent event) {

    }

    @FXML
    void searchIOCBttAction(ActionEvent event) {

    }

    @FXML
    void searchTechnicianBTTAction(ActionEvent event) {

    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
