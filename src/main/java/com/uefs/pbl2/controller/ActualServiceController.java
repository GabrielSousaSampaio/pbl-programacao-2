package com.uefs.pbl2.controller;

import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.WorkOrder;
import com.uefs.pbl2.model.components.Component;
import com.uefs.pbl2.model.components.ComputerComponent;
import com.uefs.pbl2.model.components.OtherComponent;
import com.uefs.pbl2.model.services.Building;
import com.uefs.pbl2.model.services.Cleaning;
import com.uefs.pbl2.model.services.Installation;
import com.uefs.pbl2.model.services.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ActualServiceController {


    private WorkOrder workOrder;

    List<ComputerComponent> computerComponentsList = new ArrayList<ComputerComponent>();

    List<OtherComponent> otherComponentList = new ArrayList<OtherComponent>();

    @FXML
    private Label clienteBOX;

    @FXML
    private TableColumn<ComputerComponent, Double> costCCColumn;

    @FXML
    private TableColumn<Cleaning, Double> costCSColumn;

    @FXML
    private TableColumn<Installation, Double> costISColumn;

    @FXML
    private TableColumn<OtherComponent, Double> costOCColumn;

    @FXML
    private TableColumn<OtherComponent, String> descriptionOCColumn;

    @FXML
    private Button homeBTT;

    @FXML
    private TableColumn<ComputerComponent, Integer> idCCColumn;

    @FXML
    private TableColumn<Cleaning, Integer> idCSColumn;

    @FXML
    private TableColumn<Installation, Integer> idISColumn;

    @FXML
    private TableColumn<OtherComponent, Integer> idOCColumn;

    @FXML
    private Button removeServiceBTT;

    @FXML
    private Button removeComponentBTT;

    @FXML
    private TableColumn<ComputerComponent, String> manefacturedCCColumn;

    @FXML
    private Label msgLabel;

    @FXML
    private VBox msgLabel1;

    @FXML
    private Button cancelServiceBTT;

    @FXML
    private Button finshServiceBTT;

    @FXML
    private VBox msgLabel11;

    @FXML
    private TableColumn<ComputerComponent, String> nameCCColumn;

    @FXML
    private TableColumn<Cleaning, String> nameCSColumn;

    @FXML
    private TableColumn<Installation, String> nameISColumn;

    @FXML
    private TableColumn<ComputerComponent, Double> priceCCColumn;

    @FXML
    private TableColumn<Cleaning, Double> priceCSColumn;

    @FXML
    private TableColumn<Installation, Double> priceISColumn;

    @FXML
    private TableColumn<OtherComponent, Double> priceOCColumn;

    @FXML
    private TableColumn<ComputerComponent, Integer> quantityCCColumn;

    @FXML
    private TableColumn<OtherComponent, Integer> quantityOCColumn;

    @FXML
    private TableView<Cleaning> tableCleaningService;

    @FXML
    private TableView<ComputerComponent> tableComputerComponent;

    @FXML
    private TableView<Installation> tableInstallationService;

    @FXML
    private TableView<OtherComponent> tableOtherComponents;

    @FXML
    private Label workOrderIDBOX;

    private ObservableList<ComputerComponent> computerComponentObservableList;

    private ObservableList<OtherComponent> otherComponentObservableList;

    private ObservableList<Cleaning> cleaningObservableList;

    private ObservableList<Installation> installationObservableList;

    private Stage dialogStage;

    @FXML
    void homeBTTAction(ActionEvent event) {
        dialogStage.close();

    }
    @FXML
    void cancelServiceBTTAction(ActionEvent event){

    }
    @FXML
    void finshServiceBTTAction(ActionEvent event){



    }

    @FXML
    void removeServiceBTTAction(ActionEvent event) {

        Cleaning cleaning = tableCleaningService.getSelectionModel().getSelectedItem();
        Installation installation = tableInstallationService.getSelectionModel().getSelectedItem();

        if(cleaning == null && installation == null){
            this.msgLabel.setStyle("-fx-text-fill:#f70505");
            msgLabel.setText("Selecione um componente");
        }else{
            if(cleaning == null){
                workOrder.getServicelist().remove(installation);
            }else{
                workOrder.getServicelist().remove(cleaning);
            }
        }
        DAO.getWorkOrder().update(workOrder);

    }

    @FXML
    void removeComponentBTTAction(ActionEvent event) {

        OtherComponent otherComponent = tableOtherComponents.getSelectionModel().getSelectedItem();
        ComputerComponent computerComponent = tableComputerComponent.getSelectionModel().getSelectedItem();


        if(otherComponent == null && computerComponent == null){
            this.msgLabel.setStyle("-fx-text-fill:#f70505");
            msgLabel.setText("Selecione um componente");
        }else{
            if(otherComponent == null){
                workOrder.getBuilding().removeComponent(computerComponent);
            }
            else{
                workOrder.getBuilding().removeComponent(otherComponent);
            }
        }
        DAO.getWorkOrder().update(workOrder);


    }

    @FXML
    void initialize(ActionEvent event) {

        List<Installation> installations = new ArrayList<Installation>();
        List<Cleaning> cleanings = new ArrayList<Cleaning>();
        List<ComputerComponent> computerComponents = new ArrayList<ComputerComponent>();
        List<OtherComponent> otherComponents = new ArrayList<OtherComponent>();

        for(Service s: workOrder.getServicelist()){

            if(s instanceof Cleaning){

                cleanings.add((Cleaning) s);
            }else if(s instanceof Installation){

                installations.add((Installation) s);

            }else if(s instanceof Building){
               for(Component c: ((Building) s).getUsedComponents()){
                   if(c instanceof ComputerComponent){
                       computerComponents.add((ComputerComponent) c);
                   }else{
                       otherComponents.add((OtherComponent) c);
                   }
               }
            }
        }

        otherComponentObservableList = FXCollections.observableArrayList(otherComponents);
        computerComponentObservableList = FXCollections.observableArrayList(computerComponents);
        installationObservableList = FXCollections.observableArrayList(installations);
        cleaningObservableList = FXCollections.observableArrayList(cleanings);

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

        idISColumn.setCellValueFactory(new PropertyValueFactory<Installation,Integer>("id"));
        nameISColumn.setCellValueFactory(new PropertyValueFactory<Installation,String>("installationName"));
        priceISColumn.setCellValueFactory(new PropertyValueFactory<Installation,Double>("price"));
        costISColumn.setCellValueFactory(new PropertyValueFactory<Installation,Double>("cost"));

        idCSColumn.setCellValueFactory(new PropertyValueFactory<Cleaning,Integer>("id"));
        nameCSColumn.setCellValueFactory(new PropertyValueFactory<Cleaning,String>("cleaningName"));
        priceCSColumn.setCellValueFactory(new PropertyValueFactory<Cleaning,Double>("price"));
        costCSColumn.setCellValueFactory(new PropertyValueFactory<Cleaning,Double>("cost"));

        tableInstallationService.setItems(installationObservableList);
        tableCleaningService.setItems(cleaningObservableList);

        tableComputerComponent.setItems(computerComponentObservableList);
        tableOtherComponents.setItems(otherComponentObservableList);

    }
    public void setWorkOrder(WorkOrder workOrderobj){
        this.clienteBOX.setText(workOrderobj.getCustomer().getName());
        this.workOrderIDBOX.setText(Integer.toString(workOrderobj.getId()));
        this.workOrder = workOrderobj;

    }
    public void setDialogStage(Stage stage){

        this.dialogStage = stage;

    }

}
