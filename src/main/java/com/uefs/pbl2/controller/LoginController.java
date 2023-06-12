package com.uefs.pbl2.controller;

import com.uefs.pbl2.HelloApplication;
import com.uefs.pbl2.controller.usersController.*;
import com.uefs.pbl2.controller.usersController.TechnicianController;
import com.uefs.pbl2.dao.DAO;
import com.uefs.pbl2.model.users.Administrator;
import com.uefs.pbl2.model.users.Recepcionist;
import com.uefs.pbl2.model.users.Technician;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.uefs.pbl2.controller.StageController;
import javafx.stage.Stage;

import java.io.IOException;

import static com.uefs.pbl2.controller.StageController.getStage;

public class LoginController {

    @FXML
    private Label errorLabel;

    @FXML
    private ComboBox comboBOX;

    @FXML
    private Button enterBTT;

    @FXML
    private TextField idBOX;

    @FXML
    private TextField passwordBOX;

    @FXML
    void enterBTTAction(ActionEvent event) {

        if(idBOX.getText().isEmpty() || passwordBOX.getText().isEmpty() ||
                comboBOX.getSelectionModel().getSelectedItem().toString().isEmpty()){

            errorLabel.setText("ERRO, campos preenchidos incorretamente!");
        }else{

            String s = comboBOX.getSelectionModel().getSelectedItem().toString();

            if(s.equals("Administrador")){

                for(Administrator a: DAO.getAdministrator().FindMany()){
                    try {
                        if (a.getId() == Integer.parseInt(idBOX.getText())&&
                                a.getPassword().equals(passwordBOX.getText()))  {

                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("users" +
                                    "Views/" +
                                    "administrator2-view.fxml"));

                            Scene scene = new Scene(fxmlLoader.load());

                            Stage stage = getStage(event);

                            stage.setScene(scene);
                            stage.centerOnScreen();

                            AdministratorController administratorController = fxmlLoader.getController();
                            administratorController.setDialogStage(stage);
                            administratorController.setAdministrator(a);

                        }else{
                            errorLabel.setText("Id ou senha incorreto(s)!");
                        }
                    }catch (NumberFormatException e){

                        errorLabel.setText("ERRO, campos preenchidos incorretamente!");

                    } catch (IOException e) {
                        errorLabel.setText("Erro ao tentar abrir outra tela");

                    }

                }

            }
            else if(s.equals("Técnico")){

                for(Technician t: DAO.getTechnician().FindMany()){
                    try {
                        if (t.getId() == Integer.parseInt(idBOX.getText()) &&
                                t.getPassword().equals(passwordBOX.getText())) {

                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("users" +
                                    "Views/" +
                                    "technician-tela.fxml"));
                            Scene scene = new Scene(fxmlLoader.load());

                            Stage stage = getStage(event);

                            stage.setScene(scene);
                            stage.centerOnScreen();

                            TechnicianController technicianController = fxmlLoader.getController();
                            technicianController.setDialogStage(stage);
                            technicianController.setTechnician(t);


                        }else{
                            errorLabel.setText("Id ou senha incorreto(s)!");
                        }
                    }catch (NumberFormatException e){

                        errorLabel.setText("ERRO, campos preenchidos incorretamente!");

                    } catch (IOException e) {
                        System.out.println(e);
                        errorLabel.setText("Erro ao tentar abrir outra tela");


                    }

                }

            }else if(s.equals("Recepconista")){

                for(Recepcionist r: DAO.getRecepcionist().FindMany()){
                    try {
                        if (r.getId() == Integer.parseInt(idBOX.getText()) &&
                                r.getPassword().equals(passwordBOX.getText())) {

                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("users" +
                                    "Views/" +
                                    "recepcionist2-view.fxml"));
                            Scene scene = new Scene(fxmlLoader.load());
                            Stage stage = getStage(event);

                            stage.setScene(scene);
                            stage.centerOnScreen();

                            RecepcionistController recepcionistController = fxmlLoader.getController();
                            recepcionistController.setDialogStage(stage);
                            recepcionistController.setRecepcionist(r);

                        }
                        else{
                            errorLabel.setText("Id ou senha incorreto(s)!");
                        }
                    }catch (NumberFormatException e){

                        errorLabel.setText("ERRO, campos preenchidos incorretamente!");

                    } catch (IOException e) {
                        errorLabel.setText("Erro ao tentar abrir outra tela");

                    }

                }

            }


        }

    }

    @FXML
    void initialize() {


        ObservableList<String> list = FXCollections.observableArrayList("Administrador","Técnico","Recepconista");
        comboBOX.setItems(list);
    }

}
