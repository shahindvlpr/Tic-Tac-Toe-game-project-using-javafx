package com.example.practice4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        
        // Set the size of the registration page to fit the screen
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Scene scene = new Scene(root, bounds.getWidth(), bounds.getHeight());

        // Set the scene on the stage and show the stage
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("u_logo.jpg")));
        primaryStage.setTitle("UIU Game Zone");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    } 
     
}    
  