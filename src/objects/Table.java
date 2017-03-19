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

    public Table() {

        for (int i = 0; i <= COLUMN_SIZE; i++) {
            for (int j = 0; j <= COLUMN_SIZE; j++) {
                tableForGame[i][j] = ' ';
            }
        }

        for (int j = 0; j < COLUMN_SIZE - 1; j++) {
            tableForFXML.add(new Row(j + 1));
        }

    }

    public boolean isCellEmpty(Move possibleMove) {
        return (tableForGame[possibleMove.getCoordX()][possibleMove.getCoordY()] == ' ');
    }

    public boolean isNeighboringCellsEmpty(Move possibleMove) {

        boolean flagNeighboringCellsEmpty = false;

        flagNeighboringCellsEmpty |= (tableForGame[possibleMove.getCoordX() + 1][possibleMove.getCoordY()] != ' ');
        flagNeighboringCellsEmpty |= (tableForGame[possibleMove.getCoordX() - 1][possibleMove.getCoordY()] != ' ');
        flagNeighboringCellsEmpty |= (tableForGame[possibleMove.getCoordX()][possibleMove.getCoordY() + 1] != ' ');
        flagNeighboringCellsEmpty |= (tableForGame[possibleMove.getCoordX()][possibleMove.getCoordY() - 1] != ' ');

        return flagNeighboringCellsEmpty;

    }

    public void setValueForCell(Move newValueForCell) {

        tableForGame[newValueForCell.getCoordX()][newValueForCell.getCoordY()] = newValueForCell.getLetter();
        tableForFXML.get(2).set(newValueForCell.getCoordY(), newValueForCell.getLetter());

    }

    public void    setStartWord(Word startWord) {

        char startWordCh[] = startWord.getWord().toCharArray();

        for (int i = 0; i < ROW_SIZE - 1; i++) {

            Move newValueForCell = new Move();
            newValueForCell.setLetter(startWordCh[i]);
            newValueForCell.setCoordX(2);
            newValueForCell.setCoordY(i + 1);

            setValueForCell(newValueForCell);

        }

    }

}
