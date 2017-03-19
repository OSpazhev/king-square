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

    public void set(String y, char value) {
        switch (y) {
            case "y1":
            case "Y1":
                setY1(value);
                break;
            case "y2":
            case "Y2":
                setY2(value);
                break;
            case "y3":
            case "Y3":
                setY3(value);
                break;
            case "y4":
            case "Y4":
                setY4(value);
                break;
            case "y5":
            case "Y5":
                setY5(value);
                break;
        }
    }

    public void set(int y, char value) {
        switch (y) {
            case 1:
                setY1(value);
                break;
            case 2:
                setY2(value);
                break;
            case 3:
                setY3(value);
                break;
            case 4:
                setY4(value);
                break;
            case 5:
                setY5(value);
                break;
        }
    }

}
