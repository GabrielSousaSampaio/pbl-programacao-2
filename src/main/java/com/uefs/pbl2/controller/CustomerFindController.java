package com.uefs.pbl2.controller;

import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.Customer;
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

public class CustomerFindController {

    @FXML
    private TableColumn<Customer, String> addressColumn;

    @FXML
    private TableColumn<Customer, String> emailColumn;

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private Label labelError1;

    @FXML
    private Label msgLabel;

    @FXML
    private TableColumn<Customer, String> nameColumn;

    @FXML
    private TableColumn<Customer, String> phoneColumn;

    @FXML
    private TextField searchBox;

    @FXML
    private Button searchBtt;

    @FXML
    private TableView<Customer> table;

    private ObservableList<Customer> observableCustomerList;

    private Stage dialogStage;

    @FXML
    void searchBttAction(ActionEvent event) {

        if(!(searchBox.getText().isEmpty())){

            try {
                observableCustomerList.setAll(DAO.getCustomer().FindById(Integer.parseInt(searchBox.getText())));

            }catch (NumberFormatException e){
                this.msgLabel.setStyle("-fx-text-fill:#f70505");
                msgLabel.setText("Digite um número inteiro!");

            }
        }else{
            observableCustomerList.setAll(DAO.getCustomer().FindMany());
        }



    }

    @FXML
    void initialize() {

        observableCustomerList = FXCollections.observableArrayList(DAO.getCustomer().FindMany());

        idColumn.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("email"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("phone"));

        table.setItems(observableCustomerList);

    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
