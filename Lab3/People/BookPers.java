package People;

public class BookPers extends Human implements HumanInterface
{
    public BookPers(String name, String gender, boolean mood, String position, int hight)
    {
        super (name, gender, mood, position, hight);
    }


    @Override
    public String toString() { return "numerical value height: " + getHeight() + "m"; }


    @Override
    public String SayOk(int degreeOfAgreement)
    {
        if (degreeOfAgreement == 0)
        {
            return "said no";
        }
        else if (degreeOfAgreement == 1)
        {
            return "said ok";
        }
        else
        {
            return "said sure";
        }
    }

    @Override
    public String SwallowWords() { return "says something very inaudible"; }

    @Override
    public String Laugh() { return "*laugh*"; }

    @Override
    public String Cry() { return "*crying*"; }

        @Override
        public String WashDishes() { return "is washing dishes"; }

        @Override
        public String MakeASound(String gender)
        {
            if (gender.equals("male") || gender.equals("female")
                || gender.equals("thing") || gender.equals("unknown")) return "makes a sound:";

            else return "make a sound:";
        }

        @Override
        public String TakeHand(String name)
        {
        setHandCondition(name);
        return "take a hand of" + " " + name;
        }

        @Override
        public String GoTo(String place, int height)
        {
            setHeight(height);
            setPosition(place);
            return "go to " + place;
        }

    @Override
    public String CheckMood (boolean mood)
    {
        if (mood)
        {
            return "happy";
        }
        else
        {
            return "unhappy";
        }
    }

        @Override
        public String Pronoun(String gender)
        {
            if (gender.equals("male"))
            {
                return "he";
            }
            else if (gender.equals("female"))
            {
                return "she";
            }
            else if (gender.equals("thing") || gender.equals("animal)") || gender.equals("unknown"))
            {
                return "it";
            }
            else
            {
                return "they";
            }
        }

        @Override
        public String Prepositions(String pronoun)
        {
            if (pronoun.equals("he") || pronoun.equals("she") || pronoun.equals("it"))
            {
                return "is";
            }
            if (pronoun.equals("they"))
            {
                return "are";
            }
            return "am";
        }

    @Override
    public void UpDown(int height) { setHeight(height); }

    @Override
    public String RelativeLevel(int height1, int height2)
    {
        if (height1 < height2)
        {
            return "below";
        }
        else if (height1 > height2)
        {
            return "above";
        }
        else
        {
            return null;
        }
    }

    @Override
    public String Play(String game ,String host, String partner) { return host + " is playing " + game + " with " + partner; }
}