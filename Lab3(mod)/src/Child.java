public class Child extends Human implements Actions, Grammar
{

    Child(String name, String gender, boolean mood, Places position)
    {
        super(name, gender, mood, position);
    }

    @Override
    public String play(String game ,String host, String partner) { return host + " is playing " + game + " with " + partner; }

    @Override
    public String takeHand(Human pers)
    {
        setHandCondition(pers.getName());
        pers.setHandCondition(getName());
        return "take a hand of" + " " + pers.getName();
    }

    @Override
    public String laugh() { setMood(true); return "*laugh*"; }

    @Override
    public String cry() { setMood(false); return "*crying*"; }

    @Override
    public String wash(Item unit) {
        return null;
    }

    @Override
    public String pronoun()
    {
        if (getGender().equals("male")) return "he";
        else return "she";
    }

    @Override
    public String prepositions() { return "is"; }
}
