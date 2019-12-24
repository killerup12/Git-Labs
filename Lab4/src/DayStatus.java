public class DayStatus
{
    static private TimesOfDay timesOfDay;

    static protected TimesOfDay getTimesOfDay() { return timesOfDay; }
    public void setTimesOfDay(TimesOfDay timesOfDay) { DayStatus.timesOfDay = timesOfDay; }

    public DayStatus(TimesOfDay timesOfDay) { DayStatus.timesOfDay = timesOfDay; }
}
