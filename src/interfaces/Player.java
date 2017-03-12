package interfaces;

import javafx.scene.control.Label;

/**
 * Created by Spazhev Oleksandr on 23.02.2017.
 */
public interface Player {

    String name   = "";
    int    scores = 0;
    Label  listener = null;

    String getName();

    void addScores(int scores);

    int getScores();

    boolean makeMove();

    void setListener(Label newListener);

}
