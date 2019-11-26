package People;

abstract class Human
{
    private String name;
     private String gender;
      private boolean mood;
       private String position;
      private String handCondition = "nothing";
     private int height;


    public String getName() { return name; }
     public String getGender() { return gender; }
      public boolean getMood() { return mood; }
       public String getPosition() { return position; }
      public void setPosition(String position) { this.position = position; }
     public String getHandCondition() { return handCondition; }
    public void setHandCondition(String handCondition) { this.handCondition = handCondition; }
     public int getHeight() { return height; }
      public void setHeight(int height) { this.height = height; }

    Human(String name, String gender, boolean mood, String position, int height)
    {
        this.name = name;
         this.gender = gender;
          this.mood = mood;
           this.position = position;
          this.height = height;
    }

    @Override
    public boolean equals(java.lang.Object other)
    {
        if (other == null) return false;
         if(!super.equals(other)) return false;
          if (this == other) return true;
           if(this.getClass() != other.getClass()) return false;
          Human otherObj = (Human) other;
         return this.height == otherObj.height;
    }

    @Override
    public int hashCode()
    {
        return 666+23*height*position.length()*name.length();
    }
}