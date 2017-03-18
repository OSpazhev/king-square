package objects;

public class Row {

    private String name = "X";

    private char   y1   = ' ';
    private char   y2   = ' ';
    private char   y3   = ' ';
    private char   y4   = ' ';
    private char   y5   = ' ';

    public Row(int number) {
        this.name += number;
    }

    public String getName() { return this.name; }

    public void setY1(char y1) {
        this.y1 = y1;
    }
    public char getY1() {
        return this.y1;
    }

    public void setY2(char y2) {
        this.y2 = y2;
    }
    public char getY2() {
        return this.y2;
    }

    public void setY3(char y3) {
        this.y3 = y3;
    }
    public char getY3() {
        return this.y3;
    }

    public void setY4(char y4) {
        this.y4 = y4;
    }
    public char getY4() {
        return this.y4;
    }

    public void setY5(char y5) {
        this.y5 = y5;
    }
    public char getY5() {
        return this.y5;
    }

}
