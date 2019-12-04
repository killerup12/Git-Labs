
public class BookPers extends Human implements Speak, Actions, Grammar, MoveAble
{
    public BookPers(String name, String gender, boolean mood, Places position)
    {
        super (name, gender, mood, position);
    }

    @Override
    public String sayOk(int degreeOfAgreement) //+
    {
        if (degreeOfAgreement == 0) return "said no";
        else if (degreeOfAgreement == 1) return "said ok";
        else return "said sure";
    }

    @Override
    public String listen(Human object)  //+
    {
        if ((Math.abs(getX() - object.getX()) > 5) ||
                (Math.abs(getX() - object.getY()) > 5) ||
                (Math.abs(getX() - object.getHeight()) > 5)) return "speaks inaudibly";

        else return "*dialogue*";
    }

        @Override
        public String wash(Item unit)
        {
            unit.setDegreeOfPurity(3);
            unit.setOdorConcentration(1);
            return "washing " + unit.getName();
        }

        @Override
        public String takeHand(Human pers) //+
        {
            setHandCondition(pers.getName());
            pers.setHandCondition(getName());
            return "take a hand of" + " " + pers.getName();
        }

        @Override
        public String goTo(Places place)
        {
            setX(place.getX());
            setY(place.getY());
            setHeight(place.getHeight());
            setPosition(place);
            return "went to " + place.getName() +" ("+ toString() +")";
        }

        @Override
        public String pronoun()
        {
            if (getGender().equals("male")) return "he";
            else return "she";
        }

        @Override
        public String prepositions() { return "is"; }


    @Override
    public String relativeLevel(XYZ obj)   //+
    {
        if (getHeight() < obj.getHeight()) return "below";
        if (getHeight() > obj.getHeight()) return "above";
        else return "at one height level";
    }

    @Override
    public String play(String game ,String host, String partner) { return host + " is playing " + game + " with " + partner; }

}