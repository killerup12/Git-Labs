public class Crevices extends Places implements Grammar
{

    Crevices(String name, int x, int y, int height)
    {
        super(name, x, y, height);
    }

    @Override
    public String getDegreeOfIllumination()
    {
        return "dark";
    }


    @Override
    public String pronoun() {
        return "it";
    }

    @Override
    public String prepositions() {
        return "is";
    }
}
