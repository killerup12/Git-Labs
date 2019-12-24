import java.io.IOException;

public class Main implements RelativeLevel
{
    private Personages malish;

    public static void main(String[] args) throws NullPointerException, ObjectAvailabilityCheckException {
        DayStatus dayStatus = new DayStatus(TimesOfDay.DAY);

        /*
        WalkOnRoofsException walkOnRoofsException = new WalkOnRoofsException("Checking time of day:" + dayStatus.getTimesOfDay());
        ObjectAvailabilityCheckException objectAvailabilityCheckException = new ObjectAvailabilityCheckException("");
*/
        Roofs startFlatsRoof = new Roofs("start Flat's Roof", 0, 0, 15);
        Flats startFlat = new Flats("start flat", 0, 0, 9);
        Flats anotherFlat1 = new Flats("unknown flat 1", -5, 0, 10);
        Flats anotherFlat2 = new Flats("unknown flat 2", -3, 2, 10);
        Streets street = new Streets("street", 10, 10, 0);
        Streets street2 = new Streets("another street", 200, 10, 0);
        Parks park = new Parks("park", 12, 10, 0);
        Parks tree = new Parks("tree", 12, 10, 5);

        Island island = new Island("island", 700, 654, 0);
        Island.FrontSightIsland frontSightIsland = island.new FrontSightIsland ("front sight island",600, 654, 0);

        Crevices crevices = new Crevices("crevices", 800, 654, -10);

        Sea sea = new Sea("sea", 728, 654, 0);

        Surf strongWater = new Surf("strong water", crevices);

        Rocks rock = new Rocks("rock", 9, frontSightIsland);

        SandPad sandPad = new SandPad("sand pad", 720, 650, 10);

        Place place1 = new Place("place 1", 700, 650, 0);
        Place place2 = new Place("place 2", 700, 650, 11);

        Item trees = new Item("trees", "things", "brawn", 1, 3, 1, park);
        Item houses = new Item("houses", "things", null, 0, 3, 0, street);
        Item treeLeaves = new Item("tree leaves", "things", "green", 3, 3, 0, tree);
        Item dishes = new Item("dishes", "thing", "white", 2, 3, 3, anotherFlat2);
        Item shell1 = new Item("shell", "thing", "orange", 1, 2, 0, sandPad);
        Item shell2 = new Item("shell", "thing", "white", 1, 2, 0, sandPad);

        Motorcycle motorcycle = new Motorcycle("motorcycle", "black",60, street);
        Cart cart = new Cart("cart", "brawn", 5, street);

        Personages malish = new Personages("Malish", "male", true, startFlat);
        Personages karlson = new Personages("Karlson", "male", true, startFlat);
        Personages unknownHuman1 = new Personages("unknown human 1", "male", true, anotherFlat1);
        Personages unknownHuman2 = new Personages("unknown human 2", "female", true, anotherFlat1);
        Personages unknownHuman3 = new Personages("unknown human 3", "female", false, anotherFlat2);
        Musician musician = new Musician("unknown musician", "male", true, anotherFlat2);
        Child unknownChild1 = new Child("unknown child 1", "male", true, anotherFlat1);
        Child unknownChild2 = new Child("unknown child 2", "female", false, anotherFlat1);

        Mermaid mermaid = new Mermaid("Unknown mermaid", "female", false, crevices);

        Horse unknownDog = new Horse("unknown dog", "animal", "brawn", true, street)
        {
            public String makeASound() { return "WAF-WAF!"; }
        };
        Horse horse = new Horse("unknown horse", "animal", "white", true, street);

        System.out.print(malish.getName() +" "+ malish.sayOk(2) +". ");
        System.out.print(malish.pronoun() +" "+ malish.takeHand(karlson) +". ");
                try {malish.goToTheRoof(startFlatsRoof);}
                catch (WalkOnRoofsException e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Checking time of day: " + dayStatus.getTimesOfDay());
                }
                catch (NullPointerException e)
                {
                    System.out.print(malish.getName() +" can't go to there! ");
                }
                finally
                {
                    System.out.print(". \n");
                }
        System.out.print(karlson.getName() +" ");
            try {karlson.goToTheRoof(startFlatsRoof);}
            catch (WalkOnRoofsException e)
            {
                System.out.println(e.getMessage());
                System.out.println("Checking time of day: " + dayStatus.getTimesOfDay());
            }
            catch (NullPointerException e)
            {
                System.out.print(karlson.getName() +" can't go to there! ");
            }
            finally
            {
                System.out.print(". ");
            }
        System.out.print(DayStatus.getTimesOfDay() + ". ");
        System.out.print(Places.sky.getName() +" "+ Places.sky.prepositions() +" "+ Places.sky.getColour() +", ");
        System.out.print(houses.getName() +" "+ houses.prepositions() +" "+ houses.getDegreeOfIllumination() + ", \n");
        System.out.print(malish.getName() +" "+ RelativeLevel.relativeLevel(malish , park) +" "+ malish.getName() +" "+ park.getName() +". ");
        System.out.print(treeLeaves.getName() +" "+ treeLeaves.getOdorConcentration() +". ");
        System.out.print(unknownHuman1.getName() +" from "+ unknownHuman1.getPosition().getName() +" "+ malish.listen(unknownHuman1) + ", \n");
        System.out.print(unknownHuman2.getName() +" from "+ unknownHuman2.getPosition().getName() +" "+ malish.listen(unknownHuman2) +". ");
        System.out.print(unknownChild1.getName() +" "+ unknownChild1.prepositions() +" "+ unknownChild1.laugh() +", ");
        System.out.print(unknownChild2.getName() +" "+ unknownChild2.prepositions() +" "+ unknownChild2.cry() +". \n");
        System.out.print(unknownHuman3.getName() +" "+ unknownHuman3.prepositions() + " " + unknownHuman3.wash(dishes) +". ");
        System.out.print(unknownDog.getName() +" "+ unknownDog.prepositions() +" making: "+ unknownDog.makeASound() +". ");
        System.out.print(musician.getName() +" "+ musician.prepositions() +" making: "+ musician.makeMusic() +". \n");
        System.out.print(motorcycle.getName() +" "+ motorcycle.prepositions() +" making: "+ motorcycle.makeASound()
                +", "+ motorcycle.pronoun() +" ");



        System.out.print(horse.getName() +" "+ horse.prepositions() +" making: "+ horse.makeASound() +", \n");
        System.out.print(cart.getName() +" "+ cart.prepositions() +" making: "+ cart.makeASound() +". ");
        System.out.print(sea.getName() +" "+ sea.makeAWave() +". ");
        System.out.print(rock.getName() +" in "+ sea.getName() +". ");
        System.out.print(sandPad.toString() +". \n");
        System.out.print(shell1.getName() +" "+ shell1.getPosition() +".");
        System.out.print(shell2.getName() +" "+ shell2.getPosition() +". ");
        System.out.print(crevices.getName() +" "+ crevices.prepositions() +" "+ crevices.getDegreeOfIllumination() +". ");
        System.out.print(mermaid.getName() +" \n"+ mermaid.getPosition() +". ");
        System.out.print(strongWater.getName() +" "+ strongWater.makeAWave() +" "+ strongWater.makeMusic() +". ");
        System.out.print("In "+ place1.getName() +" "+ strongWater.getName() +" makes "+ strongWater.makeMusic(place1) +". ");
        System.out.print("In "+ place2.getName() +" "+ strongWater.getName() +" makes "+ strongWater.makeMusic(place2) +". ");
    }
}