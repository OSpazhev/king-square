package interfaces.implementations;

import interfaces.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Spazhev Oleksandr on 23.02.2017.
 */
public class PCPlayer implements Player {

    private String         name;
    private Integer        scores;
    private StringProperty scoresForLabel;

    public PCPlayer() {

        name           = "Комп'ютер";
        scores         = 0;
        scoresForLabel = new SimpleStringProperty(scores.toString());

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addScores(int scores) {

        this.scores   += scores;
        scoresForLabel = new SimpleStringProperty(this.scores.toString());

    }

    @Override
    public int getScores() {
        return this.scores;
    }

    public StringProperty getScoresForLabel() {
        return this.scoresForLabel;
    }

    @Override
    public boolean makeMove() {

        return true;

    }

    public void skipMove() {

    }
}
