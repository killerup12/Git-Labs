package Animal;

abstract class Animal
{
    private String name;
     private boolean mood;
      private String position;
       private int height;

     public String getName() { return name; }
      public String getMood()
      {
          if (mood)
          {
              return "happy";
          }
          else
          {
              return "unhappy";
          }
      }
      public String getPosition() { return position; }
    public int getHeight() { return height; }

    Animal (String name, boolean mood, String position, int height)
    {
        this.name = name;
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
          Animal otherObj = (Animal) other;
         return this.height == otherObj.height;
    }

    @Override
    public int hashCode()
    {
        return 13+115*height+34*position.length()*name.length();
    }
}
