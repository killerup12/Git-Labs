abstract class Object extends XYZ
{
    private String name;
    private String colour;
    private String gender;
    private int odorConcentration;  //may take values from 0 to 3
    private int degreeOfIllumination;    //may take values from 0 to 4
    private int degreeOfPurity;     //may take values from 0 to 3

    public String getName() { return name; }
    public String getColour() { return colour; }
    public String getGender() { return gender; }
    public String getOdorConcentration()
    {
        if (odorConcentration == 0) return "do not odor";
        if (odorConcentration == 1) return "smells a little";
        if (odorConcentration == 2) return "smells";
        else return "smells great";
    }
    protected void setOdorConcentration(int odorConcentration) { this.odorConcentration = odorConcentration; }
    public String getDegreeOfIllumination()
    {
        if (degreeOfIllumination == 0) return "invisible";
        if (degreeOfIllumination == 1) return "dark";
        if (degreeOfIllumination == 2) return "not very distinguishable";
        if (degreeOfIllumination == 3) return "distinguishable";
        else return "very noticeable";
    }
    public void setDegreeOfIllumination(int degreeOfIllumination) {this.degreeOfIllumination = degreeOfIllumination;}
    public String getDegreeOfPurity()
    {
        if (degreeOfPurity == 0) return "very dirty";
        if (degreeOfPurity == 1) return "dirty";
        if (degreeOfPurity == 2) return "little dirty";
        else return "clear";
    }
    public void setDegreeOfPurity(int degreeOfPurity)
    {
        this.degreeOfPurity = degreeOfPurity;
    }

    Object (String name, String gender, String colour, int odorConcentration,
           int degreeOfIllumination, int degreeOfPurity, Places position)
    {
        this.name = name;
        this.gender = gender;
        this.colour = colour;
        this.odorConcentration = odorConcentration;
        this.degreeOfIllumination = degreeOfIllumination;
        this.degreeOfPurity = degreeOfPurity;
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
        Object otherObj = (Object) other;
        return this.getHeight() == otherObj.getHeight();
    }

    @Override
    public int hashCode()
    {
        return 13+115*getHeight()+degreeOfIllumination*odorConcentration*name.length();
    }
}
