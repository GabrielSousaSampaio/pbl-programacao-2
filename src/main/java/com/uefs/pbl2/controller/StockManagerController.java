package com.uefs.pbl2.controller;

import com.uefs.pbl2.HelloApplication;
import com.uefs.pbl2.controller.registerController.components.ComponentRegisterController;
import com.uefs.pbl2.controller.registerController.components.OthercomponentRegisterController;
import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.components.Component;
import com.uefs.pbl2.model.components.ComputerComponent;
import com.uefs.pbl2.model.components.ComputerComponent;
import com.uefs.pbl2.model.components.OtherComponent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockManagerController {

    List<ComputerComponent> computerComponentsList = new ArrayList<ComputerComponent>();
    List<OtherComponent> otherComponentList = new ArrayList<OtherComponent>();

    @FXML
    private Label CCmsgLabel;

    @FXML
    private Label OCmsgLabel;

    @FXML
    private TableColumn<ComputerComponent, Double> costCCColumn;

    @FXML
    private TableColumn<OtherComponent, Double> costOCColumn;

    @FXML
    private TableColumn<OtherComponent, String> descriptionOCColumn;

    @FXML
    private Button homeBTT;

    @FXML
    private TableColumn<ComputerComponent, Integer> idCCColumn;

    @FXML
    private TableColumn<OtherComponent, Integer> idOCColumn;

    @FXML
    private Label labelError1;

    @FXML
    private TableColumn<ComputerComponent, String> manefacturedCCColumn;

    @FXML
    private TableColumn<ComputerComponent, String> nameCCColumn;

    @FXML
    private TableColumn<ComputerComponent, Double> priceCCColumn;

    @FXML
    private TableColumn<OtherComponent, Double> priceOCColumn;

    @FXML
    private TableColumn<ComputerComponent, Integer> quantityCCColumn;

    @FXML
    private TableColumn<OtherComponent, Integer> quantityOCColumn;

    @FXML
    private TextField searchCCBox;

    @FXML
    private Button searchCCBtt;

    @FXML
    private Button createCCBTT;

    @FXML
    private TextField searchOCBox;

    @FXML
    private Button searchOCBtt;

    @FXML
    private Button createOCBTT;

    @FXML
    private TableView<ComputerComponent> tableComputerComponent;

    @FXML
    private TableView<OtherComponent> tableOtherComponents;

    private ObservableList<ComputerComponent> computerComponentObservableList;

    private ObservableList<OtherComponent> otherComponentObservableList;

    private Stage dialogStage;

    @FXML
    void homeBTTAction(ActionEvent event) {

        dialogStage.close();

    }

    @FXML
    void searchCCBttAction(ActionEvent event) {

        if(!(searchCCBox.getText().isEmpty())){

            try {

                List<ComputerComponent> cClist = new ArrayList<ComputerComponent>();

                for(ComputerComponent computerComponent: computerComponentsList){
                    if(Integer.parseInt(searchOCBox.getText()) == computerComponent.getId()) {
                        cClist.add((ComputerComponent) computerComponent);
                    }
                }

                computerComponentObservableList.setAll(cClist);

            }catch (NumberFormatException e){
                CCmsgLabel.setStyle("-fx-text-fill:#f70505");
                CCmsgLabel.setText("Digite um número inteiro!");
            }
        }else{
            computerComponentObservableList.setAll(computerComponentsList);
        }



    }

    @FXML
    void createCCBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registerViews/" +
                    "componentRegister-view2.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registrar componente de computador");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            ComponentRegisterController componentRegisterController = fxmlLoader.getController();
            componentRegisterController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void searchIOCBttAction(ActionEvent event) {

        if(!(searchOCBox.getText().isEmpty())){

            try {
                List<OtherComponent > oClist = new ArrayList<OtherComponent >();
                for(OtherComponent otherComponent: otherComponentList){
                    if(otherComponent.getId() == Integer.parseInt(searchOCBox.getText())){
                        oClist.add(otherComponent);
                    }
                }

                otherComponentObservableList.setAll(oClist);

            }catch (NumberFormatException e){
                CCmsgLabel.setStyle("-fx-text-fill:#f70505");
                CCmsgLabel.setText("Digite um número inteiro!");
            }
        }else{
            otherComponentObservableList.setAll(otherComponentList);
        }

    }

    @FXML
    void createOCBTTAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(
                    "registerViews/otherComponentRegister-view2.fxml"));

            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Registrar outro componente");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.initModality(Modality.APPLICATION_MODAL);

            OthercomponentRegisterController othercomponentRegisterController = fxmlLoader.getController();
            othercomponentRegisterController.setDialogStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void initialize() {

        for(Component c: DAO.getComponent().FindMany()){

            if(c instanceof ComputerComponent){
                computerComponentsList.add((ComputerComponent) c);
            }else if(c instanceof OtherComponent){
                otherComponentList.add((OtherComponent) c);
            }
        }

        otherComponentObservableList = FXCollections.observableArrayList(otherComponentList);
        computerComponentObservableList = FXCollections.observableArrayList(computerComponentsList);

        idCCColumn.setCellValueFactory(new PropertyValueFactory<ComputerComponent,Integer>("id"));
        nameCCColumn.setCellValueFactory(new PropertyValueFactory<ComputerComponent,String>("name"));
        manefacturedCCColumn.setCellValueFactory(new PropertyValueFactory<ComputerComponent,String>("manufacturer"));
        priceCCColumn.setCellValueFactory(new PropertyValueFactory<ComputerComponent,Double>("price"));
        costCCColumn.setCellValueFactory(new PropertyValueFactory<ComputerComponent,Double>("cost"));
        quantityCCColumn.setCellValueFactory(new PropertyValueFactory<ComputerComponent,Integer>("quantity"));

        idOCColumn.setCellValueFactory(new PropertyValueFactory<OtherComponent,Integer>("id"));
        descriptionOCColumn.setCellValueFactory(new PropertyValueFactory<OtherComponent, String>("description"));
        priceOCColumn.setCellValueFactory(new PropertyValueFactory<OtherComponent,Double>("price"));
        costOCColumn.setCellValueFactory(new PropertyValueFactory<OtherComponent,Double>("cost"));
        quantityOCColumn.setCellValueFactory(new PropertyValueFactory<OtherComponent,Integer>("quantity"));



        tableComputerComponent.setItems(computerComponentObservableList);
        tableOtherComponents.setItems(otherComponentObservableList);

    }

    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
