package MyPokemons;

import ru.ifmo.se.pokemon.*;

public class Venipede extends Pokemon
{
    public Venipede(String name, int lvl) {
        super(name, lvl);
        setType(Type.BUG, Type.POISON);
        setStats(30.00d, 45.00d, 59.00d, 57.00d, 30.00d, 39.00d);
        setMove(new RockSlide(), new Rest());
    }

    class RockSlide extends PhysicalMove
    {
        public RockSlide(){super(Type.ROCK, 75.00d, 90.00d);}
    }
    class Rest extends PhysicalMove
    {
        public Rest(){super(Type.NORMAL, 0.00d, 0.00d);}
    }
}
