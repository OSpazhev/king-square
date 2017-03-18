package objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Table {

    private final int ROW_SIZE    = 6;
    private final int COLUMN_SIZE = 6;

    private ObservableList<Row> tableForFXML = FXCollections.observableArrayList();

    private char                tableForGame [][] = new char [ROW_SIZE + 1][COLUMN_SIZE + 1];

    public ObservableList<Row> getTable() {
        return tableForFXML;
    }

    public Table()
    {
        for (int i = 1; i < COLUMN_SIZE; i++)
            inicializeRaw(i);
    }

    private void inicializeRaw(int numberOfRaw) {

        for (int i = 1; i < COLUMN_SIZE; i++) {
            tableForGame[numberOfRaw][i] = ' ';
        }
        tableForFXML.add(numberOfRaw - 1, new Row(numberOfRaw));

    }

    private void inicializeColumn(int numberOfColumn) {

        for (int i = 1; i < COLUMN_SIZE; i++) {
            tableForGame[i][numberOfColumn] = ' ';
        }
        tableForFXML.add(numberOfColumn, new Row(numberOfColumn));
    }

}
