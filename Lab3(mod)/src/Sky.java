public class Sky extends Object implements Grammar
{

    Sky(String name, String gender, String colour, int odorConcentration,
         int degreeOfIllumination, int degreeOfPurity, Places position)
    {
        super(name, gender, colour, odorConcentration,
                degreeOfIllumination, degreeOfPurity,
                position);
    }

    @Override
    public String pronoun()
    {
        return "it";
    }

    @Override
    public String prepositions()
    {
        return "is";
    }
}
