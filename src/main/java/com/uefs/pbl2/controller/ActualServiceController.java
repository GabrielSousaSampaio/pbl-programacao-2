package com.uefs.pbl2.controller.workOrdersController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class ActualServiceController {

    @FXML
    private Label clienteBOX;

    @FXML
    private TableColumn<?, ?> costCCColumn;

    @FXML
    private TableColumn<?, ?> costCSColumn;

    @FXML
    private TableColumn<?, ?> costISColumn;

    @FXML
    private TableColumn<?, ?> costOCColumn;

    @FXML
    private TableColumn<?, ?> descriptionOCColumn;

    @FXML
    private Button homeBTT;

    @FXML
    private TableColumn<?, ?> idCCColumn;

    @FXML
    private TableColumn<?, ?> idCSColumn;

    @FXML
    private TableColumn<?, ?> idISColumn;

    @FXML
    private TableColumn<?, ?> idOCColumn;

    @FXML
    private Button includeComponentBTT;

    @FXML
    private Button includeServiceBTT;

    @FXML
    private TableColumn<?, ?> manefacturedCCColumn;

    @FXML
    private Label msgLabel;

    @FXML
    private VBox msgLabel1;

    @FXML
    private VBox msgLabel11;

    @FXML
    private TableColumn<?, ?> nameCCColumn;

    @FXML
    private TableColumn<?, ?> nameCSColumn;

    @FXML
    private TableColumn<?, ?> nameISColumn;

    @FXML
    private TableColumn<?, ?> priceCCColumn;

    @FXML
    private TableColumn<?, ?> priceCSColumn;

    @FXML
    private TableColumn<?, ?> priceISColumn;

    @FXML
    private TableColumn<?, ?> priceOCColumn;

    @FXML
    private TableColumn<?, ?> quantityCCColumn;

    @FXML
    private TableColumn<?, ?> quantityOCColumn;

    @FXML
    private TableView<?> tableCleaningService;

    @FXML
    private TableView<?> tableComputerComponent;

    @FXML
    private TableView<?> tableInstallationService;

    @FXML
    private TableView<?> tableOtherComponents;

    @FXML
    private Label workOrderIDBOX;

    @FXML
    void homeBTTAction(ActionEvent event) {

    }

    @FXML
    void includeComponentBTTAction(ActionEvent event) {

    }

    @FXML
    void includeServiceBTTAction(ActionEvent event) {

    }

}
