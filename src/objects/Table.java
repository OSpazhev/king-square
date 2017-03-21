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

        //rewrite table
        tableForGame[coordX][coordY] = newValueForCell.getLetter();
        Row buffer = tableForFXML.get(coordX - 1);
        buffer.set(coordY, newValueForCell.getLetter());
        tableForFXML.set(coordX - 1, buffer);
    }

    public void setStartWord(Word startWord) {

        char startWordCh[] = startWord.getString().toCharArray();

        for (int i = 0; i < ROW_SIZE - 1; i++) {

            Move newValueForCell = new Move(X3, i + 1, startWordCh[i]);

            setValueForCell(newValueForCell);
        }
    }

    private boolean isMoveContainThisCell(Move currentCell, Move move) {
        boolean flagMoveStartFromThisCell = false;

        Move copyMove        = new Move(move);
        int currentCoordX    = currentCell.getCoordX();
        int currentCoordY    = currentCell.getCoordY();

        if (tableForGame[currentCoordX][currentCoordY] != ' ') {
            if (copyMove.getFirstLetterOfWord() == tableForGame[currentCoordX][currentCoordY]) {

                char buffer = tableForGame[currentCoordX][currentCoordY];
                tableForGame[currentCoordX][currentCoordY] = ' ';
                copyMove.removeFirstLetterOfWord();

                if (copyMove.wordLength() == 0) {
                    flagMoveStartFromThisCell = (tableForGame[copyMove.getCoordX()][copyMove.getCoordY()] == ' ');
                } else {


                    if (currentCoordX > 1) {
                        Move newCurrentCell = new Move(currentCoordX - 1, currentCoordY);
                        flagMoveStartFromThisCell = isMoveContainThisCell(newCurrentCell, copyMove);
                    }

                    if (!flagMoveStartFromThisCell && currentCoordX < COLUMN_SIZE - 1) {
                        Move newCurrentCell = new Move(currentCoordX + 1, currentCoordY);
                        flagMoveStartFromThisCell = isMoveContainThisCell(newCurrentCell, copyMove);
                    }

                    if (!flagMoveStartFromThisCell && currentCoordY > 1) {
                        Move newCurrentCell = new Move(currentCoordX, currentCoordY - 1);
                        flagMoveStartFromThisCell = isMoveContainThisCell(newCurrentCell, copyMove);
                    }

                    if (!flagMoveStartFromThisCell && currentCoordY < ROW_SIZE - 1) {
                        Move newCurrentCell = new Move(currentCoordX, currentCoordY + 1);
                        flagMoveStartFromThisCell = isMoveContainThisCell(newCurrentCell, copyMove);
                    }
                }

                tableForGame[currentCoordX][currentCoordY] = buffer;
            }
        }

        return flagMoveStartFromThisCell;
    }

    public boolean isMovePossible(Move move) {
        boolean flagMovePossible = false;

        Move copyMove = new Move(move);

        int requiredCoordX = copyMove.getCoordX();
        int requiredCoordY = copyMove.getCoordY();
        tableForGame[requiredCoordX][requiredCoordY] =  copyMove.getLetter();

        for (int i = 1; i < COLUMN_SIZE; i++) {
            for (int j = 1; j < ROW_SIZE; j++) {
                Move currentCell = new Move(i, j);
                if (!flagMovePossible) {
                    // if first letter equal to current cell and check possibility to make move from this cell
                    if (tableForGame[i][j] == move.getFirstLetterOfWord() && isMoveContainThisCell(currentCell, copyMove)) {
                        flagMovePossible = true;
                    }
                }
            }
        }

        // if player's move is successful
        if (flagMovePossible) {
            setValueForCell(copyMove);
        } else {
            tableForGame[requiredCoordX][requiredCoordY] =  ' ';
        }

        return flagMovePossible;
    }
}
