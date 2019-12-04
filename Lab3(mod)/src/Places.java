abstract class Places extends XYZ
{
    private String name;

    Places (String name, int x, int y, int height)
    {
        super(getTimesOfDay());
        this.name = name;
        setX(x);
        setY(y);
        setHeight(height);
    }

    public String getName() { return name; }

    @Override
    public int hashCode() { return name.length()*115+getX()+getY()*getHeight(); }
}
