public interface RockBreaking
{
    default public String rockBreaking(Rocks rock)  //Rework it!
    {
        rock.setHP(rock.getHP() - 1);

        if (rock.getHP() == 0) { return ""; }
        else { return ""; }
    }
}
