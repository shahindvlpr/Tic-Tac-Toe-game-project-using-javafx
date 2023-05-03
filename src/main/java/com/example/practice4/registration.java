package com.example.practice4;


import java.sql.Statement;
import java.util.ResourceBundle;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class registration implements Initializable  {

    private static String hostAddress = "jdbc:mysql://localhost:3306/mega_apps_for_games";
    private static String DB_user = "root";
    private static String DB_password = "";

    private String user_name;
    public String user_id;
    private String user_password;

    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView background,overlay;
    
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label label1;

    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_id;

    @FXML
    private PasswordField tf_password;


    @FXML
    private void registered(ActionEvent event) throws IOException {
        String uploadINFO = null;

        user_name = tf_username.getText();
        user_id = tf_id.getText();
        user_password = tf_password.getText();

        try{
        // Registering the driver class
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connection creation
        Connection connection = DriverManager.getConnection(hostAddress, DB_user, DB_password);

        // Statement creation
        Statement statement = connection.createStatement();

    //    uploadINFO = "INSERT INTO user_details" + "\nVALUES ('" +  user_name +"','"+ user_id +"','"+ user_password +"')";
       
        if(tf_username.getText().isEmpty() || tf_id.getText().isEmpty() || tf_password.getText().isEmpty()){
        
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Sign-in Status:");
            alert.setContentText("Required Fields Empty!");
            alert.showAndWait();
        }
        else{
            uploadINFO = "INSERT INTO user_details" + "\nVALUES ('" +  user_name +"','"+ user_id +"','"+ user_password +"')";

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Registration Status:");
            alert.setContentText("You have successfully registered!");
            alert.showAndWait();
        }
        
        //System.out.println(uploadINFO);

        statement.executeUpdate(uploadINFO);

        // closing the statement and connection
        statement.close();
        connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("player_name.fxml"));
        root = loader.load();
        Player_name_Controller pass_user_id = loader.getController();
        pass_user_id.GetUserId(user_id); 
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.fitWidthProperty().bind(borderPane.widthProperty());
        background.fitHeightProperty().bind(borderPane.heightProperty());
        overlay.fitWidthProperty().bind(borderPane.widthProperty());
        overlay.fitHeightProperty().bind(borderPane.heightProperty());
    
    }
    public void tictactoe2PlayerOffline(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("tictactoe2PlayerOffline.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }






    @FXML
    private PasswordField tf_main_password;

    @FXML
    private TextField tf_main_user;

    @FXML
    private void switchToSignIn(ActionEvent event) throws IOException{
        
        if(tf_main_user.getText().isEmpty() || tf_main_password.getText().isEmpty()){
            
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Sign-in Status:");
            alert.setContentText("Required Fields Empty!");
            alert.showAndWait();
        }
        else{
            root = FXMLLoader.load(getClass().getResource("player_name.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            }
    }

    








}


