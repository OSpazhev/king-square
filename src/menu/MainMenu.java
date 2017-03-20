package menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenu extends Application {

    private final int MIN_WIDTH = 300;
    private final int MIN_HEIGHT = 275;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/MainMenu.fxml"));

        primaryStage.setTitle("Гра Балда");
        primaryStage.setMinWidth(MIN_WIDTH);
        primaryStage.setMinHeight(MIN_HEIGHT);
        primaryStage.setScene(new Scene(root, MIN_WIDTH, MIN_HEIGHT));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception { launch(args); }
}
