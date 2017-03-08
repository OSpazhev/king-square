package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Spazhev Oleksandr on 17.02.2017.
 */

public class DialogBeforeStartSinglePlayerGame {

    @FXML
    private Button    btnSetName;

    @FXML
    private TextField txtName;

    public void startGame(ActionEvent actionEvent) {

        try {

            if(!txtName.getText().equals(""))
            {

                Stage needToClose1 = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                Stage needToClose2 = (Stage)(needToClose1.getOwner());

                needToClose1.close();
                needToClose2.close();

                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../fxml/SinglePlayerGame.fxml"));
                stage.setTitle("Гра Балда. Гра проти комп'ютера");
                stage.setScene(new Scene(root));
                stage.show();
            }
            else
            {
                txtName.setStyle("-fx-border-color: #ff0008 ; -fx-border-width: 1px ;");
                txtName.setPromptText("Введіть тут ваше ім'я");
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
