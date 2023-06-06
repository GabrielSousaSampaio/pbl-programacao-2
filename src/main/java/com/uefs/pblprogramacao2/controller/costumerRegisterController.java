package com.uefs.pblprogramacao2.controller;

import com.uefs.pblprogramacao2.dao.DAO;
import com.uefs.pblprogramacao2.model.Customer;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Properties;

public class costumerRegisterController {

    @FXML
    private TextField addressBox;

    @FXML
    private TableColumn<Customer, String> addressColumn;

    @FXML
    private Button deleteBtt;

    @FXML
    private TextField emailBox;

    @FXML
    private TableColumn<Customer, String> emailColumn;

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private Label labelAceppt;

    @FXML
    private Label labelError;

    @FXML
    private TextField nameBox;

    @FXML
    private TableColumn<Customer, String> nameColumn;

    @FXML
    private TextField phoneBox;

    @FXML
    private TableColumn<Customer, String> phoneColumn;

    @FXML
    private Button saveBtn;

    @FXML
    private TextField searchBox;

    @FXML
    private Button searchBtt;

    @FXML
    private Button searchEBtt;

    @FXML
    private TableView<Customer> tabel;

    @FXML
    private Button updateBtt;

    private ObservableList<Customer> observableCustomerList;

    @FXML
    void deleteBttAction(ActionEvent event) {



    }

    @FXML
    void saveBtnAction(ActionEvent event) {

        if(nameBox.getText().isEmpty() || emailBox.getText().isEmpty() || addressBox.getText().isEmpty()
                || phoneBox.getText().isEmpty() ){

            labelError.setText("ERRO, campos preenchidos incorretamente!");
        }else{

            Customer newCustomer = new Customer(nameBox.getText(),emailBox.getText(),addressBox.getText(),
                    phoneBox.getText());

            DAO.getCustomer().create(newCustomer);

            observableCustomerList.add(newCustomer);

            labelAceppt.setText("Cliente registrado com sucesso!");

            nameBox.clear();
            emailBox.clear();
            addressBox.clear();
            phoneBox.clear();
        }



    }

    @FXML
    void searchBttAction(ActionEvent event) {

    }

    @FXML
    void searchBttEAction(ActionEvent event) {

    }

    @FXML
    void updateBttAction(ActionEvent event) {

    }

    @FXML
    void initialize() {

        observableCustomerList = FXCollections.observableArrayList(DAO.getCustomer().FindMany());

        idColumn.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("email"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("phone"));

        tabel.setItems(observableCustomerList);

    }

}
