package com.uefs.pbl2.controller.registerController.services;

import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.services.Cleaning;
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

public class cleaningRegisterController {

    @FXML
    private TextField costBOX;

    @FXML
    private TableColumn<Cleaning, Double> costColumn;

    @FXML
    private Button deleteBtt;

    @FXML
    private TableColumn<Cleaning, Integer> idColumn;

    @FXML
    private Label labelAceppt;

    @FXML
    private Label labelError;

    @FXML
    private Label labelError1;

    @FXML
    private TextField nameBox;

    @FXML
    private TableColumn<Cleaning, String> nameColumn;

    @FXML
    private TextField priceBox;

    @FXML
    private TableColumn<Cleaning, Double> priceColumn;

    @FXML
    private Button saveBtn;

    @FXML
    private TextField searchBox;

    @FXML
    private Button searchBtt;

    @FXML
    private Button searchEBtt;

    @FXML
    private TableView<Cleaning> tabel;

    @FXML
    private Button updateBtt;

    private ObservableList<Cleaning> observableCleaningList;

    @FXML
    void deleteBttAction(ActionEvent event) {

        Cleaning limpezaServico = tabel.getSelectionModel().getSelectedItem();

        if(limpezaServico == null){
            labelError.setText("Selecione um serviço de limpeza");
        }else{

            DAO.getCleaning().delete(limpezaServico.getId());
            observableCleaningList.remove(limpezaServico);
            labelAceppt.setText("Serviço de limpeza removido com sucesso");
        }

    }

    @FXML
    void saveBtnAction(ActionEvent event) {

        if(nameBox.getText().isEmpty() || priceBox.getText().isEmpty() || costBOX.getText().isEmpty() ){

            labelError.setText("ERRO, campos preenchidos incorretamente!");

        }else{

            try {

                Cleaning newCleaning = new Cleaning(Double.parseDouble(priceBox.getText()),
                        Double.parseDouble(costBOX.getText()), nameBox.getText());


                DAO.getCleaning().create(newCleaning);

                observableCleaningList.add(newCleaning);

                labelAceppt.setText("Serviço de limpeza registrado com sucesso!");

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
                observableCleaningList.setAll(DAO.getCleaning().FindById(Integer.parseInt(searchBox.getText())));

            }catch (NumberFormatException e){

                labelError.setText("Digite um número inteiro!");
            }
        }else{
            observableCleaningList.setAll(DAO.getCleaning().FindMany());
        }

    }


    @FXML
    void searchBttEAction(ActionEvent event) {

    }

    @FXML
    void updateBttAction(ActionEvent event) {

        Cleaning limpezaSevico = tabel.getSelectionModel().getSelectedItem();
        if(limpezaSevico == null){
            labelError.setText("Selecione um serviço de limpeza");
        }else{

            if(nameBox.getText().isEmpty() || priceBox.getText().isEmpty() || costBOX.getText().isEmpty() ){

                labelError.setText("ERRO, campos preenchidos incorretamente!");
            }else{

                try {
                    limpezaSevico.setCleaningName(nameBox.getText());
                    limpezaSevico.setPrice(Double.parseDouble(priceBox.getText()));
                    limpezaSevico.setCost(Double.parseDouble(costBOX.getText()));

                    DAO.getCleaning().update(limpezaSevico);

                    observableCleaningList.set(tabel.getSelectionModel().getSelectedIndex(), limpezaSevico);

                    labelAceppt.setText("Serviço de limpeza atualizado com sucesso!");

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

        observableCleaningList = FXCollections.observableArrayList(DAO.getCleaning().FindMany());

        idColumn.setCellValueFactory(new PropertyValueFactory<Cleaning,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Cleaning,String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Cleaning,Double>("price"));
        costColumn.setCellValueFactory(new PropertyValueFactory<Cleaning,Double>("cost"));


        tabel.setItems(observableCleaningList);

    }

}
