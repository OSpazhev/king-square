package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Spazhev Oleksandr on 17.02.2017.
 */

public class DialogBeforeStartSinglePlayerGameController {

    @FXML
    private TextField  txtName;

    @FXML
    private Button     btnOK;

    @FXML
    private Button     btnCancle;

    private FXMLLoader fxmlLoader = new FXMLLoader();
    private Parent     fxmlEdit;

    private void closePreviousWindows(ActionEvent actionEvent)
    {
        // take stages of the previous Window and current and close them
        Stage currentWindow  = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage previousWindow = (Stage)(currentWindow.getOwner());

        currentWindow.close();
        previousWindow.close();

    }

    private void loadFXMLFile()
    {
        try
        {
            fxmlLoader.setLocation(getClass().getResource("../fxml/SinglePlayerGame.fxml"));
            fxmlEdit = fxmlLoader.load();

        } catch (IOException e) {

            System.out.println("Something wrong with load fxml file");

        }

    }

    private void transferHumanPlayerName(String name){

        try {

            ((SinglePlayerGameController)fxmlLoader.getController()).setPlayersNamesToLabels(name);

        } catch (NullPointerException e) {

            System.out.println("Something wrong with attempt set player's names to labels");

        }

    }

    // method is called after push button btnOK
    public void startGame(ActionEvent actionEvent) {

        try {

            // if entered field with name of human player wasn't empty
            if(!txtName.getText().isEmpty()) {

                // close DialogBeforeStartSinglePlayerGame.fxml and MainMenu.fxml
                closePreviousWindows(actionEvent);

                Stage stage = new Stage();

                // load Scene for stage from FXMLFile
                loadFXMLFile();

                // transfer entered name of the human player to the game Window
                transferHumanPlayerName(txtName.getText());

                stage.setTitle("Гра Балда. Гра проти комп'ютера");
                stage.setScene(new Scene(fxmlEdit));
                stage.show();
            }
            else {

                // if field with name empty, border will be red
                txtName.setStyle("-fx-border-color: #ff0008 ; -fx-border-width: 1px ;");
                txtName.setPromptText("Введіть тут ваше ім'я");
            }

        } catch (Exception e) {

            System.out.println("Something wrong with attempt open SinglePlayerGame");
            e.printStackTrace();

        }

    }

}
