package MyPokemons;

import ru.ifmo.se.pokemon.*;

public class Dewgong extends Pokemon
{
    double b;
    public Dewgong(String name, int lvl)
    {
        super(name, lvl);
        setType(Type.WATER, Type.ICE);
        setStats(90.00d, 70.00d, 80.00d, 70.00d, 70.00d, 95.00d);
        setMove(new Facade(),new Confide(), new DoubleTeam(), new LeechLife());
    }

    class Facade extends PhysicalMove
    {
        @Override
        protected double calcAttDefFactor(Pokemon attacker, Pokemon defender)
        {
            b = super.calcAttDefFactor(attacker, defender);
            return (b);
        }
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

    class LeechLife extends PhysicalMove
    {
        public  LeechLife() {super(Type.BUG, 80.00d, 100.00d);}
    }

    protected String describe()
    {
        if (b >= 1) {
            return "Putin is horosh"
        }
    }
}
