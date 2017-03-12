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


    void setName(int number) {
        name += number;
    }

    void setX1(char x1) {
        this.x1 = x1;
    }
    char getX1() {
        return this.x1;
    }

    void setX2(char x2) {
        this.x2 = x2;
    }
    char getX2() {
        return this.x2;
    }

    void setX3(char x3) {
        this.x3 = x3;
    }
    char getX3() {
        return this.x3;
    }

    void setX4(char x4) {
        this.x4 = x4;
    }
    char getX4() {
        return this.x4;
    }

    void setX5(char x5) {
        this.x5 = x5;
    }
    char getX5() {
        return this.x5;
    }

}
