module ba.smoki.internetapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.jdi;
    requires java.naming;


    opens com.smoki.internetapp to javafx.fxml;
    exports com.smoki.internetapp;
}