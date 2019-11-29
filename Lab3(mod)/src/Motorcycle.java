public class Motorcycle extends Transport implements Noise, Move, Grammar, Coordinates
{
    Motorcycle (String name, String colour, int speed, Places position)
    {
        super (name, colour, speed, position);
    }

    @Override
    public String toString() { return " (" + "numerical value height: "
            + "x:" + getX() +" "+ "y: " + getY() +" "+ getHeight() + "m" + ") "; }


    @Override
    public String goTo(Places position)
    {
        setX(position.getX());
        setY(position.getY());
        setHeight(position.getHeight());
        return "rode to " + getPosition().getName() + " (Coordinates: " +
                "x: " + getX() +", "+ " y: " + getY() +", "+ " height: " + getHeight() + ")";
    }

    @Override
    public String relativeLevel(XYZ obj)   //+
    {
        if (getHeight() < obj.getHeight()) return "below ";
        if (getHeight() > obj.getHeight()) return "above";
        else return "at one height level";
    }

    @Override
    public String pronoun() { return "it"; }

    @Override
    public String prepositions() { return "is"; }

    @Override
    public String makeASound() { return "*motorcycle sound*"; }

    @Override
    public String move(XYZ obj, XYZ endPoint)
    {
        setX(endPoint.getX());
        setY(endPoint.getY());
        setHeight(endPoint.getHeight());
        obj.setX(getX());
        obj.setY(getY());
        obj.setHeight(getHeight());
        return toString();
    }

}
