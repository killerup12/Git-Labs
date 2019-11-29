abstract class Human extends XYZ
{
    private String name;
    private String gender;
    private boolean mood;
    private String handCondition = "nothing";

    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getMood() { if (mood) return "happy"; return "unhappy"; }
    public void setMood(boolean mood) { this.mood = mood; }
    public String getHandCondition() { return handCondition; }
    public void setHandCondition(String handCondition) { this.handCondition = handCondition; }
    public String CheckMood(boolean mood) //Displays the mood of the character
    {
        if (mood) return "happy";
        else return "unhappy";
    }




    Human (String name, String gender, boolean mood,
           Places position)
    {
        this.name = name;
        this.gender = gender;
        this.mood = mood;
        setPosition(position);
        setX(position.getX());
        setY(position.getY());
        setHeight(position.getHeight());
    }

    @Override
    public boolean equals(java.lang.Object other)
    {
        if (other == null) return false;
        if(!super.equals(other)) return false;
        if (this == other) return true;
        if(this.getClass() != other.getClass()) return false;
        Human otherObj = (Human) other;
        return this.getHeight() == otherObj.getHeight();
    }

    @Override
    public int hashCode()
    {
        return 666+23*getHeight()*name.length();
    }
}