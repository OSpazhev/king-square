package controllers;

import interfaces.implementations.ErrorDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DialogBeforeStartSinglePlayerGameController {

    @FXML
    private TextField txtName;

    private FXMLLoader fxmlLoader = new FXMLLoader();
    private Parent fxmlEdit;

    private void closePreviousWindows(ActionEvent actionEvent) {
        // take stages of the previous Window and current and close them
        Stage currentWindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Stage previousWindow = (Stage) (currentWindow.getOwner());

        currentWindow.close();
        previousWindow.close();
    }

    private void loadFXMLFile() {
        try {
            fxmlLoader.setLocation(getClass().getResource("../fxml/SinglePlayerGame.fxml"));
            fxmlEdit = fxmlLoader.load();
        } catch (IOException e) {
            ErrorDialog.callDialog("Помилка при спробі завантажити файл", "Проблеми із завантаженням fxml файлу");
        }
    }

    private void transferHumanPlayerName(String name) {
        try {
            ((SinglePlayerGameController) fxmlLoader.getController()).setPlayersNamesToLabels(name);
        } catch (NullPointerException e) {
            ErrorDialog.callDialog("Помилка при спробі встановити імена гравцям", "Проблеми із fxml файлом");
        }
    }

    // method is called after push button btnOK
    public void startGame(ActionEvent actionEvent) {
        try {
            // if entered field with name of human player wasn't empty
            if (!txtName.getText().isEmpty()) {
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
            } else {
                ErrorDialog.callDialog("Помилка при спробі почати гру", "Ви не ввели ім'я");

                txtName.setPromptText("Введіть тут ваше ім'я");
            }
        } catch (Exception e) {
            ErrorDialog.callDialog("Помилка при спробі почати гру", null);
        }
    }
}
