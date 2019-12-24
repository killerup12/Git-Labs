public interface MakeMusic
{
    String makeMusic();
    default String makeMusic(Places place)
    {
        return "*made a sound*";
    }
}
