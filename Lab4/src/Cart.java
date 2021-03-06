public class Cart extends Transport implements Grammar, Noise
{
    Cart(String name, String colour, int speed, Places position) {
        super(name, colour, speed, position);
    }

    @Override
    public String pronoun() { return "it"; }

    @Override
    public String prepositions() { return "is"; }

    @Override
    public String makeASound() { return "*rumble cart*"; }
}