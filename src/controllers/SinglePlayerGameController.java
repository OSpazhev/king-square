package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class SinglePlayerGameController {

    public void showDialogMoveOfThePlayer(ActionEvent actionEvent){
        try {

            Stage stage = new Stage();

            Parent root = FXMLLoader.load(getClass().getResource("../fxml/DialogMoveOfThePlayer.fxml"));

            stage.setTitle("Хід гравця");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
