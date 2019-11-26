package MyPokemons;

import ru.ifmo.se.pokemon.*;

public class Lugia extends Pokemon
{
    public Lugia(String name, int lvl)
    {
        super(name, lvl);
        setType((Type.NORMAL));
        setStats(106.00d, 90.00d, 130.00d, 110.00d, 90.00d, 154.00d);
        setMove(new ShadowBall(),new Overheat(),new StoneEdge(),new SteelWing());
    }

    class ShadowBall extends SpecialMove
    {
        public ShadowBall() {super(Type.GRASS, 90.00d, 100.00d);}
    }

    class Overheat extends SpecialMove
    {
        public Overheat() {super(Type.FIRE, 130.00d, 90.00d);}
    }

    class StoneEdge extends  PhysicalMove
    {
        public StoneEdge() {super(Type.FIRE, 100.00d, 80.00d);}
    }

    class SteelWing extends PhysicalMove
    {
        public SteelWing() {super (Type.FIRE, 70.00d, 90.00d); }
    }
}