package com.uefs.pbl2.controller;

import com.uefs.pbl2.model.WorkOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WorkOrderFindController {

    @FXML
    private ComboBox<?> comboBOX;

    @FXML
    private TableColumn<?, ?> createAtColumn;

    @FXML
    private TableColumn<?, ?> customerColumn;

    @FXML
    private TableColumn<?, ?> descriptionColumn;

    @FXML
    private TableColumn<?, ?> finshAtColumn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private Label labelError1;

    @FXML
    private Label msgLabel;

    @FXML
    private TableColumn<?, ?> payedColumn;

    @FXML
    private TextField searchBox;

    @FXML
    private Button searchBtt;

    @FXML
    private TableView<?> table;

    private Stage dialogStage;

    @FXML
    void searchBttAction(ActionEvent event) {

    }


    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
