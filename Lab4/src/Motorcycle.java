public class Motorcycle extends Transport implements Noise, RePlace, Grammar, MoveAble
{
    Motorcycle (String name, String colour, int speed, Places position)
    {
        super (name, colour, speed, position);
    }

    @Override
    public void goTo(Places position)
    {
        setX(position.getX());
        setY(position.getY());
        setHeight(position.getHeight());
        System.out.print("rode to " + getPosition().getName() +" ("+ toString() + ")");
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
