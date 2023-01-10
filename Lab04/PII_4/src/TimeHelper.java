import java.util.Calendar;
import java.util.Date;

public class TimeHelper {
    private String rc; // response
    private Calendar calendar = Calendar.getInstance();
    private Date date = new Date();
    private int hour = calendar.get(Calendar.HOUR_OF_DAY);
    private int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    private int day = calendar.get(Calendar.DAY_OF_MONTH);
    private int dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

    public TimeHelper() {
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    // task 1 - print hello on index.jsp
    public void PrintHello(int hour) {
        if (hour > 0 && hour <= 5)
            setRc("Good night");
        else if (hour > 5 && hour < 12)
            setRc("Good morning");
        else if (hour >= 12 && hour < 17)
            setRc("Good afternoon");
        else
            setRc("Good evening");
    }
    // task 5 - include file depending on time
    public String GetTimeName(int hour) {
        if (hour > 0 && hour <= 5)
            return "night";
        else if (hour > 5 && hour < 12)
            return "morning";
        else if (hour >= 12 && hour < 17)
            return "afternoon";
        else
            return "evening";
    }
}
