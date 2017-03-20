package controllers;

import interfaces.implementations.ErrorDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    private final int  MIN_HEIGHT = 100;
    private final int  MIN_WIDTH  = 400;

    private FXMLLoader fxmlLoader = new FXMLLoader();
    private Parent     fxmlScene;
    private Scene      scene;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        loadFXMLFile();
    }

    private void loadFXMLFile() {
        try {
            fxmlLoader.setLocation(getClass().getResource("../fxml/DialogBeforeStartSinglePlayerGame.fxml"));
            fxmlScene = fxmlLoader.load();
            scene = new Scene(fxmlScene);
        } catch (IOException e) {
            ErrorDialog.callDialog("Помилка при спробі завантажити файл", "Проблеми із завантаженням fxml файлу");
        }
    }

    // method is called after push button btnSinglePlay
    public void showDialogBeforeSinglePlayerGame(ActionEvent actionEvent) {
        // create new Stage for Window
        Stage stage = new Stage();

        stage.setTitle("Ім'я гравця");
        stage.setMinWidth(MIN_WIDTH);
        stage.setMinHeight(MIN_HEIGHT);
        stage.setResizable(false);
        stage.setScene(scene);

        // set new Window modal(can only open one such Window)
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner((((Node)actionEvent.getSource()).getScene().getWindow()));

        // show created Window
        stage.show();
    }
}
