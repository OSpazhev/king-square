package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    private final int MIN_HEIGHT = 100;
    private final int MIN_WIDTH  = 400;

    public void showDialogBeforeSinglePlayerGame(ActionEvent actionEvent) {

        try {

            Stage stage = new Stage();

            Parent root = FXMLLoader.load(getClass().getResource("../fxml/DialogBeforeStartSinglePlayerGame.fxml"));

            stage.setTitle("Ім'я гравця");
            stage.setMinWidth(MIN_WIDTH);
            stage.setMinHeight(MIN_HEIGHT);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner((((Node)actionEvent.getSource()).getScene().getWindow()));
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
