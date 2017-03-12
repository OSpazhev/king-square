package interfaces;

import javafx.beans.property.StringProperty;

/**
 * Created by Spazhev Oleksandr on 23.02.2017.
 */
public interface Player {

    String name   = "";
    int    scores = 0;

    String getName();

    void addScores(int scores);

    int getScores();

    StringProperty getScoresForLabel();

    boolean makeMove();

}
