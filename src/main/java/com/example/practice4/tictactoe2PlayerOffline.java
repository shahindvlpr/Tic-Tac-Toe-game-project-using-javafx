package com.example.practice4;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class tictactoe2PlayerOffline implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView background;


    private Stage stage;

    private Scene scene;

    private Parent root;
    @FXML
    private Button mainMenu;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b9;
    @FXML
    private Button playagain;
    @FXML
    private Button restart;
    @FXML
    private Label xturn,name1,name2;
    @FXML
    private Label oturn;
    @FXML
    private Label result;
    private int playerturn=0;
    private ArrayList<Button> buttons;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.fitWidthProperty().bind(borderPane.widthProperty());
        background.fitHeightProperty().bind(borderPane.heightProperty());
        buttons = new ArrayList<>(Arrays.asList(b1,b2,b3,b4,b5,b6,b7,b8,b9));


        buttons.forEach(button ->{
            setupButton(button);
            button.setFocusTraversable(false);
        });
        if(playerturn==0){
            xturn.setDisable(false);
            oturn.setDisable(true);


        }
        else{
            xturn.setDisable(true);
            oturn.setDisable(false);


        }
    }

    @FXML
    void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        result.setText("Tic-Tac-Toe");
        if(playerturn==0){
            xturn.setDisable(false);
            oturn.setDisable(true);

        }
        else{
            xturn.setDisable(true);
            oturn.setDisable(false);


        }
    }

    public void resetButton(Button button){
        button.setDisable(false);
        button.setText("");
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            checkIfGameIsOver();
            if(checkIfGameIsOver()=='x'){
                b1.setDisable(true);
                b2.setDisable(true);
                b3.setDisable(true);
                b4.setDisable(true);
                b5.setDisable(true);
                b6.setDisable(true);
                b7.setDisable(true);
                b8.setDisable(true);
                b9.setDisable(true);
                xturn.setDisable(true);
                oturn.setDisable(true);


                result.setText("X won!");

            }
            else if(checkIfGameIsOver()=='o'){
                b1.setDisable(true);
                b2.setDisable(true);
                b3.setDisable(true);
                b4.setDisable(true);
                b5.setDisable(true);
                b6.setDisable(true);
                b7.setDisable(true);
                b8.setDisable(true);
                b9.setDisable(true);
                xturn.setDisable(true);
                oturn.setDisable(true);
                result.setText("O won!");
            }
            else if(b1.isDisabled()&&
                    b2.isDisabled()&&
                    b3.isDisabled()&&
                    b4.isDisabled()&&
                    b5.isDisabled()&&
                    b6.isDisabled()&&
                    b7.isDisabled()&&
                    b8.isDisabled()&&
                    b9.isDisabled()&&
                    checkIfGameIsOver()=='d'){
                xturn.setDisable(true);
                oturn.setDisable(true);
                result.setText("Match Tie!");
            }
        });
    }

    public void setPlayerSymbol(Button button){
        if(playerturn % 2 == 0){
            button.setText("X");
            xturn.setDisable(true);
            oturn.setDisable(false);

            playerturn = 1;
        } else{
            button.setText("O");
            xturn.setDisable(false);
            oturn.setDisable(true);
            playerturn = 0;
        }
    }

    public char checkIfGameIsOver(){
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> b1.getText() + b2.getText() + b3.getText();
                case 1 -> b4.getText() + b5.getText() + b6.getText();
                case 2 -> b7.getText() + b8.getText() + b9.getText();
                case 3 -> b1.getText() + b5.getText() + b9.getText();
                case 4 -> b3.getText() + b5.getText() + b7.getText();
                case 5 -> b1.getText() + b4.getText() + b7.getText();
                case 6 -> b2.getText() + b5.getText() + b8.getText();
                case 7 -> b3.getText() + b6.getText() + b9.getText();
                default -> null;
            };

            //X winner
            if (line.equals("XXX")) {

                return 'x';
            }

            //O winner
            else if (line.equals("OOO")) {

                return 'o';
            }
        }
        return 'd';
    }

    public void registration(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }





    private static String hostAddress = "jdbc:mysql://localhost:3306/mega_apps_for_games";
    private static String DB_user = "root";
    private static String DB_password = "";
    @FXML
    private void checkIfGameIsOver(ActionEvent event) throws IOException {
        String uploadINFO = null;
        b1.getText();
        b2.getText();
        b3.getText();
        b4.getText();
        b4.getText();
        b5.getText();
        b6.getText();
        b7.getText();
        b8.getText();
        b9.getText();


        try{
            // Registering the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
    
            // Connection creation
            Connection connection = DriverManager.getConnection(hostAddress, DB_user, DB_password);
    
            // Statement creation
            Statement statement = connection.createStatement();
    
           uploadINFO = "INSERT INTO who_wins" + "\nVALUES ('" +  b1 +"','"+ b2 +"','"+ b3 +"','" +  b4 +"','"+ b5 +"','"+ b6 +"','" +  b7 +"','"+ b8 +"','"+ b9 +"')";
       
        //System.out.println(uploadINFO);

        statement.executeUpdate(uploadINFO);

        // closing the statement and connection
        statement.close();
        connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

