package MyPokemons;

import ru.ifmo.se.pokemon.*;

public class Whirlipede extends Pokemon
{
    public Whirlipede(String name, int lvl)
    {
        super (name, lvl);
        setType(Type.BUG, Type.POISON);
        setStats(40.00d, 55.00d, 99.00d, 47.00d, 40.00d, 79.00d);
        setMove(new RockSlide(), new Rest(), new SmellingSalts());
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
}
