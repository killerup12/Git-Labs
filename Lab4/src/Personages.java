import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;

public class Personages extends Human implements Speak, Actions, Grammar, MoveAble, GoToTheRoof
{
    Personages(String name, String gender, boolean mood, Places position)
    {
        super (name, gender, mood, position);
    }

    @Override
    public String sayOk(int degreeOfAgreement)
    {
        if (degreeOfAgreement == 0) return "said no";
        else if (degreeOfAgreement == 1) return "said ok";
        else return "said sure";
    }

    @Override
    public String listen(Human object)
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

        MoveAble m = new MoveAble()
        {
            @Override
            public void goTo(Places place) {}
        };

        @Override
        public void goTo(Places place) throws NullPointerException
        {
            try
            {
                setX(place.getX());
                setY(place.getY());
                setHeight(place.getHeight());
                setPosition(place);
                System.out.print("went to " + place.getName() + " (" + toString() + ")");
            }
            catch (NullPointerException e)
            {
                System.out.print(getName() +" can not go to "+ place.getName());
                System.exit(0);
            }
        }

        @Override
        public void goToTheRoof(Roofs roof) throws WalkOnRoofsException {
            System.out.print("trying to go to the " + roof.getName() + ". ");

            try {
                if (DayStatus.getTimesOfDay().equals(TimesOfDay.EVENING)) {
                    setX(roof.getX());
                    setY(roof.getY());
                    setHeight(roof.getHeight());
                    setPosition(roof);
                    System.out.print(getName() + " went to " + roof.getName() + " (" + toString() + ") ");
                }
            } catch (NullPointerException e) {
                System.out.print(" can not go to the " + roof.getName());
            }
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
    public String play(String game ,String host, String partner) { return host + " is playing " + game + " with " + partner; }
}