package Animal;

public class Dog extends Animal implements AnimalInterface
{
    public Dog(String name, boolean mood, String position, int height)
    {
        super(name, mood, position, height);
    }

    @Override
    public String MakeANoise() { return "WOF WOF!"; }
}
