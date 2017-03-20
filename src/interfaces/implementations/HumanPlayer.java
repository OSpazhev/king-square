package interfaces.implementations;

import interfaces.IPlayer;
import javafx.scene.control.Label;

public class HumanPlayer implements IPlayer {

    private String  name;
    private Integer scores;
    private Label   listener;

    public HumanPlayer() {
        name   = "";
        scores = 0;
        if (listener != null) {
            listener.setText(scores.toString());
        }
    }

    public HumanPlayer(String name) {
        this.name = name;
        scores    = 0;
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
        this.scores += scores;

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
