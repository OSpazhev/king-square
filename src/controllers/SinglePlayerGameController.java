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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import objects.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SinglePlayerGameController implements Initializable {

    @FXML
    private Label                    labelNameOfTheMovingPlayer;

    @FXML
    private Label                    labelNameOfThePlayer;

    @FXML
    private Label                    labelNameOfPC;

    @FXML
    private Label                    labelScoresOfThePlayer;

    @FXML
    private Label                    labelScoresOfPC;

    @FXML
    private TableView                tablePlayingField;

    @FXML
    private TableColumn<Row, String> columnNamesOfRows;

    @FXML
    private TableColumn<Row, String> columnY1;

    @FXML
    private TableColumn<Row, String> columnY2;

    @FXML
    private TableColumn<Row, String> columnY3;

    @FXML
    private TableColumn<Row, String> columnY4;

    @FXML
    private TableColumn<Row, String> columnY5;

    @FXML
    private ListView<String> listViewWordsOfPC;

    @FXML
    private ListView<String> listViewWordsOfPlayer;

    private static HumanPlayer       humanPlayer  = new HumanPlayer();
    private static PCPlayer          pcPlayer     = new PCPlayer();

    private static Table             table        = new Table();

    private static Vocabulary        vocabulary   = new Vocabulary();

    private static ListOfWords       pcUsed       = new ListOfWords();
    private static ListOfWords       playerUsed   = new ListOfWords();

    private FXMLLoader               fxmlLoader   = new FXMLLoader();
    private Parent                   fxmlEdit;
    private Scene                    scene;


    @FXML
    public void initialize(URL location, ResourceBundle resources)  {

        loadFXMLFile();

        Word startWord = vocabulary.getFiveLetterWord();
        table.setStartWord(startWord);
        pcUsed.add(startWord);
        playerUsed.add(startWord);

        columnNamesOfRows.setCellValueFactory(new PropertyValueFactory<Row, String>("name"));
        columnY1.setCellValueFactory(new PropertyValueFactory<Row, String>("y1"));
        columnY2.setCellValueFactory(new PropertyValueFactory<Row, String>("y2"));
        columnY3.setCellValueFactory(new PropertyValueFactory<Row, String>("y3"));
        columnY4.setCellValueFactory(new PropertyValueFactory<Row, String>("y4"));
        columnY5.setCellValueFactory(new PropertyValueFactory<Row, String>("y5"));

        columnNamesOfRows.setStyle("-fx-alignment: CENTER;");
        columnY1.setStyle("-fx-alignment: CENTER;");
        columnY2.setStyle("-fx-alignment: CENTER;");
        columnY3.setStyle("-fx-alignment: CENTER;");
        columnY4.setStyle("-fx-alignment: CENTER;");
        columnY5.setStyle("-fx-alignment: CENTER;");

        tablePlayingField.setItems(table.getTable());
        listViewWordsOfPC.setItems(pcUsed.getList());
        listViewWordsOfPlayer.setItems(playerUsed.getList());
        
        tablePlayingField.setSelectionModel(null);

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

        String currenPlayer = "Зараз хід гравця: " + humanPlayer.getName();
        labelNameOfTheMovingPlayer.setText(currenPlayer);

    }

    public static boolean tryToMakeMoveBy(Move possibleMove) {

        boolean flagMoveSuccessful = true;

        if (table.isCellEmpty(possibleMove)) {

            if (!table.isNeighboringCellsEmpty(possibleMove))
            {

            } else
            {
                flagMoveSuccessful = false;
            }

        } else {
            flagMoveSuccessful = false;
        }
        return flagMoveSuccessful;
    }

}
