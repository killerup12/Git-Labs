public interface RelativeLevel
{
    public static String relativeLevel(XYZ obj1, XYZ obj2)   //+
    {
        if (obj1.getHeight() < obj2.getHeight()) return "below";
        if (obj1.getHeight() > obj2.getHeight()) return "above";
        else return "at one height level";
    }
}
