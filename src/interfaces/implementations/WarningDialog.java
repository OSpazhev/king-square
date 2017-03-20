package interfaces.implementations;

import interfaces.IDialog;
import javafx.scene.control.Alert;

public class WarningDialog implements IDialog {

    public static void callDialog(String headrerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Вікно попередження");
        alert.setHeaderText(headrerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }
}
