package com.uefs.pblprogramacao2.controller;


import com.uefs.pblprogramacao2.Main;
import com.uefs.pblprogramacao2.dao.DAO;
import com.uefs.pblprogramacao2.model.users.Administrator;
import com.uefs.pblprogramacao2.model.users.Recepcionist;
import com.uefs.pblprogramacao2.model.users.Technician;
import com.uefs.pblprogramacao2.model.users.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class LoginController implements Initializable {

    private User user;

    private String[] usersTypeList = {"Administrador","Técnico", "Recepcionista"};

    @FXML
    private Label errorLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ChoiceBox<String> choiseUserType;

    @FXML
    private Button loginButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiseUserType.setValue("Administrador");
        choiseUserType.getItems().addAll(usersTypeList);
    }

    @FXML
    private void onLoginButtonClick() {
        try {
            if (choiseUserType.getValue() == "Administrador") {
                user = DAO.getAdministrator().FindById(Integer.parseInt(idTextField.getText()));
                if (user.getPassword().equals(passwordField.getText())) {
                    clearAll();
                    Main.changeView("adminMenuScene");
                } else {
                    throw new Exception();
                }
            } else if (choiseUserType.getValue() == "Técnico") {
                user = DAO.getTechnician().FindById(parseInt(idTextField.getText()));
                if ((user.getPassword()).equals(passwordField.getText())) {
                    clearAll();
                    System.out.println("PASSA PARA TELA DE TÉCNICO");
                } else {
                    throw new Exception();
                }
            } else{
                user = DAO.getRecepcionist().FindById(parseInt(idTextField.getText()));
                if ((user.getPassword()).equals(passwordField.getText())) {
                    clearAll();
                    System.out.println("PASSA PARA TELA DE RECEPCIONISTA");
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            this.errorLabel.setText("Id e/ou senha incorreto(s)");
            this.idTextField.setText("");
            this.passwordField.setText("");
        }
    }

    private void clearAll(){
        this.errorLabel.setText("");
        this.idTextField.setText("");
        this.passwordField.setText("");
    }
}