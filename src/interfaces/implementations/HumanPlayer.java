package interfaces.implementations;

import interfaces.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Spazhev Oleksandr on 23.02.2017.
 */

public class HumanPlayer implements Player {

    private String         name;
    private Integer        scores;
    private StringProperty scoresforLabel;

    public HumanPlayer() {
        name           = "";
        scores         = 0;
        scoresforLabel = new SimpleStringProperty(scores.toString());
    }

    public HumanPlayer(String name) {
        this.name      = name;
        scores         = 0;
        scoresforLabel = new SimpleStringProperty(scores.toString());
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addScores(int scores) {
        this.scores   += scores;
        scoresforLabel = new SimpleStringProperty(this.scores.toString());
    }

    @Override
    public int getScores() {
        return this.scores;
    }

    public StringProperty getScoresForLabel() {
        return this.scoresforLabel;
    }

    @Override
    public boolean makeMove() {
        return true;
    }

    public void skipMove() {

    }


}
