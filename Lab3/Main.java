import Environment.Unit;
import Environment.TimeOfDay;
import Animal.Dog;
import People.BookPers;


public class Main
{
    public static void main(String[] args)
    {
        BookPers karlson = new BookPers("Karlson", "male", true, "home", 10);
         BookPers malish = new BookPers("Malish", "male", true, "home", 10);
          BookPers human1InAFlat = new BookPers("unknown human 1", "unknown", true, "window", 10);
           BookPers human2InAFlat = new BookPers("unknown human 2", "unknown", true, "window", 10);
          BookPers human3InAFlat = new BookPers("unknown human 3", "unknown", true, "kitchen", 10);
         BookPers human4InAFlat = new BookPers("unknown human 4", "unknown", true, "flat", 10);
        BookPers Izvozchik = new BookPers("Izvozchik", "unknown", false, "street", 0);
         BookPers Biker = new BookPers("biker", "unknown", true, "street", 0);
          BookPers child1 = new BookPers("unknown child 1", "unknown", true, "children's room", 10);
           BookPers child2 = new BookPers("unknown child 2", "unknown", false, "children's room", 10);
          Unit roof = new Unit("roof", "house", "thing", 0, null, 2, 15);
         Unit sky = new Unit("sky", "up ground", "thing", 0, "blue", 3, 500000);
        Unit houses = new Unit("houses", "street", "things", 0, null, 2, 15);
         Unit park = new Unit("park", "out sight", "thing", 0, "green", 3, 0);
          Unit treeLeaves = new Unit("leaves of trees", "tree", "things", 3, "green", 3, 10);
           Unit crockery = new Unit("crockery", "flat", "thing", 0, null, 0, 10);
          Unit motorcycle = new Unit("motorcycle", "street", "thing", 0, null, 0, 0);
         Dog dog = new Dog("unknown dog", true, "street", 0);


        System.out.print(malish.CheckMood(malish.getMood()) + " " + malish.getName() + " " + malish.SayOk(2) + ". ");

        System.out.print(malish.Pronoun(malish.getGender()) + " " + malish.TakeHand(karlson.getName()) + ", and " + malish.getName() +
                        " " + malish.GoTo(roof.getTitle(), roof.getHeight()) + " " + "(" + malish.getName() + " " + malish.toString() + ")"
                + ", \n" + karlson.getName() + " " + karlson.GoTo(roof.getTitle(), roof.getHeight()) + " " + "(" + karlson.getName() + " " + karlson.toString() + ")" + ". ");

        System.out.print(TimeOfDay.EVENING + ", \n" + sky.getTitle() + " " + sky.Prepositions(sky.getGender()) + " " +
                sky.getColour() + ", " + houses.getTitle() + " " + houses.Prepositions(houses.getGender()) + " " +
                houses.DegreeOfIllumination(houses.getDegreeOfIllumination())  + ". ");
        System.out.print(park.getColour() + " " + park.getTitle() + " " + park.RelativeLevel(park.getHeight(), malish.getHeight()) + ", " +
                treeLeaves.getTitle() + " " + treeLeaves.EmilASmell(treeLeaves.getOdorConcentration()) + ". \n");

        System.out.print(human1InAFlat.getName() + " " + human1InAFlat.SwallowWords() + ", " + human2InAFlat.getName() + " " +
                human2InAFlat.SwallowWords() + ". \n" + child1.getName() + " " + child1.MakeASound(child1.getGender()) + " " +
                child1.Laugh() + " from "  + child1.getPosition() + ", " + child2.getName() + " " + child2.MakeASound(child2.getGender())
                + " " + child2.Cry() + "\n" + "from " + child2.getPosition() + ". " + human3InAFlat.getName() + " " +
                human3InAFlat.WashDishes() + ". " + dog.getName() + " makes a sound: " + dog.MakeANoise());
    }
}