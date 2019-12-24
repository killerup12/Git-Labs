public class Mermaid extends Human implements Dance, Grammar
{
    Mermaid(String name, String gender, boolean mood, Places position)
    {
        super(name, gender, mood, position);
    }

    @Override
    public String dance()
    {
        setX(getX()+1);
        setY(getY()+1);
        setX(getX()-1);
        setY(getY()-1);
        return toString();
    }

    @Override
    public String pronoun()
    {
        return "she";
    }

    @Override
    public String prepositions()
    {
        return "is";
    }
}
