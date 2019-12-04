public class Child extends Human implements Emotions, Grammar
{

    Child(String name, String gender, boolean mood, Places position)
    {
        super(name, gender, mood, position);
    }

    @Override
    public String laugh() { setMood(true); return "*laugh*"; }

    @Override
    public String cry() { setMood(false); return "*crying*"; }

    @Override
    public String pronoun()
    {
        if (getGender().equals("male")) return "he";
        else return "she";
    }

    @Override
    public String prepositions() { return "is"; }
}
