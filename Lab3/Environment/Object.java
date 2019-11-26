package Environment;

abstract class Object
{
    private String title;
     private String colour;
      private int degreeOfIllumination;    //may take values from 0 to 4
       private int height;
      private String gender;
     private String place;
    private int odorConcentration;  //may take values from 0 to 4
     private int degreeOfAudibility;     //may take values from 0 to 3

    public String getTitle() { return title; }
     public String getColour() { return colour; }
      public int getDegreeOfIllumination() { return degreeOfIllumination; }
       public int getHeight() { return height; }
      public String getGender() { return gender; }
     public String getPlace() { return place; }
    public int getOdorConcentration() { return odorConcentration; }

    Object(String title, String place, String gender, int odorConcentration,
                  String colour, int degreeOfIllumination,  int height)
    {
        this.title = title;
         this.place = place;
          this.gender = gender;
           this.odorConcentration = odorConcentration;
          this.colour = colour;
         this.degreeOfIllumination = degreeOfIllumination;
        this.height = height;
    }

    @Override
    public boolean equals(java.lang.Object other)
    {
        if (other == null) return false;
         if(!super.equals(other)) return false;
          if (this == other) return true;
           if(this.getClass() != other.getClass()) return false;
          Object otherObj = (Object) other;
         return this.height == otherObj.height;
    }

    @Override
    public int hashCode()
    {
        return 13+115*height+degreeOfIllumination*odorConcentration*title.length();
    }
}
