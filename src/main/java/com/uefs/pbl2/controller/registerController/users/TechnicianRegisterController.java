package com.uefs.pbl2.controller.registerController.users;

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

public class TechnicianRegisterController {

    @FXML
    private Button deleteBtt;

    @FXML
    private TextField emailBox;

    @FXML
    private TableColumn<Technician, String> emailColumn;

    @FXML
    private TableColumn<Technician, Integer> idColumn;

    @FXML
    private TableColumn<Technician, String> workOnColumn;

    @FXML
    private Label labelAceppt;

    @FXML
    private Label labelError;

    @FXML
    private Label labelError1;

    @FXML
    private TextField nameBox;

    @FXML
    private TableColumn<Technician, String> nameColumn;

    @FXML
    private TextField passwordBox;

    @FXML
    private Button saveBtn;

    @FXML
    private TextField searchBox;

    @FXML
    private Button searchBtt;

    @FXML
    private TableView<Technician> tabel;

    @FXML
    private Button updateBtt;

    private ObservableList<Technician> observableTechnicianList;

    private Stage dialogStage;

    @FXML
    void deleteBttAction(ActionEvent event) {

        Technician tecnico = tabel.getSelectionModel().getSelectedItem();

        if(tecnico== null){
            labelError.setText("Selecione um técnico");
        }else{

            DAO.getTechnician().delete(tecnico.getId());
            observableTechnicianList.remove(tecnico);
            labelAceppt.setText("Técnico removido com sucesso");
        }

    }

    @FXML
    void saveBtnAction(ActionEvent event) {

        if(nameBox.getText().isEmpty() || emailBox.getText().isEmpty() || passwordBox.getText().isEmpty() ){

            labelError.setText("ERRO, campos preenchidos incorretamente!");
        }else{

            Technician newTechnician = new Technician(nameBox.getText(),emailBox.getText(), passwordBox.getText());

            DAO.getTechnician().create(newTechnician);

           observableTechnicianList.add(newTechnician);

            labelAceppt.setText("Técnico registrado com sucesso!");

            nameBox.clear();
            emailBox.clear();
            passwordBox.clear();
        }

    }

    @FXML
    void searchBttAction(ActionEvent event) {

        if(!(searchBox.getText().isEmpty())){

            try {
                observableTechnicianList.setAll(DAO.getTechnician().FindById(Integer.parseInt(searchBox.getText())));

            }catch (NumberFormatException e){

                labelError.setText("Digite um número inteiro!");
            }
        }else{
            observableTechnicianList.setAll(DAO.getTechnician().FindMany());
        }

    }

    @FXML
    void updateBttAction(ActionEvent event) {

        Technician tecnico = tabel.getSelectionModel().getSelectedItem();
        if(tecnico == null){
            labelError.setText("Selecione um técnico");
        }else{

            if(nameBox.getText().isEmpty() || emailBox.getText().isEmpty() || passwordBox.getText().isEmpty() ){

                labelError.setText("ERRO, campos preenchidos incorretamente!");
            }else{

                tecnico.setName(nameBox.getText());
                tecnico.setEmail(emailBox.getText());
                tecnico.setPassword(passwordBox.getText());

                DAO.getTechnician().update(tecnico);

                observableTechnicianList.set(tabel.getSelectionModel().getSelectedIndex(), tecnico);

                labelAceppt.setText("Técnico atualizado com sucesso!");

                nameBox.clear();
                emailBox.clear();
                passwordBox.clear();
            }
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
