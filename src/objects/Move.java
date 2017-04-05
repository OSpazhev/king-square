package objects;

public class Move {

    private char   letter;
    private int    coordX;
    private String stringCoordX;
    private int    coordY;
    private String stringCoordY;
    private Word   word;

    Move(int coordX, int coordY, char letter, Word word) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.letter = letter;
        this.word   = new Word(word);
    }

    Move(int coordX, int coordY, char letter) {
        this(coordX, coordY, letter, new Word());
    }

    Move(int coordX, int coordY) {
        this(coordX, coordY,' ', new Word());
    }

    public Move(char letter, Word word) {
        this (0, 0, letter, word);
    }

    public Move(Move move) {
        this(move.getCoordX(), move.getCoordY(), move.getLetter(), move.getWord());
    }

    void setLetter(char letter) {
        this.letter = letter;
    }

    public void setLetter(String letter) {
        this.letter = (letter.toCharArray())[0];
    }

    char getLetter() {
        return letter;
    }

    public void setCoordX(int coordX) {
        this.coordX       = coordX;
        this.stringCoordX = "X" + coordX;
    }

    public void setCoordX(String coordX) {
        this.stringCoordX = coordX;
        this.coordX       = (coordX.toCharArray())[1] - 48;
    }

    int getCoordX() {
        return coordX;
    }

    public String getStringCoordX() {
        return stringCoordX;
    }

    public void setCoordY(int coordY) {
        this.coordY       = coordY;
        this.stringCoordY = "Y" + coordY;
    }

    public void setCoordY(String coordY) {
        this.stringCoordY = coordY;
        this.coordY       = (coordY.toCharArray())[1] - 48;
    }

    int getCoordY() {
        return coordY;
    }

    public String getStringCoordY() {
        return stringCoordY;
    }

    void setWord(Word word) {
        this.word = word;
    }

    public Word getWord() {
        return word;
    }

    char getFirstLetterOfWord() {
        return word.firstLetter();
    }

    void removeFirstLetterOfWord() {
        word.removeFirstLetter();
    }

    public int wordLength() {
        return word.length();
    }
}
