class DayStatus
{
    static private TimesOfDay timesOfDay;

    static protected TimesOfDay getTimesOfDay() { return timesOfDay; }
    protected void setTimesOfDay(TimesOfDay timesOfDay) { this.timesOfDay = timesOfDay; }

    public DayStatus(TimesOfDay timesOfDay)
    {
        this.timesOfDay = timesOfDay;
    }
}
