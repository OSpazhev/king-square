package interfaces.implementations;

import interfaces.IPlayer;
import javafx.scene.control.Label;

/**
 * Created by Spazhev Oleksandr on 23.02.2017.
 */
public class PCPlayer implements IPlayer {

    private String               name;
    private Integer              scores;
    private Label                listener;

    public PCPlayer() {

        name           = "Комп'ютер";
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
