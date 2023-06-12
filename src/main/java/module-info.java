module com.uefs.pbl2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.graphics;

    opens com.uefs.pbl2 to javafx.fxml, javafx.graphics, javafx.base;
    opens com.uefs.pbl2.model to javafx.fxml, javafx.graphics, javafx.base;
    opens com.uefs.pbl2.controller to javafx.fxml, javafx.graphics, javafx.base;
    opens com.uefs.pbl2.controller.registerController.users to javafx.fxml, javafx.graphics, javafx.base;
    opens com.uefs.pbl2.controller.usersController to javafx.base, javafx.fxml, javafx.graphics;
    opens com.uefs.pbl2.model.users to javafx.base, javafx.fxml, javafx.graphics;
    opens com.uefs.pbl2.controller.workOrdersController to javafx.base, javafx.fxml, javafx.graphics ;
    exports com.uefs.pbl2;

}