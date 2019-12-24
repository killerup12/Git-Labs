public class Rocks extends Places
{
    private int HP;

    public int getHP() { return HP; }
    protected void setHP(int HP) { this.HP = HP; }

    Rocks(String name, int HP, Island.FrontSightIsland frontSightIsland)
    {
        super(name, frontSightIsland.getX(), frontSightIsland.getY(), frontSightIsland.getHeight());
        this.HP = HP;
    }
}
