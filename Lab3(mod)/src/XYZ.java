abstract class XYZ
{
    protected Places position;
    protected int height;
    protected int x;
    protected int y;

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public Places getPosition() { return position; }
    public void setPosition(Places position) { this.position = position; }

    @Override
    public String toString() { return "Coordinates: " +
            "x: " + getX() +", "+ " y: " + getY() +", "+ " height: " + getHeight(); }
}
