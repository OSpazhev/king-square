package controllers;

import interfaces.implementations.HumanPlayer;
import interfaces.implementations.PCPlayer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import objects.Move;
import objects.Row;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SinglePlayerGameController implements Initializable {

    @FXML
    private Label               labelNameOfThePlayer;

    @FXML
    private Label               labelNameOfPC;

    @FXML
    private Label               labelScoresOfThePlayer;

    @FXML
    private Label               labelScoresOfPC;

    @FXML
    private TableView tablePlayingField;

    @FXML
    private TableColumn<Row, String> columnNamesOfRows;

    @FXML
    private TableColumn<Row, String> columnX1;

    @FXML
    private TableColumn<Row, String> columnX2;

    @FXML
    private TableColumn<Row, String> columnX3;

    @FXML
    private TableColumn<Row, String> columnX4;

    @FXML
    private TableColumn<Row, String> columnX5;

    static private HumanPlayer  humanPlayer  = new HumanPlayer();
    static private PCPlayer     pcPlayer     = new PCPlayer();

    private FXMLLoader          fxmlLoader   = new FXMLLoader();
    private Parent              fxmlEdit;
    private Scene               scene;

    //private Table               table;
    private ObservableList<Row> tableForFXML = FXCollections.observableArrayList();


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

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка при роботі з fxml файлом");
            alert.setHeaderText("Проблеми при завантажені fxml файлу");
            alert.setContentText(null);

            alert.showAndWait();

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

        } catch(Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Вікно помилки");
            alert.setHeaderText("Проблеми з відкриттям вікна");
            alert.setContentText(null);

            alert.showAndWait();

        }


    }

    void setPlayersNamesToLabels(String humanPlayerName) {

        // create players
        humanPlayer = new HumanPlayer(humanPlayerName);
        pcPlayer    = new PCPlayer();

        // set player`s names to the appropriate labels
        labelNameOfThePlayer.setText(humanPlayer.getName());
        labelNameOfPC.setText(pcPlayer.getName());

        // set connection between labels and appropriate fields
        pcPlayer.setListener(labelScoresOfPC);
        humanPlayer.setListener(labelScoresOfThePlayer);

    }

    public static boolean tryToMakeMoveBy(Move possibleMove) {

        return true;
    }

}
