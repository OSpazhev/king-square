package objects;

public class Move {

    private char   letter;
    private int    coordX;
    private String stringCoordX;
    private int    coordY;
    private String stringCoordY;
    private Word   word;

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public void setLetter(String letter) {
        this.letter = (letter.toCharArray())[0];
    }

    public char getLetter() {
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

    public int getCoordX() {
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

    public int getCoordY() {
        return coordY;
    }

    public String getStringCoordY() {
        return stringCoordY;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public void setWord(String word) {
        this.word = new Word(word);
    }

    public Word getWord() {
        return word;
    }

}
