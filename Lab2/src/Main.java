import ru.ifmo.se.pokemon.*;

import MyPokemons.*;

public class Main
{
    public static void main(String[] args)
    {
        Battle b = new Battle();
        b.addAlly(new Lugia("Killer", 3));
        b.addAlly(new Seel("Petuchilli", 1));
        b.addAlly(new Dewgong("Doter", 6));
        b.addFoe(new Venipede("Putin", 10));
        b.addFoe(new Whirlipede("Medvedev", 10));
        b.addFoe(new Scolipede("Poroshenko", 10));
        b.go();
    }
}