package objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Table {

    private final int           ROW_SIZE    = 6;
    private final int           COLUMN_SIZE = 6;
    private final int           X3          = 3;

    private ObservableList<Row> tableForFXML = FXCollections.observableArrayList();

    private char                tableForGame [][] = new char [COLUMN_SIZE + 1][ROW_SIZE + 1];

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

        boolean flagNeighboringCellsEmpty;
        int     coordX                    = possibleMove.getCoordX();
        int     coordY                    = possibleMove.getCoordY();

        flagNeighboringCellsEmpty  = (tableForGame[coordX + 1][coordY] == ' ');
        flagNeighboringCellsEmpty &= (tableForGame[coordX - 1][coordY] == ' ');
        flagNeighboringCellsEmpty &= (tableForGame[coordX][coordY + 1] == ' ');
        flagNeighboringCellsEmpty &= (tableForGame[coordX][coordY - 1] == ' ');

        return flagNeighboringCellsEmpty;

    }

    private void setValueForCell(Move newValueForCell) {

        int     coordX                    = newValueForCell.getCoordX();
        int     coordY                    = newValueForCell.getCoordY();

        tableForGame[coordX][coordY] = newValueForCell.getLetter();
        tableForFXML.get(coordX - 1).set(coordY, newValueForCell.getLetter());

    }

    public void setStartWord(Word startWord) {

        char startWordCh[] = startWord.getString().toCharArray();

        for (int i = 0; i < ROW_SIZE - 1; i++) {

            Move newValueForCell = new Move(X3, i + 1, startWordCh[i]);

            setValueForCell(newValueForCell);

        }

    }

    private boolean isMoveStartFromThisCell(Move currentCell, Move move) {
        boolean flagMoveStartFromThisCell = false;

        boolean usedCells [][] = new boolean[COLUMN_SIZE][ROW_SIZE];

        return flagMoveStartFromThisCell;
    }

    public boolean isMovePossible(Move move) {
        boolean flagMovePossible = false;

        int requiredCoordX = move.getCoordX();
        int requiredCoordY = move.getCoordY();
        
        tableForGame[requiredCoordX][requiredCoordY] =  move.getLetter();

        for (int i = 1; i < COLUMN_SIZE; i++) {
            for (int j = 1; j < ROW_SIZE; j++) {
                Move currentCell = new Move(i, j);

                if (tableForGame[i][j] == move.getWord().getString().toCharArray()[0] && isMoveStartFromThisCell(currentCell, move)) {
                    flagMovePossible = true;
                }
            }
        }
        
        if (flagMovePossible) {
            setValueForCell(move);
        } else {
            tableForGame[requiredCoordX][requiredCoordY] =  ' ';
        }

        return flagMovePossible;
    }
}
