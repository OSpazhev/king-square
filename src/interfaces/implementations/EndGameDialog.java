package interfaces.implementations;

import interfaces.IDialog;
import javafx.scene.control.Alert;

public class EndGameDialog implements IDialog{

    public static void callDialog(String headrerText, String contentText) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Кінець гри");
        alert.setHeaderText(headrerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }

}
