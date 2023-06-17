package com.uefs.pbl2.controller;

import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.users.Technician;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TechnicianFindController {

    @FXML
    private TableColumn<Technician, String> emailColumn;

    @FXML
    private TableColumn<Technician, Integer> idColumn;

    @FXML
    private Label labelError1;

    @FXML
    private TableColumn<Technician, String> nameColumn;

    @FXML
    private TextField searchBox;

    @FXML
    private Button searchBtt;

    @FXML
    private Label msgLabel;

    @FXML
    private TableView<Technician> tabel;

    @FXML
    private TableColumn<Technician, String> workOnColumn;

    private ObservableList<Technician> observableTechnicianList;

    private Stage dialogStage;

    @FXML
    void searchBttAction(ActionEvent event) {


        if(!(searchBox.getText().isEmpty())){

            try {
                observableTechnicianList.setAll(DAO.getTechnician().FindById(Integer.parseInt(searchBox.getText())));

            }catch (NumberFormatException e){

                this.msgLabel.setStyle("-fx-text-fill:#f70505");
                msgLabel.setText("Digite um número inteiro!");
            }
        }else{
            observableTechnicianList.setAll(DAO.getTechnician().FindMany());
        }

    }

    @FXML
    void initialize() {

        observableTechnicianList = FXCollections.observableArrayList(DAO.getTechnician().FindMany());

        idColumn.setCellValueFactory(new PropertyValueFactory<Technician,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Technician,String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Technician,String>("email"));

        workOnColumn.setCellValueFactory(new PropertyValueFactory<Technician,String>("getWorkingOn.getid"));


        tabel.setItems(observableTechnicianList);

    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }
}
