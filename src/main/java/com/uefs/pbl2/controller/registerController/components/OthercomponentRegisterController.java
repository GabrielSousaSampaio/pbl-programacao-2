package com.uefs.pbl2.controller.registerController.components;

import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.components.Component;
import com.uefs.pbl2.model.components.ComputerComponent;
import com.uefs.pbl2.model.components.OtherComponent;
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

import java.util.ArrayList;
import java.util.List;

public class OthercomponentRegisterController {

    List<OtherComponent> otherComponentList = new ArrayList<OtherComponent>();

    @FXML
    private TextField costBOX;

    @FXML
    private TableColumn<OtherComponent, Double> costColumn;

    @FXML
    private Button deleteBtt;

    @FXML
    private TextField descriptionBox;

    @FXML
    private TableColumn<OtherComponent, String> descriptionColumn;

    @FXML
    private TableColumn<OtherComponent, Integer> idColumn;

    @FXML
    private Label labelAceppt;

    @FXML
    private Label labelError;

    @FXML
    private Label labelError1;

    @FXML
    private TextField priceBox;

    @FXML
    private TableColumn<OtherComponent, Double> priceColumn;

    @FXML
    private TextField quantityBOX;

    @FXML
    private TableColumn<OtherComponent, Integer> quantityColumn;

    @FXML
    private Button saveBtn;

    @FXML
    private TextField searchBox;

    @FXML
    private Button searchBtt;

    @FXML
    private Button searchEBtt;

    @FXML
    private TableView<OtherComponent> tabel;

    @FXML
    private Button updateBtt;

    private Stage dialogStage;

    private ObservableList<OtherComponent> observableOtherComponentList;

    @FXML
    void deleteBttAction(ActionEvent event) {

        OtherComponent componente = (OtherComponent) tabel.getSelectionModel().getSelectedItem();

        if(componente == null){
            labelError.setText("Selecione um componente");
        }else{

            DAO.getComponent().delete(componente.getId());
            observableOtherComponentList.remove(componente);
            labelAceppt.setText("Componente removido com sucesso");
        }

    }

    @FXML
    void saveBtnAction(ActionEvent event) {

        if(descriptionBox.getText().isEmpty() ||priceBox.getText().isEmpty()
                || priceBox.getText().isEmpty() || quantityBOX.getText().isEmpty()){

            labelError.setText("ERRO, campos preenchidos incorretamente!");
        }else{

            OtherComponent newComponent = new OtherComponent( Double.parseDouble(priceBox.getText()),
                    Double.parseDouble(costBOX.getText()),Integer.parseInt(quantityBOX.getText()), descriptionBox.getText());

            DAO.getComponent().create(newComponent);

            observableOtherComponentList.add(newComponent);

            labelAceppt.setText("Componente registrado com sucesso!");

            descriptionBox.clear();
            priceBox.clear();
            costBOX.clear();
            quantityBOX.clear();

        }

    }

    @FXML
    void searchBttAction(ActionEvent event) {

        if(!(searchBox.getText().isEmpty())){

            try {
                List<OtherComponent > oClist = new ArrayList<OtherComponent >();
                for(OtherComponent otherComponent: otherComponentList){
                    if(otherComponent.getId() == Integer.parseInt(searchBox.getText())){
                        oClist.add(otherComponent);
                    }
                }


                observableOtherComponentList.setAll(oClist);

            }catch (NumberFormatException e){
                labelError.setStyle("-fx-text-fill:#f70505");
                labelError.setText("Digite um número inteiro!");
            }
        }else{
            observableOtherComponentList.setAll(otherComponentList);
        }


    }

    @FXML
    void searchBttEAction(ActionEvent event) {

    }

    @FXML
    void updateBttAction(ActionEvent event) {

        OtherComponent componente = (OtherComponent) tabel.getSelectionModel().getSelectedItem();

        if(componente == null){
            labelError.setText("Selecione um componente");
        }else{

            if(descriptionBox.getText().isEmpty() ||priceBox.getText().isEmpty()
                    || priceBox.getText().isEmpty() || quantityBOX.getText().isEmpty() ){

                labelError.setText("ERRO, campos preenchidos incorretamente!");
            }else{

                componente.setDescription(descriptionBox.getText());
                componente.setPrice(Double.parseDouble(priceBox.getText()));
                componente.setCost(Double.parseDouble(priceBox.getText()));
                componente.setQuantity(Integer.parseInt(quantityBOX.getText()));

                DAO.getComponent().update(componente);

                observableOtherComponentList.set(tabel.getSelectionModel().getSelectedIndex(), componente);

                labelAceppt.setText("Componente atualizado com sucesso!");

                descriptionBox.clear();
                priceBox.clear();
                costBOX.clear();
                quantityBOX.clear();
            }
        }

    }

    @FXML
    void initialize() {

        for(Component c: DAO.getComponent().FindMany()){

            if(c instanceof OtherComponent){
                otherComponentList.add((OtherComponent) c);
            }
        }

        observableOtherComponentList = FXCollections.observableArrayList(otherComponentList);

        idColumn.setCellValueFactory(new PropertyValueFactory<OtherComponent,Integer>("id"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<OtherComponent, String>("description"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<OtherComponent,Double>("price"));
        costColumn.setCellValueFactory(new PropertyValueFactory<OtherComponent,Double>("cost"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<OtherComponent,Integer>("quantity"));


        tabel.setItems(observableOtherComponentList);

    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }
}
