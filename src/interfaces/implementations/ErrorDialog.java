package interfaces.implementations;

import interfaces.IDialog;
import javafx.scene.control.Alert;

public class ErrorDialog implements IDialog{

    public static void callDialog(String headrerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Вікно помилки");
        alert.setHeaderText(headrerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }
}
