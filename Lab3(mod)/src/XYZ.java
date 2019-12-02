abstract class XYZ
{
    protected Places position;
    protected int height;
    protected int x;
    protected int y;

    protected int getHeight() { return height; }
    protected void setHeight(int height) { this.height = height; }
    protected int getX() { return x; }
    protected void setX(int x) { this.x = x; }
    protected int getY() { return y; }
    protected void setY(int y) { this.y = y; }
    protected Places getPosition() { return position; }
    protected void setPosition(Places position) { this.position = position; }

    @Override
    public String toString() { return "Coordinates: " +
            "x: " + getX() +", "+ " y: " + getY() +", "+ " height: " + getHeight(); }

    @Override
    public boolean equals(java.lang.Object other)
    {
        if (other == null) return false;
        if(!super.equals(other)) return false;
        if (this == other) return true;
        if(this.getClass() != other.getClass()) return false;
        Human otherObj = (Human) other;
        return this.getHeight() == otherObj.getHeight();
    }
}
