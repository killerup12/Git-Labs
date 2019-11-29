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

    Animal (String name, String gender, String colour, boolean mood,
            Places position)
    {
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
    public boolean equals(java.lang.Object other)
    {
        if (other == null) return false;
         if(!super.equals(other)) return false;
          if (this == other) return true;
           if(this.getClass() != other.getClass()) return false;
          Animal otherObj = (Animal) other;
         return this.getHeight() == otherObj.getHeight();
    }

    @Override
    public int hashCode()
    {
        return 13+115*getHeight()+34*name.length();
    }
}
