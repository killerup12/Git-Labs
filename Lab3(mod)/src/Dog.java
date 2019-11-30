
public class Dog extends Animal implements Noise, Grammar, Coordinates
{
    public Dog (String name, String gender, String colour, boolean mood,
                Places position)
    {
        super(name, gender, colour, mood, position);
    }

    @Override
    public String pronoun()
    {
        if (getGender().equals("animal")) return "it";
        else return "they";
    }

    @Override
    public String prepositions()
    {
        if (pronoun().equals("it")) return "is";
        else return "are";
    }

    @Override
    public String goTo(Places place)
    {
        setX(place.getX());
        setY(place.getY());
        setHeight(place.getHeight());
        return "went to " + place.getPosition().getName() + " ("+ toString() +")";
    }

    @Override
    public String relativeLevel(XYZ obj)   //+
    {
        if (getHeight() < obj.getHeight()) return "below";
        if (getHeight() > obj.getHeight()) return "above";
        else return "at one height level";
    }

    public String makeASound() { return "WOF-WOF!"; }
}
