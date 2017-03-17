package objects;

/**
 * Created by Spazhev Oleksandr on 10.03.2017.
 */

public class Row {

    private String name = "y";

    private char   x1   = ' ';
    private char   x2   = ' ';
    private char   x3   = ' ';
    private char   x4   = ' ';
    private char   x5   = ' ';


    public void setName(int number) {
        name += number;
    }

    public void setX1(char x1) {
        this.x1 = x1;
    }
    public char getX1() {
        return this.x1;
    }

    public void setX2(char x2) {
        this.x2 = x2;
    }
    public char getX2() {
        return this.x2;
    }

    public void setX3(char x3) {
        this.x3 = x3;
    }
    public char getX3() {
        return this.x3;
    }

    public void setX4(char x4) {
        this.x4 = x4;
    }
    public char getX4() {
        return this.x4;
    }

    public void setX5(char x5) {
        this.x5 = x5;
    }
    public char getX5() {
        return this.x5;
    }

}
