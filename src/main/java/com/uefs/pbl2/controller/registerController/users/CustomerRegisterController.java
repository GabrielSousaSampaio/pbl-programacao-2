package com.uefs.pbl2.controller.registerController.users;


import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CustomerRegisterController {

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

    private Stage dialogStage;

    @FXML
    void deleteBttAction(ActionEvent event) {

        Customer cliente = tabel.getSelectionModel().getSelectedItem();
        if(cliente == null){
            labelError.setText("Selecione um cliente");
        }else{

            DAO.getCustomer().delete(cliente.getId());
            observableCustomerList.remove(cliente);
            labelAceppt.setText("Cliente removido com sucesso");
        }


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

        if(!(searchBox.getText().isEmpty())){

            try {
                observableCustomerList.setAll(DAO.getCustomer().FindById(Integer.parseInt(searchBox.getText())));
                labelError.setText("");
            }catch (NumberFormatException e){

                labelError.setText("Digite um número inteiro!");
            }
        }else{
            observableCustomerList.setAll(DAO.getCustomer().FindMany());
        }

    }

    @FXML
    void updateBttAction(ActionEvent event) {

        Customer cliente = tabel.getSelectionModel().getSelectedItem();
        if(cliente == null){
            labelError.setText("Selecione um cliente");
        }else{

            if(nameBox.getText().isEmpty() || emailBox.getText().isEmpty() || addressBox.getText().isEmpty()
                    || phoneBox.getText().isEmpty() ){

                labelError.setText("ERRO, campos preenchidos incorretamente!");
            }else{

                cliente.setName(nameBox.getText());
                cliente.setEmail(emailBox.getText());
                cliente.setAddress(addressBox.getText());
                cliente.setPhone(phoneBox.getText());

                DAO.getCustomer().update(cliente);

                observableCustomerList.set(tabel.getSelectionModel().getSelectedIndex(), cliente);

                labelAceppt.setText("Cliente atualizado com sucesso!");

                nameBox.clear();
                emailBox.clear();
                addressBox.clear();
                phoneBox.clear();
            }
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

        tabel.setItems(observableCustomerList);

    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
