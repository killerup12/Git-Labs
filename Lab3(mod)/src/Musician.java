public class Musician extends BookPers implements MakeMusic
{

    public Musician(String name, String gender, boolean mood, Places position)
    {
        super(name, gender, mood, position);
    }


    @Override
    public String makeMusic() { return "*unknown piano tune*";}
}
