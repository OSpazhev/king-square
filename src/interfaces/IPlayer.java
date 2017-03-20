package interfaces;

import javafx.scene.control.Label;

public interface IPlayer {

    String getName();

    void addScores(int scores);

    int getScores();

    boolean makeMove();

    void setListener(Label newListener);
}
