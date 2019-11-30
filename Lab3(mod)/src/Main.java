public class Main
{
    public static void main(String[] args)
    {
        Haven heaven = new Haven("heaven", 0, 0, 30000);
        Flats startFlat = new Flats("start flat", 0, 0, 9);
        Flats anotherFlat1 = new Flats("unknown flat 1", -5, 0, 10);
        Flats anotherFlat2 = new Flats("unknown flat 2", -3, 2, 10);
        Streets street = new Streets("street", 10, 10, 0);
        Streets street2 = new Streets("another street", 200, 10, 0);
        Parks park = new Parks("park", 12, 10, 0);
        Parks tree = new Parks("tree", 12, 10, 5);
        Item trees = new Item("trees", "things", "brawn", 1, 3, 1, park);
        Item sky = new Item("sky", "thing", "blue", 0, 4, 0, heaven);
        Item houses = new Item("houses", "things", null, 0, 1, 0, street);
        Item treeLeaves = new Item("tree leaves", "things", "green", 3, 3, 0, tree);
        Item dishes = new Item("dishes", "thing", "white", 2, 3, 3, anotherFlat2);
        Motorcycle motorcycle = new Motorcycle("motorcycle", "black", 60, street);
        Cart cart = new Cart("cart", "brawn", 5, street);
        Roofs startFlatsRoof = new Roofs("start Flat's Roof", 0, 0, 15);
        BookPers malish = new BookPers("Malish", "male", true, startFlat);
        BookPers karlson = new BookPers("Karlson", "male", true, startFlat);
        BookPers unknownHuman1 = new BookPers("unknown human 1", "male", true, anotherFlat1);
        BookPers unknownHuman2 = new BookPers("unknown human 2", "female", true, anotherFlat1);
        BookPers unknownHuman3 = new BookPers("unknown human 3", "female", false, anotherFlat2);
        Musician musician = new Musician("unknown musician", "male", true, anotherFlat2);
        Child unknownChild1 = new Child("unknown child 1", "male", true, anotherFlat1);
        Child unknownChild2 = new Child("unknown child 2", "female", false, anotherFlat1);
        Dog unknownDog = new Dog("unknown dog", "animal", "brawn", true, street);
        Horse horse = new Horse("unknown horse", "animal", "white", true, street);





        System.out.print(malish.getName() +" "+ malish.sayOk(2) +". ");
        System.out.print(malish.pronoun() +" "+ malish.takeHand(karlson) +" and "+ malish.goTo(startFlatsRoof) +", \n");
        System.out.print(karlson.getName() +" "+ malish.goTo(startFlatsRoof) + ". ");
        System.out.print(TimesOfDay.EVENING + ". ");
        System.out.print(sky.getName() +" "+ sky.prepositions() +" "+ sky.getColour() +", ");
        System.out.print(houses.getName() +" "+ houses.prepositions() +" "+ houses.getDegreeOfIllumination() + ", \n");
        System.out.print(malish.getName() +" "+ malish.relativeLevel(park) +" "+ park.getName() +". ");
        System.out.print(treeLeaves.getName() +" "+ treeLeaves.getOdorConcentration() +". ");
        System.out.print(unknownHuman1.getName() +" from "+ unknownHuman1.getPosition().getName() +" "+ malish.listen(unknownHuman1) + ", \n");
        System.out.print(unknownHuman2.getName() +" from "+ unknownHuman2.getPosition().getName() +" "+ malish.listen(unknownHuman2) +". ");
        System.out.print(unknownChild1.getName() +" "+ unknownChild1.prepositions() +" "+ unknownChild1.laugh() +", ");
        System.out.print(unknownChild2.getName() +" "+ unknownChild2.prepositions() +" "+ unknownChild2.cry() +". \n");
        System.out.print(unknownHuman3.getName() +" "+ unknownHuman3.prepositions() + " " + unknownHuman3.wash(dishes) +". ");
        System.out.print(unknownDog.getName() +" "+ unknownDog.prepositions() +" making: "+ unknownDog.makeASound() +". ");
        System.out.print(musician.getName() +" "+ musician.prepositions() +" making: "+ musician.makeMusic() +". \n");
        System.out.print(motorcycle.getName() +" "+ motorcycle.prepositions() +" making: "+ motorcycle.makeASound()
                +", "+ motorcycle.pronoun() +" "+ motorcycle.goTo(street2));
        System.out.print(horse.getName() +" "+ horse.prepositions() +" making: "+ horse.makeASound() +", \n");
        System.out.print(cart.getName() +" "+ cart.prepositions() +" making: "+ cart.makeASound());
        System.out.print("\n");
        System.out.print(motorcycle.toString());



    }
}