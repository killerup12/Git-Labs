abstract class Animal extends XYZ
{
    private String name;
    private String gender;
    private String colour;
    private boolean mood;

    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getColour() { return colour; }
    public String getMood() { if (mood) return "good"; else return "wicked"; }
    protected void setMood(boolean mood) { this.mood = mood; }

    Animal (String name, String gender, String colour, boolean mood,
            Places position)
    {
        super(getTimesOfDay());
        this.name = name;
        this.gender = gender;
        this.colour = colour;
        this.mood = mood;
        setPosition(position);
        setX(x);
        setY(y);
        setHeight(height);

    }

    @Override
    public int hashCode()
    {
        return 13+115*getHeight()+34*name.length();
    }
}
