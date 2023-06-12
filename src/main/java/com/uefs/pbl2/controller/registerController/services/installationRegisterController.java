package com.uefs.pbl2.controller.registerController.services;

import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.services.Installation;
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

public class installationRegisterController {

    @FXML
    private TextField costBOX;

    @FXML
    private TableColumn<Installation, Double> costColumn;

    @FXML
    private Button deleteBtt;

    @FXML
    private TableColumn<Installation, Integer> idColumn;

    @FXML
    private Label labelAceppt;

    @FXML
    private Label labelError;

    @FXML
    private Label labelError1;

    @FXML
    private TextField nameBox;

    @FXML
    private TableColumn<Installation, String> nameColumn;

    @FXML
    private TextField priceBox;

    @FXML
    private TableColumn<Installation, Double> priceColumn;

    @FXML
    private Button saveBtn;

    @FXML
    private TextField searchBox;

    @FXML
    private Button searchBtt;

    @FXML
    private Button searchEBtt;

    @FXML
    private TableView<Installation> tabel;

    @FXML
    private Button updateBtt;

    private ObservableList<Installation> observableInstallationList;

    @FXML
    void deleteBttAction(ActionEvent event) {

        Installation instalacaoServico = tabel.getSelectionModel().getSelectedItem();

        if(instalacaoServico == null){
            labelError.setText("Selecione um serviço de instalação");
        }else{

            DAO.getInstallation().delete(instalacaoServico.getId());
            observableInstallationList.remove(instalacaoServico);
            labelAceppt.setText("Serviço de instalação removido com sucesso");
        }

    }

    @FXML
    void saveBtnAction(ActionEvent event) {

        if(nameBox.getText().isEmpty() || priceBox.getText().isEmpty() || priceBox.getText().isEmpty() ){

            labelError.setText("ERRO, campos preenchidos incorretamente!");
        }else{

            try {
                Installation newInstallation = new Installation(Double.parseDouble(priceBox.getText()),
                        Double.parseDouble(costBOX.getText()), nameBox.getText());

                DAO.getInstallation().create(newInstallation);

                observableInstallationList.add(newInstallation);

                labelAceppt.setText("Serviço de instalação registrado com sucesso!");

                nameBox.clear();
                priceBox.clear();
                costBOX.clear();
            }catch (NumberFormatException e){

                labelError.setText("ERRO, campos preenchidos incorretamente!");
            }
        }

    }

    @FXML
    void searchBttAction(ActionEvent event) {

        if(!(searchBox.getText().isEmpty())){

            try {
                observableInstallationList.setAll(DAO.getInstallation().FindById(Integer.parseInt(searchBox.getText())));

            }catch (NumberFormatException e){

                labelError.setText("Digite um número inteiro!");
            }
        }else{
            observableInstallationList.setAll(DAO.getInstallation().FindMany());
        }

    }

    @FXML
    void searchBttEAction(ActionEvent event) {

    }

    @FXML
    void updateBttAction(ActionEvent event) {

        Installation instalacaoSevico = tabel.getSelectionModel().getSelectedItem();
        if(instalacaoSevico == null){
            labelError.setText("Selecione um serviço de instalação");
        }else{

            if(nameBox.getText().isEmpty() || priceBox.getText().isEmpty() || costBOX.getText().isEmpty() ){

                labelError.setText("ERRO, campos preenchidos incorretamente!");
            }else{
                try {
                    instalacaoSevico.setInstallationName(nameBox.getText());
                    instalacaoSevico.setPrice(Double.parseDouble(priceBox.getText()));
                    instalacaoSevico.setCost(Double.parseDouble(costBOX.getText()));

                    DAO.getInstallation().update(instalacaoSevico);

                    observableInstallationList.set(tabel.getSelectionModel().getSelectedIndex(), instalacaoSevico);

                    labelAceppt.setText("Serviço de instalação atualizado com sucesso!");

                    nameBox.clear();
                    priceBox.clear();
                    costBOX.clear();
                }catch (NumberFormatException e){

                    labelError.setText("ERRO, campos preenchidos incorretamente!");
                }

            }
        }

    }

    @FXML
    void initialize() {

        observableInstallationList = FXCollections.observableArrayList(DAO.getInstallation().FindMany());

        idColumn.setCellValueFactory(new PropertyValueFactory<Installation,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Installation,String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Installation,Double>("price"));
        costColumn.setCellValueFactory(new PropertyValueFactory<Installation,Double>("cost"));


        tabel.setItems(observableInstallationList);

    }

}
