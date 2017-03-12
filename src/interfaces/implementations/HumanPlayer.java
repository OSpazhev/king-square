package interfaces.implementations;

import interfaces.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;

/**
 * Created by Spazhev Oleksandr on 23.02.2017.
 */

public class HumanPlayer implements Player {

    private String  name;
    private Integer scores;
    private Label   listener;

    public HumanPlayer() {
        name           = "";
        scores         = 0;
        if (listener != null) {

            listener.setText(scores.toString());

        }
    }

    public HumanPlayer(String name) {
        this.name      = name;
        scores         = 0;
        if (listener != null) {

            listener.setText(scores.toString());

        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addScores(int scores) {
        this.scores   += scores;
        if (listener != null) {

            listener.setText(this.scores.toString());

        }
    }

    @Override
    public int getScores() {
        return this.scores;
    }

    @Override
    public boolean makeMove() {
        return true;
    }

    @Override
    public void setListener(Label newListener) {
        listener = newListener;
    }

}
