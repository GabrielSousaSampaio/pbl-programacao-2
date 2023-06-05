package com.uefs.pblprogramacao2.controller;

import com.uefs.pblprogramacao2.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RecepcionistMenuController {

    @FXML
    private Button customerManagementBtn;

    @FXML
    private Button exitButton;

    @FXML
    private Button partsAndStockBtn;

    @FXML
    private Button workOrderManagementBtn;

    @FXML
    void onExitButtonClick(ActionEvent event) {
        Main.changeView("loginScene");
    }
}
