package controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Spazhev Oleksandr on 10.03.2017.
 */
public class DialogMoveOfThePlayerController implements Initializable{

    @FXML
    public ChoiceBox<String>    chbxCoordX;

    @FXML
    public ChoiceBox<String>    chbxCoordY;

    @FXML
    public ChoiceBox<Character> chbxLetter;

    @FXML
    public TextField            txtWord;

    @FXML
    public Button               btnOK;

    @FXML
    public Button               btnCancel;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        chbxCoordX.setItems(FXCollections.observableArrayList("X1", "X2", "X3", "X4", "X5"));
        chbxCoordY.setItems(FXCollections.observableArrayList("Y1", "Y2", "Y3", "Y4", "Y5"));
        chbxLetter.setItems(FXCollections.observableArrayList('а', 'б', 'в', 'г', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї',
                                                              'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
                                                              'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я'));

    }

    public void pressedButton(ActionEvent actionEvent) {

    }

}
