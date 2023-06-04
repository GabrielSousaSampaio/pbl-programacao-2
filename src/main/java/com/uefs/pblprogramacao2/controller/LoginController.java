package com.uefs.pblprogramacao2.controller;


import com.uefs.pblprogramacao2.dao.DAO;
import com.uefs.pblprogramacao2.model.users.Administrator;
import com.uefs.pblprogramacao2.model.users.Recepcionist;
import com.uefs.pblprogramacao2.model.users.Technician;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class LoginController implements Initializable {

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
    private void onLoginButtonClick() {
        try {
            if (choiseUserType.getValue() == "Administrador") {
                Administrator user = DAO.getAdministrator().FindById(Integer.parseInt(idTextField.getText()));
                if (user.getPassword().equals(passwordField.getText())) {
                    clearAll();
                    System.out.println("PASSA PARA TELA DE ADMINISTRADOR");
                }
                else {
                    throw new Exception();
                }
            }
            else if (choiseUserType.getValue() == "Técnico") {
                Technician user = DAO.getTechnician().FindById(parseInt(idTextField.getText()));
                if ((user.getPassword()).equals(passwordField.getText())) {
                    clearAll();
                    System.out.println("PASSA PARA TELA DE TÉCNICO");
                }
                else {
                    throw new Exception();
                }
            }
            else{
                Recepcionist user = DAO.getRecepcionist().FindById(parseInt(idTextField.getText()));
                if ((user.getPassword()).equals(passwordField.getText())) {
                    clearAll();
                    System.out.println("PASSA PARA TELA DE RECEPCIONISTA");
                }
                else {
                    throw new Exception();
                }
            }
        }
        catch (Exception e) {
            this.errorLabel.setText("Id e/ou senha incorreto(s)");
            this.idTextField.setText("");
            this.passwordField.setText("");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiseUserType.setValue("Administrador");
        choiseUserType.getItems().addAll(usersTypeList);
    }

    public void clearAll(){
        this.errorLabel.setText("");
        this.idTextField.setText("");
        this.passwordField.setText("");
    }
}