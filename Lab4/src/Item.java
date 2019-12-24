public class Item extends Object implements Smell, Grammar
{
    public Item(String name, String gender, String colour, int odorConcentration,
                int degreeOfIllumination, int degreeOfPurity, Places position)
    {
        super(name, gender, colour, odorConcentration,
                degreeOfIllumination, degreeOfPurity,
                position);
    }

    @Override
    public String pronoun()    //+
    {
        if (getGender().equals("thing")) return "it";
        else return "they";
    }

    @Override
    public String prepositions()   //+
    {
        if (pronoun().equals("it")) return "is";
        else return "are";
    }

    @Override
    public   String emilASmell(int odorConcentration) //Here is local class! Here is local class! Here is local class!
    {
        class IHaveNoIdeaHowToRealizeThisLocalClass    //There it is!
        {
            void printSomething() { System.out.print(" let's imagine something important here "); }
            // WOW!!!
        }

        if (odorConcentration == 0) return "have not smell";
        else if (odorConcentration == 1) return "have a faint smell";
        else if (odorConcentration == 2) return "have a smell";
        else if (odorConcentration == 3) return "have a strong smell";
        else if (odorConcentration == 4) return "extremely strong odor";
        else return null;
    }
}