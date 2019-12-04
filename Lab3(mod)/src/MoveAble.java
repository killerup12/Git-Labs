public interface MoveAble
{
    String goTo(Places place);    //Character movement
    default String goTo(TimesOfDay timesOfDay, Places place)
    {
        if (timesOfDay.equals(TimesOfDay.EVENING))
        {
            return goTo(place);
        }
        return "can't go to " + place.getName();
    }
    String relativeLevel(XYZ obj);    //Compares the height of different subjects
}