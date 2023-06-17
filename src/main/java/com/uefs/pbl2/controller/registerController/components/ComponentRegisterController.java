package com.uefs.pbl2.controller.registerController.components;

import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.components.Component;
import com.uefs.pbl2.model.components.ComputerComponent;
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

public class ComponentRegisterController {

    @FXML
    private TextField costBOX;

    @FXML
    private TableColumn<ComputerComponent, Double> costColumn;

    @FXML
    private Button deleteBtt;

    @FXML
    private TableColumn<ComputerComponent, Integer> idColumn;

    @FXML
    private Label labelAceppt;

    @FXML
    private Label labelError;

    @FXML
    private Label labelError1;

    @FXML
    private TableColumn<ComputerComponent, String> manefacturedColumn;

    @FXML
    private TextField manufacturedBox;

    @FXML
    private TextField nameBox;

    @FXML
    private TableColumn<ComputerComponent, String> nameColumn;

    @FXML
    private TextField priceBox;

    @FXML
    private TableColumn<ComputerComponent, Double> priceColumn;

    @FXML
    private TextField quantityBOX;

    @FXML
    private TableColumn<ComputerComponent, Integer> quantityColumn;

    @FXML
    private Button saveBtn;

    @FXML
    private TextField searchBox;

    @FXML
    private Button searchBtt;

    @FXML
    private Button searchEBtt;

    @FXML
    private TableView<Component> tabel;

    @FXML
    private Button updateBtt;

    private Stage dialogStage;

    private ObservableList<Component> observableComputerComponentList;

    @FXML
    void deleteBttAction(ActionEvent event) {

        ComputerComponent componente = (ComputerComponent)(tabel.getSelectionModel().getSelectedItem());

        if(componente == null){
            labelError.setText("Selecione um componente");
        }else{

            DAO.getComponent().delete(componente.getId());
            observableComputerComponentList.remove(componente);
            labelAceppt.setText("Componente removido com sucesso");
        }

    }

    @FXML
    void saveBtnAction(ActionEvent event) {

        if(nameBox.getText().isEmpty() || manufacturedBox.getText().isEmpty() ||priceBox.getText().isEmpty()
                || priceBox.getText().isEmpty() || quantityBOX.getText().isEmpty() ){

            labelError.setText("ERRO, campos preenchidos incorretamente!");
        }else{

            ComputerComponent newComponent = new ComputerComponent( Double.parseDouble(priceBox.getText()),
                    Double.parseDouble(costBOX.getText()),Integer.parseInt(quantityBOX.getText()),
                    nameBox.getText(), manufacturedBox.getText());

            DAO.getComponent().create(newComponent);

            observableComputerComponentList.add(newComponent);

            labelAceppt.setText("Componente registrado com sucesso!");

            nameBox.clear();
            manufacturedBox.clear();
            priceBox.clear();
            costBOX.clear();
            quantityBOX.clear();

        }

    }

    @FXML
    void searchBttAction(ActionEvent event) {

        if(!(searchBox.getText().isEmpty())){

            try {
                observableComputerComponentList.setAll(DAO.getComponent().FindById(Integer.parseInt(searchBox.getText()
                )));
                labelError.setText("");
            }catch (NumberFormatException e){

                labelError.setText("Digite um número inteiro!");
            }
        }else{
            observableComputerComponentList.setAll(DAO.getComponent().FindMany());
        }

    }

    @FXML
    void updateBttAction(ActionEvent event) {

        ComputerComponent componente = (ComputerComponent)(tabel.getSelectionModel().getSelectedItem());
        if(componente == null){
            labelError.setText("Selecione um componente");
        }else{

            if(nameBox.getText().isEmpty() || manufacturedBox.getText().isEmpty() ||priceBox.getText().isEmpty()
                    || priceBox.getText().isEmpty() || quantityBOX.getText().isEmpty() ){

                labelError.setText("ERRO, campos preenchidos incorretamente!");
            }else{

                componente.setName(nameBox.getText());
                componente.setManufacturer(manufacturedBox.getText());
                componente.setPrice(Double.parseDouble(priceBox.getText()));
                componente.setCost(Double.parseDouble(costBOX.getText()));
                componente.setQuantity(Integer.parseInt(quantityBOX.getText()));

                DAO.getComponent().update(componente);

                observableComputerComponentList.set(tabel.getSelectionModel().getSelectedIndex(), componente);

                labelAceppt.setText("Componente atualizado com sucesso!");

                nameBox.clear();
                manufacturedBox.clear();
                priceBox.clear();
                costBOX.clear();
                quantityBOX.clear();
            }
        }

    }

    @FXML
    void initialize() {

        observableComputerComponentList = FXCollections.observableArrayList(DAO.getComponent().FindMany());

        idColumn.setCellValueFactory(new PropertyValueFactory<ComputerComponent,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<ComputerComponent,String>("name"));
        manefacturedColumn.setCellValueFactory(new PropertyValueFactory<ComputerComponent,String>("manefactured"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<ComputerComponent,Double>("price"));
        costColumn.setCellValueFactory(new PropertyValueFactory<ComputerComponent,Double>("cost"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<ComputerComponent,Integer>("quantity"));


        tabel.setItems(observableComputerComponentList);

    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }


}


