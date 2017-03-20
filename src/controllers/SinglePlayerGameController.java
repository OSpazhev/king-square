package controllers;

import interfaces.implementations.ErrorDialog;
import interfaces.implementations.HumanPlayer;
import interfaces.implementations.PCPlayer;
import interfaces.implementations.WarningDialog;
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

        // chose starting word
        Word startWord = vocabulary.getFiveLetterWord();

        // set starting word to the table
        table.setStartWord(startWord);

        // add starting word to usedWord List
        pcUsed.add(startWord);
        playerUsed.add(startWord);

        // set to the columns appropriate field of object person
        columnNamesOfRows.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnY1.setCellValueFactory(new PropertyValueFactory<>("y1"));
        columnY2.setCellValueFactory(new PropertyValueFactory<>("y2"));
        columnY3.setCellValueFactory(new PropertyValueFactory<>("y3"));
        columnY4.setCellValueFactory(new PropertyValueFactory<>("y4"));
        columnY5.setCellValueFactory(new PropertyValueFactory<>("y5"));

        // set style for columns
        columnNamesOfRows.setStyle("-fx-alignment: CENTER;");
        columnY1.setStyle("-fx-alignment: CENTER;");
        columnY2.setStyle("-fx-alignment: CENTER;");
        columnY3.setStyle("-fx-alignment: CENTER;");
        columnY4.setStyle("-fx-alignment: CENTER;");
        columnY5.setStyle("-fx-alignment: CENTER;");

        // connect gaming table with FXML table
        String headerText = "Щось не так з ігровою таблицею";

        tablePlayingField.setItems(table.getTable());

        // connect gaming usedWords Lists with FXML Lists View
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

            ErrorDialog.callDialog("Пороблеми зі сценою", "Проблеми при завантажені fxml файлу");

        }

    }

    public void showDialogMoveOfThePlayer(ActionEvent actionEvent) {

        try {

            Stage stage = new Stage();

            stage.setTitle("Хід гравця");
            stage.setScene(scene);
            stage.setResizable(false);

            // do new window modal
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());

            stage.show();

        } catch(Exception e) {

            ErrorDialog.callDialog("Проблеми з відкриттям вікна", null);

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

        String currentPlayer = "Зараз хід гравця: " + humanPlayer.getName();
        labelNameOfTheMovingPlayer.setText(currentPlayer);

    }



    public static boolean tryToMakeMoveBy(Move possibleMove) {

        boolean flagMoveSuccessful = false;

        String headerText = "Помилка при спробі зробити хід";

        // if word is in vocabulary
        if (vocabulary.isWordInVocabulary(possibleMove.getWord())) {

            // if word wasn't used
            if (!pcUsed.isUsed(possibleMove.getWord()) && !playerUsed.isUsed(possibleMove.getWord())) {

                // if chosen cell is empty
                if (table.isCellEmpty(possibleMove)) {

                    // if neighboring cells isn't empty
                    if (!table.isNeighboringCellsEmpty(possibleMove)) {

                        flagMoveSuccessful = true;

                    } else {
                        WarningDialog.callDialog(headerText, "Жодна з сусідніх клітинок не містить літери");
                    }
                } else {
                    WarningDialog.callDialog(headerText, "Дана клітинка поля вже зайнята");
                }
            } else {
                WarningDialog.callDialog(headerText, "Дане слово вже було використане в цій грі");
            }
        } else {
            WarningDialog.callDialog(headerText, "Такого слова немає в словнику");
        }
        return flagMoveSuccessful;
    }

}
