abstract class Transport extends XYZ
{
    private String name;
    private String colour;
    private int speed;


    public String getName() { return name; }
    public String getColour() { return colour; }
    public int getSpeed() { return speed; }



    Transport (String name, String colour, int speed, Places position)
    {
        this.name = name;
        this.colour = colour;
        this.speed = speed;
        setPosition(position);
        setX(x);
        setY(y);
        setHeight(height);
    }

    @Override
    public int hashCode()
    {
        return 13+115*getHeight()+234*name.length();
    }
}
