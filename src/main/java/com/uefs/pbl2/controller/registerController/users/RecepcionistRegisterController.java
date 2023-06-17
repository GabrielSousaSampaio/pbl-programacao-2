package com.uefs.pbl2.controller.registerController.users;

import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.users.Recepcionist;
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

public class RecepcionistRegisterController {

    @FXML
    private Button deleteBtt;

    @FXML
    private TextField emailBox;

    @FXML
    private TableColumn<Recepcionist, String> emailColumn;

    @FXML
    private TableColumn<Recepcionist, Integer> idColumn;

    @FXML
    private Label labelAceppt;

    @FXML
    private Label labelError;

    @FXML
    private Label labelError1;

    @FXML
    private TextField nameBox;

    @FXML
    private TableColumn<Recepcionist, String> nameColumn;

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
    private TableView<Recepcionist> tabel;

    @FXML
    private Button updateBtt;

    private ObservableList<Recepcionist> observableRecepcionistList;

    private Stage dialogStage;

    @FXML
    void deleteBttAction(ActionEvent event) {

        Recepcionist recepcionista = tabel.getSelectionModel().getSelectedItem();

        if(recepcionista == null){
            labelError.setText("Selecione um recepcionista");
        }else{

            DAO.getRecepcionist().delete(recepcionista.getId());
            observableRecepcionistList.remove(recepcionista);
            labelAceppt.setText("Recepcionista removido com sucesso");
        }

    }

    @FXML
    void saveBtnAction(ActionEvent event) {

        if(nameBox.getText().isEmpty() || emailBox.getText().isEmpty() || passwordBox.getText().isEmpty() ){

            labelError.setText("ERRO, campos preenchidos incorretamente!");
        }else{

            Recepcionist newRecepcionist = new Recepcionist(nameBox.getText(),emailBox.getText(), passwordBox.getText());

            DAO.getRecepcionist().create(newRecepcionist);

            observableRecepcionistList.add(newRecepcionist);

            labelAceppt.setText("Recepcionista registrado com sucesso!");

            nameBox.clear();
            emailBox.clear();
            passwordBox.clear();
        }

    }

    @FXML
    void searchBttAction(ActionEvent event) {

        if(!(searchBox.getText().isEmpty())){

            try {
                observableRecepcionistList.setAll(DAO.getRecepcionist().FindById(Integer.parseInt(searchBox.getText())));
                labelError.setText("");
            }catch (NumberFormatException e){

                labelError.setText("Digite um número inteiro!");
            }
        }else{
            observableRecepcionistList.setAll(DAO.getRecepcionist().FindMany());
        }

    }


    @FXML
    void updateBttAction(ActionEvent event) {

        Recepcionist recepcionista = tabel.getSelectionModel().getSelectedItem();
        if(recepcionista == null){
            labelError.setText("Selecione um recepcionista");
        }else{

            if(nameBox.getText().isEmpty() || emailBox.getText().isEmpty() || passwordBox.getText().isEmpty() ){

                labelError.setText("ERRO, campos preenchidos incorretamente!");
            }else{

                recepcionista.setName(nameBox.getText());
                recepcionista.setEmail(emailBox.getText());
                recepcionista.setPassword(passwordBox.getText());

                DAO.getRecepcionist().update(recepcionista);

                observableRecepcionistList.set(tabel.getSelectionModel().getSelectedIndex(), recepcionista);

                labelAceppt.setText("Recepcionista atualizado com sucesso!");

                nameBox.clear();
                emailBox.clear();
                passwordBox.clear();
            }
        }

    }

    @FXML
    void initialize() {

        observableRecepcionistList = FXCollections.observableArrayList(DAO.getRecepcionist().FindMany());

        idColumn.setCellValueFactory(new PropertyValueFactory<Recepcionist,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Recepcionist,String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Recepcionist,String>("email"));


        tabel.setItems(observableRecepcionistList);

    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
