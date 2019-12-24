class Island extends Places
{
    Island(String name, int x, int y, int height) { super(name, x, y, height); }

    public class FrontSightIsland extends Island
    {
        FrontSightIsland(String name, int x, int y, int height) { super(name ,x, y, height); }
    }
}
