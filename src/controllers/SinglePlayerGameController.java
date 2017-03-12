package controllers;

import interfaces.implementations.HumanPlayer;
import interfaces.implementations.PCPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SinglePlayerGameController implements Initializable {

    @FXML
    private Button             btnMakeMove;

    @FXML
    private Button             btnSkipMove;

    @FXML
    private Button             btnGiveUp;

    @FXML
    private Label              labelNameOfThePlayer;

    @FXML
    private Label              labelNameOfPC;

    @FXML
    private Label              labelScoresOfThePlayer;

    @FXML
    private Label              labelScoresOfPC;

    static private HumanPlayer humanPlayer = new HumanPlayer();
    static private PCPlayer    pcPlayer    = new PCPlayer();

    private FXMLLoader         fxmlLoader = new FXMLLoader();
    private Parent             fxmlEdit;
    private Scene              scene;

    @FXML
    public void initialize(URL location, ResourceBundle resources)  {

        loadFXMLFile();

    }

    private void loadFXMLFile() {
        try {

            fxmlLoader.setLocation(getClass().getResource("../fxml/DialogMoveOfThePlayer.fxml"));
            fxmlEdit = fxmlLoader.load();
            scene = new Scene(fxmlEdit);

        } catch (IOException e) {

            System.out.println("Something wrong with load fxml file");

        }

    }

    public void showDialogMoveOfThePlayer(ActionEvent actionEvent) {

        try {
            Stage stage = new Stage();

            stage.setTitle("Хід гравця");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();

        } catch(Exception e)
        {
            System.out.println("Something wrong with stage of DialogMoveOfThePlayer");
        }


    }

    void setPlayersNamesToLabels(String humanPlayerName) {

        humanPlayer = new HumanPlayer(humanPlayerName);
        pcPlayer    = new PCPlayer();
        labelNameOfThePlayer.setText(humanPlayer.getName());
        labelNameOfPC.setText(pcPlayer.getName());

    }

}
