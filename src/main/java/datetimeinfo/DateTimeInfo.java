package datetimeinfo;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeInfo {
    public String getGreetingMessage(){
        return "Obecna data i czas w Polsce: " + getCurrentTime("Poland");
    }

    protected String getCurrentTime(String timeZone){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        TimeZone timeZone1 = TimeZone.getTimeZone(timeZone);
        simpleDateFormat.setTimeZone(timeZone1);
        Date date = new Date();

        return  simpleDateFormat.format(date);
    }
}
