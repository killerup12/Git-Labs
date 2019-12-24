abstract class Places extends XYZ
{
    private String name;

    Places (String name, int x, int y, int height)
    {
        super(getTimesOfDay());
        this.name = name;
        setX(x);
        setY(y);
        setHeight(height);
    }

    public String getDegreeOfIllumination()
    {
        switch (getTimesOfDay())
        {
            case MORNING: return "not very distinguishable";
            case DAY: return "distinguishable";
            case EVENING: return "dark";
            default: return "invisible";
        }
    }

    public String getName() { return name; }

    @Override
    public int hashCode() { return name.length()*115+getX()+getY()*getHeight(); }





    public static class sky extends XYZ
    {
        private static String name = "sky";
        private static String colour = "blue";

        public static String getName() { return name; }
        public static String getColour() { return colour; }

        public static String pronoun() { return "it"; }
        public static String prepositions() { return "is"; }

        public sky() { super(getTimesOfDay()); }
    }
}
