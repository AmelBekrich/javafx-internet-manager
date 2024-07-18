module ba.smoki.internetapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens ba.smoki.internetapp to javafx.fxml;
    exports ba.smoki.internetapp;
}