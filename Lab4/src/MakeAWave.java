public interface MakeAWave
{
    default String makeAWave()
    {
        return "made a wave";
    }

    default String makeAWave(Places place)
    {
        return "made a wave and it went to the " + place.getName();
    }
}
