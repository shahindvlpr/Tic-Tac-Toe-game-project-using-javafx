package com.example.practice4;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class ServerController  {
    

    @FXML
    private AnchorPane background;

    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView overlay;

    @FXML
    private Button exitBtn;

    @FXML
    private TableView<?> playersTable;

    @FXML
    private TextField portField;

    @FXML
    private Button startServerBtn;

    @FXML
    private Label statusText;

    @FXML
    private Button stopServerBtn;

    

    public void startServer(ActionEvent ae) {
        if (portField.getText().isEmpty() || !Pattern.matches(
                "^((6553[0-5])|(655[0-2][0-9])|(65[0-4][0-9]{2})|(6[0-4][0-9]{3})|([1-5][0-9]{4})|([0-5]{0,5})|([0-9]{1,4}))$",
                portField.getText())) {
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Failed");
            a.setHeaderText("Server Failed to start");
            a.setResizable(true);
            a.setContentText("The port number is not valid");
            a.showAndWait();
            return;
        }
        int port = Integer.parseInt(portField.getText());
        //Server.createServer(port);
        stopServerBtn.setVisible(true);
        startServerBtn.setVisible(false);
        statusText.setTextFill(Color.GREEN);
        statusText.setText("Online");
        portField.setDisable(true);
        //loadTableData();
    }

    private void setServerStopped(){
        // Server.stop();
        stopServerBtn.setVisible(false);
        startServerBtn.setVisible(true);
        statusText.setTextFill(Color.RED);
        statusText.setText("Offline");
        portField.setDisable(false);
    }
    public void stopServer(ActionEvent ae) {
        setServerStopped();
    }
    public void exit(ActionEvent ae) {
        setServerStopped();
        System.exit(0);
    }

    // @Override
    // public void initialize(URL arg0, ResourceBundle arg1) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    // }

    // @Override
    // public void initialize(URL url, ResourceBundle resourceBundle) {
    //     overlay.fitWidthProperty().bind(borderPane.widthProperty());
    //     overlay.fitHeightProperty().bind(borderPane.heightProperty());
    // }

}
