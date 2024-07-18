package ba.smoki.internetapp;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    private TableView<InternetPackage> table;
    private ObservableList<InternetPackage> data;

    @Override
    public void start(Stage stage) throws Exception {
        table = new TableView<>();
        data = FXCollections.observableArrayList();

        TableColumn<InternetPackage, String> firstNameColumn = new TableColumn<>("First Name:");
        firstNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstName()));
        firstNameColumn.setPrefWidth(110);
        TableColumn<InternetPackage, String> lastNameColumn = new TableColumn<>("Last Name:");
        lastNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastName()));
        lastNameColumn.setPrefWidth(110);
        TableColumn<InternetPackage, String> addressColumn = new TableColumn<>("Address:");
        addressColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress()));
        addressColumn.setPrefWidth(110);
        TableColumn<InternetPackage, Integer> internetSpeedColumn = new TableColumn<>("Speed (Mb/s):");
        internetSpeedColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getInternetSpeed()));
        internetSpeedColumn.setPrefWidth(110);
        TableColumn<InternetPackage, String> bandwidthColumn = new TableColumn<>("Bandwidth:");
        bandwidthColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBandwidth()));
        bandwidthColumn.setPrefWidth(110);
        TableColumn<InternetPackage, Integer> contractLengthColumn = new TableColumn<>("Contract Length:");
        contractLengthColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getContractLength()));
        contractLengthColumn.setPrefWidth(110);

        table.getColumns().addAll(firstNameColumn, lastNameColumn, addressColumn, internetSpeedColumn, bandwidthColumn, contractLengthColumn);
        table.setItems(data);

        TextField firstNameInput = new TextField();
        firstNameInput.setPromptText("First Name");
        TextField lastNameInput = new TextField();
        lastNameInput.setPromptText("Last Name");
        TextField addressInput = new TextField();
        addressInput.setPromptText("Address");

        ComboBox<Integer> internetSpeedInput = new ComboBox<>();
        internetSpeedInput.getItems().addAll(2, 5, 10, 20, 50, 100);
        internetSpeedInput.setPromptText("Internet Speed");

        ComboBox<String> bandwidthInput = new ComboBox<>();
        bandwidthInput.getItems().addAll("1 GB", "5 GB", "10 GB", "100 GB", "Flat");
        bandwidthInput.setPromptText("Bandwidth");

        ComboBox<Integer> contractLengthInput = new ComboBox<>();
        contractLengthInput.getItems().addAll(1, 2);
        contractLengthInput.setPromptText("Contract Length");

        Button registerButton = new Button("Add User");
        registerButton.setOnAction(e -> {
            String firstName = firstNameInput.getText();
            String lastName = lastNameInput.getText();
            String address = addressInput.getText();
            Integer internetSpeed = internetSpeedInput.getValue();
            String bandwidth = bandwidthInput.getValue();
            Integer contractLength = contractLengthInput.getValue();

            if (firstName != null && lastName != null && address != null && internetSpeed != null && bandwidth != null && contractLength != null) {
                InternetPackage internetPackage = new InternetPackage(firstName, lastName, address, internetSpeed, bandwidth, contractLength);
                data.add(internetPackage);
                firstNameInput.clear();
                lastNameInput.clear();
                lastNameInput.clear();
                internetSpeedInput.setValue(null);
                bandwidthInput.setValue(null);
                contractLengthInput.setValue(null);
            }
        });

        Button deleteButton = new Button("Delete User");
        deleteButton.setOnAction(e -> {
            InternetPackage selectedItem = table.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                data.remove(selectedItem);
            }
        });

        VBox form = new VBox(10, firstNameInput, lastNameInput, addressInput, internetSpeedInput, bandwidthInput, contractLengthInput, registerButton, deleteButton);
        form.setPadding(new Insets(10));
        form.setAlignment(Pos.TOP_LEFT);
        HBox layout = new HBox(10);
        layout.setPadding(new Insets(10));
        HBox.setHgrow(table, Priority.ALWAYS);
        layout.getChildren().addAll(form, table);

        form.setMaxWidth(300);
        table.prefWidthProperty().bind(layout.widthProperty().multiply(0.7));

        Scene scene = new Scene(layout, 870, 600);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Register Internet Application");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
