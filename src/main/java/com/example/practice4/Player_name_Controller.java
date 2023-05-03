// package com.example.practice4;


// import java.sql.Statement;
// import java.util.ResourceBundle;
// import java.io.IOException;
// import java.net.URL;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.fxml.Initializable;
// import javafx.scene.Node;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.TextField;
// import javafx.scene.image.ImageView;
// import javafx.scene.layout.BorderPane;
// import javafx.stage.Stage;

// public class Player_name_Controller implements Initializable  {

//     private static String hostAddress = "jdbc:mysql://localhost:3306/mega_apps_for_games";
//     private static String DB_user = "root";
//     private static String DB_password = "";

//     // private String player1_name;
//     // private String player2_name;

//     @FXML
//     private BorderPane borderPane;

//     @FXML
//     private ImageView background;
    // @FXML
    // private Stage stage;
    // private Scene scene;
    // private Parent root;
    

//     @FXML
//     private TextField player1_name,player2_name;
//     @FXML
//     private Button play,mainMenu;
//     public String p1_name=player1_name.getText(), p2_name=player2_name.getText();
    // @Override
    // public void initialize(URL url, ResourceBundle resourceBundle) {
    //     background.fitWidthProperty().bind(borderPane.widthProperty());
    //     background.fitHeightProperty().bind(borderPane.heightProperty());
    // }
    


//     @FXML
//     private void play(ActionEvent event) throws IOException {
//         String uploadINFO = null;



//         try{
//         // Registering the driver class
//         Class.forName("com.mysql.cj.jdbc.Driver");

//         // Connection creation
//         Connection connection = DriverManager.getConnection(hostAddress, DB_user, DB_password);

//         // Statement creation
//         Statement statement = connection.createStatement();

//     //    uploadINFO = "INSERT INTO user_details" + "\nVALUES ('" +  user_name +"','"+ user_id +"','"+ user_password +"')";
       
//             uploadINFO = "INSERT INTO who_wins" + "\nVALUES ('" +  player1_name.getText() +"','"+ player2_name.getText() +"')";

        
        
//         //System.out.println(uploadINFO);

//         statement.executeUpdate(uploadINFO);

//         // closing the statement and connection
//         statement.close();
//         connection.close();
//         }catch(Exception e){
//             e.printStackTrace();
//         }
        // root = FXMLLoader.load(getClass().getResource("tictactoe2PlayerOffline.fxml"));
        // stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // scene = new Scene(root);
        // stage.setScene(scene);
        // stage.show();

//     }

    
    

//     @FXML
//     private void switchToSignIn(ActionEvent event) throws IOException{
        
//                 root = FXMLLoader.load(getClass().getResource("registration.fxml"));
//                 stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                 scene = new Scene(root);
//                 stage.setScene(scene);
//                 stage.show();
//             }

// }


package com.example.practice4;
import java.util.ResourceBundle;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Player_name_Controller implements Initializable{
    public String p1name,p2name;

    @FXML
    private ImageView background;

    @FXML
    private BorderPane borderPane;

    @FXML
    private TextField player1_name;

    @FXML
    private TextField player2_name;
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML Label l1;
    private String id_info;

    
    
    

    @FXML
    void play(ActionEvent event)  throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tictactoePlayer.fxml"));
        root = loader.load();


        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        p1name=player1_name.getText();
        p2name=player2_name.getText();
        tictactoe2Player pass_info = loader.getController();
        id_info = l1.getText();


        pass_info.SetInfo(id_info,p1name,p2name);


    }
    public void GetUserId(String user_id){
        l1.setText("ID" + user_id);
        
    }

    @FXML
    void switchToSignIn(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.fitWidthProperty().bind(borderPane.widthProperty());
        background.fitHeightProperty().bind(borderPane.heightProperty());
        registration obj=new registration();
        l1.setText(obj.user_id);
    }

}