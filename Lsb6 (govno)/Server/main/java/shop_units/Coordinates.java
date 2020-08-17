package shop_units;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private long x; //Значение поля должно быть больше -622
    private long y; //Максимальное значение поля: 625

    public long getX() {
        return x;
    }
    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }
    public void setY(long y) {
        this.y = y;
    }
}