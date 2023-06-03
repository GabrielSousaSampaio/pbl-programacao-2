module com.uefs.pblprogramacao2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uefs.pblprogramacao2 to javafx.fxml;
    exports com.uefs.pblprogramacao2;
    exports com.uefs.pblprogramacao2.controller;
    opens com.uefs.pblprogramacao2.controller to javafx.fxml;
}