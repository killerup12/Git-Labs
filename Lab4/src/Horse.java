public class Horse extends Animal implements Noise, Grammar, MoveAble, RePlace
{
    Horse (String name, String gender, String colour, boolean mood,
          Places position)
    {
        super(name, gender, colour, mood, position);
    }

    @Override
    public void goTo(Places place)
    {
        setX(place.getX());
        setY(place.getY());
        setHeight(place.getHeight());
        System.out.print("go to " + place.getPosition().getName() +" ("+ toString() +")");
    }

    @Override
    public String pronoun()
    {
        if (getGender().equals("animal)")) return "it";
        else return "they";
    }

    @Override
    public String prepositions()
    {
        if (pronoun().equals("it")) return "is";
        else return "are";
    }

    @Override
    public String makeASound() { return "*clatter of hooves*"; }

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