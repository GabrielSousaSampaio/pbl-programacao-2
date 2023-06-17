package com.uefs.pbl2.controller.registerController.users;

import com.uefs.pbl2.controller.LoginController;
import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.users.Administrator;
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

public class AdministratorRegisterController {

    @FXML
    private Button deleteBtt;

    @FXML
    private TextField emailBox;

    @FXML
    private TableColumn<Administrator, String> emailColumn;

    @FXML
    private TableColumn<Administrator, Integer> idColumn;

    @FXML
    private Label labelAceppt;

    @FXML
    private Label labelError;

    @FXML
    private Label labelError1;

    @FXML
    private TextField nameBox;

    @FXML
    private TableColumn<Administrator, String> nameColumn;

    @FXML
    private TextField passwordBox;

    @FXML
    private Button saveBtn;

    @FXML
    private TextField searchBox;

    @FXML
    private Button searchBtt;

    @FXML
    private Button searchEBtt;

    @FXML
    private TableView<Administrator> tabel;

    @FXML
    private Button updateBtt;

    private ObservableList<Administrator> observableAdministratorList;

    private Stage dialogStage;

    @FXML
    void deleteBttAction(ActionEvent event) {

        Administrator administrador = tabel.getSelectionModel().getSelectedItem();

        if(administrador == null){
            labelError.setText("Selecione um administrador");
        }else{

            DAO.getAdministrator().delete(administrador.getId());
            observableAdministratorList.remove(administrador);
            labelAceppt.setText("Administrador removido com sucesso");
        }

    }

    @FXML
    void saveBtnAction(ActionEvent event) {

        if(nameBox.getText().isEmpty() || emailBox.getText().isEmpty() || passwordBox.getText().isEmpty() ){

            labelError.setText("ERRO, campos preenchidos incorretamente!");
        }else{

            Administrator newAdministrator = new Administrator(nameBox.getText(),emailBox.getText(), passwordBox.getText());

            DAO.getAdministrator().create(newAdministrator);

            observableAdministratorList.add(newAdministrator);

            labelAceppt.setText("Administrador registrado com sucesso!");

            nameBox.clear();
            emailBox.clear();
            passwordBox.clear();
        }

    }

    @FXML
    void searchBttAction(ActionEvent event) {

        if(!(searchBox.getText().isEmpty())){

            try {
                observableAdministratorList.setAll(DAO.getAdministrator().FindById(Integer.parseInt(searchBox.getText())));
                labelError.setText("");
            }catch (NumberFormatException e){

                labelError.setText("Digite um número inteiro!");
            }
        }else{
            observableAdministratorList.setAll(DAO.getAdministrator().FindMany());
        }

    }

    @FXML
    void searchBttEAction(ActionEvent event) {

        LoginController lg = new LoginController();

    }

    @FXML
    void updateBttAction(ActionEvent event) {

        Administrator administrador = tabel.getSelectionModel().getSelectedItem();
        if(administrador == null){
            labelError.setText("Selecione um administrador");
        }else{

            if(nameBox.getText().isEmpty() || emailBox.getText().isEmpty() || passwordBox.getText().isEmpty() ){

                labelError.setText("ERRO, campos preenchidos incorretamente!");
            }else{

                administrador.setName(nameBox.getText());
                administrador.setEmail(emailBox.getText());
                administrador.setPassword(passwordBox.getText());

                DAO.getAdministrator().update(administrador);

                observableAdministratorList.set(tabel.getSelectionModel().getSelectedIndex(), administrador);

                labelAceppt.setText("Administrador atualizado com sucesso!");

                nameBox.clear();
                emailBox.clear();
                passwordBox.clear();
            }
        }

    }

    @FXML
    void initialize() {

        observableAdministratorList = FXCollections.observableArrayList(DAO.getAdministrator().FindMany());

        idColumn.setCellValueFactory(new PropertyValueFactory<Administrator,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Administrator,String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Administrator,String>("email"));


        tabel.setItems(observableAdministratorList);

    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
