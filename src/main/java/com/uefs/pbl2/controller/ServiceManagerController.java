package com.uefs.pbl2.controller;

import com.uefs.pbl2.HelloApplication;
import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.services.Cleaning;
import com.uefs.pbl2.model.services.Installation;
import com.uefs.pbl2.model.services.Service;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.uefs.pbl2.controller.StageController.getStage;

public class ServiceManagerController {

    @FXML
    private Label CSmsgLabel;

    @FXML
    private Label ISmsgLabel;

    @FXML
    private TableColumn<Cleaning, Double> costCSColumn;

    @FXML
    private TableColumn<Installation, Double> costISColumn;

    @FXML
    private Button homeBTT;

    @FXML
    private TableColumn<Cleaning, Integer> idCSColumn;

    @FXML
    private TableColumn<Installation, Integer> idISColumn;

    @FXML
    private Label labelError1;

    @FXML
    private TableColumn<Cleaning, String> nameCSColumn;

    @FXML
    private TableColumn<Installation, String> nameISColumn;

    @FXML
    private TableColumn<Cleaning, Double> priceCSColumn;

    @FXML
    private TableColumn<Installation, Double> priceISColumn;

    @FXML
    private TextField searchCSBox;

    @FXML
    private Button searchCSBtt;

    @FXML
    private Button searchCustomerBTT;

    @FXML
    private Button searchISBtt;

    @FXML
    private TextField searchOCBox;

    @FXML
    private Button searchTechnicianBTT;

    @FXML
    private TableView<Cleaning> tableCleaningService;

    @FXML
    private TableView<Installation> tableInstallationService;

    private ObservableList<Installation> installationObservableList;

    private ObservableList<Cleaning> cleaningObservableList;

    private Stage dialogStage;

    @FXML
    void homeBTTAction(ActionEvent event) {


    }

    @FXML
    void searchCSBttAction(ActionEvent event) {

    }

    @FXML
    void searchCustomerBTTAction(ActionEvent event) {

    }

    @FXML
    void searchISBttAction(ActionEvent event) {

    }

    @FXML
    void searchTechnicianBTTAction(ActionEvent event) {

    }

    @FXML
    public void initialize() {


        cleaningObservableList = FXCollections.observableArrayList(DAO.getCleaning().FindMany());
        installationObservableList = FXCollections.observableArrayList(DAO.getInstallation().FindMany());

        idCSColumn.setCellValueFactory(new PropertyValueFactory<Cleaning,Integer>("id"));
        nameCSColumn.setCellValueFactory(new PropertyValueFactory<Cleaning, String>("cleaningName"));
        priceCSColumn.setCellValueFactory(new PropertyValueFactory<Cleaning, Double>("price"));
        costCSColumn.setCellValueFactory(new PropertyValueFactory<Cleaning, Double>("cost"));

        idISColumn.setCellValueFactory(new PropertyValueFactory<Installation,Integer>("id"));
        nameISColumn.setCellValueFactory(new PropertyValueFactory<Installation, String>("installationName"));
        priceISColumn.setCellValueFactory(new PropertyValueFactory<Installation, Double>("price"));
        costISColumn.setCellValueFactory(new PropertyValueFactory<Installation, Double>("cost"));



        tableCleaningService.setItems(cleaningObservableList);
        tableInstallationService.setItems(installationObservableList);

    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
