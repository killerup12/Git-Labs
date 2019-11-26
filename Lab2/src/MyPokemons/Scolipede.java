package MyPokemons;

import ru.ifmo.se.pokemon.*;

public class Scolipede extends Pokemon
{
    public Scolipede(String name, int lvl)
    {
        super(name, lvl);
        setType(Type.BUG, Type.POISON);
        setStats(60.00d, 100.00d, 89.00d, 112.00d, 55.00d, 69.00d);
        setMove(new RockSlide(), new Rest(), new SmellingSalts(), new AerialAce());
    }

    class RockSlide extends PhysicalMove
    {
        public RockSlide(){super(Type.ROCK, 75.00d, 90.00d);}
    }

    class Rest extends PhysicalMove
    {
        public Rest(){super(Type.NORMAL, 0.00d, 0.00d);}
    }

    class SmellingSalts extends PhysicalMove
    {
        public SmellingSalts() {super(Type.NORMAL, 70.00d, 100.00d);}
    }

    class AerialAce extends PhysicalMove
    {
        public AerialAce(){super(Type.FLYING, 60.00d, 1.0/0.0);}
    }

}
