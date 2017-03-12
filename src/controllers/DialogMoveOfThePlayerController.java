package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * Created by Spazhev Oleksandr on 10.03.2017.
 */
public class DialogMoveOfThePlayerController {

    @FXML
    public TextField            txtWord;

    @FXML
    public ChoiceBox<String>    chbxCoordX;

    @FXML
    public ChoiceBox<String>    chbxCoordY;

    @FXML
    public ChoiceBox<Character> chbxLetter;

    @FXML
    public Button               btnOK;

    @FXML
    public Button               btnCancel;


    public void pressedButton(ActionEvent actionEvent) {

    }
}
