// package com.example.practice4;

// import java.io.IOException;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
// import java.net.ServerSocket;
// import java.net.Socket;

// public class Server {
//     public static void main(String[] args) throws IOException, ClassNotFoundException {
//         ServerSocket serverSocket = new ServerSocket(12345);
//         System.out.println("Server Started....");
//         while(true){
//             Socket socket = serverSocket.accept();
//             System.out.println("Client connected......");
//             ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            
//             //read from client........
//             Object cMsg = ois.readObject();
//             System.out.println("From client : " + (String)cMsg);
//             String serverMsg = (String) cMsg;
//             serverMsg = serverMsg.toUpperCase();

//             //sent to client.......
//             oos.writeObject(serverMsg);
//         }
//     }
// }


package com.example.practice4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Server extends Application  {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        Parent root = FXMLLoader.load(getClass().getResource("Server.fxml"));
        
        // Set the size of the registration page to fit the screen
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Scene scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
        scene.getStylesheets().add(getClass().getResource("server.css").toExternalForm());

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
  