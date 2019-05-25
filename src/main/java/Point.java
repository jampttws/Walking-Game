public class Point extends WObject{

    private int value;

    public Point(int x, int y) {
        super(x, y);
        this.value = 1;
    }

    public int getValue() {
        return value;
    }

}
