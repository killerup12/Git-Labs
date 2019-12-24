public class Surf extends Places implements  MakeAWave, MakeMusic,Grammar
{
    Surf(String name, Places place)
    {
        super(name, place.getX(), place.getY(), place.getHeight());
    }

    @Override
    public String makeMusic()
    {
        return "*loud noise*";
    }

    @Override
    public String makeMusic(Places place)
    {
        if (place.getHeight() < 10) { return "*not loud noise*"; }
        return "*very loud moise*";
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
