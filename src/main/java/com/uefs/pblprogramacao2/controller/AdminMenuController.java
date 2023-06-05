package com.uefs.pblprogramacao2.controller;

import com.uefs.pblprogramacao2.Main;
import com.uefs.pblprogramacao2.model.users.Administrator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController {

    @FXML
    private Button customerManagementBtn;

    @FXML
    private Button employeeManagementBtn;

    @FXML
    private Button exitButton;

    @FXML
    private Button generateReportBtn;

    @FXML
    private Button partsAndStockBtn;

    @FXML
    private Label usernameLabel;

    @FXML
    private Button workOrderManagementBtn;

    @FXML
    void onExitButtonClick(ActionEvent event) {
        Main.changeView("loginScene");
    }
}
