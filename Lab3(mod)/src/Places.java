abstract class Places extends XYZ
{
    private String name;

    Places (String name, int x, int y, int height)
    {
        this.name = name;
        setX(x);
        setY(y);
        setHeight(height);
    }

    public String getName() { return name; }
}
