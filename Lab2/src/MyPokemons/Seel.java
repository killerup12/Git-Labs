package MyPokemons;

import ru.ifmo.se.pokemon.*;

public class Seel extends Pokemon
{
    public Seel(String name, int lvl)
    {
        super(name, lvl);
        setType(Type.WATER);
        setStats(106.00d, 90.00d, 130.00d, 110.00d, 90.00d, 154.00d);
        setMove(new Facade(), new Confide(), new DoubleTeam());
    }

    class Facade extends PhysicalMove
    {
        public Facade() {super(Type.NORMAL, 70.00d, 100.00d);}
    }

    class Confide extends StatusMove
    {
        public Confide(){super(Type.NORMAL, 0.00d, 0.00d);}
    }

    class DoubleTeam extends StatusMove
    {
        public DoubleTeam(){super(Type.NORMAL, 0.00d, 0.00d);}
    }
}

