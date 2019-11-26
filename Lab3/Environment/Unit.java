package Environment;

public class Unit extends Object implements ObjectInterface
{

    public Unit(String title,  String place, String gender, int odorConcentration, String colour, int degreeOfIllumination, int hight) {
        super(title, place, gender, odorConcentration, colour, degreeOfIllumination, hight);
    }


    @Override
    public boolean equals(java.lang.Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return (obj.hashCode() == this.hashCode()) ? true : false;

    }

    @Override
    public String toString() { return "numerical value height: " + getHeight() + "m"; }


    @Override
    public String DegreeOfIllumination(int degreeOfIllumination)
    {
        if (degreeOfIllumination == 0)
        {
            return "invisible";
        }
        else if (degreeOfIllumination == 1)
        {
            return "dark";
        } else if (degreeOfIllumination == 2)
        {
            return "not very distinguishable";
        }
        else if (degreeOfIllumination == 3)
        {
            return "distinguishable";
        }
        else
        {
            return "very noticeable";
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
    public String Prepositions(String gender)
    {
        if (Pronoun(gender).equals("he")
                || Pronoun(gender).equals("she")
                || Pronoun(gender).equals("it")) {
            return "is";
        } else if (Pronoun(gender).equals("they")) {
            return "are";
        } else {
            return "am";
        }
    }

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
            return "at one height level";
        }
    }

    @Override
    public String EmilASmell(int odorConcentration)
    {
        if (odorConcentration == 0)
        {
            return "have not smell";
        }
        else if (odorConcentration == 1)
        {
            return "have a faint smell";
        }
        else if (odorConcentration == 2)
        {
            return "have a smell";
        }
        else if (odorConcentration == 3)
        {
            return "have a strong smell";
        }
        else if (odorConcentration == 4)
        {
            return "extremely strong odor";
        }
        else
        {
            return null;
        }
    }
}
