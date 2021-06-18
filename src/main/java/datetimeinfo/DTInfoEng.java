package datetimeinfo;

public class DTInfoEng extends DateTimeInfo{
    public String getGreetingMessage() {
        return "Current date and time in England: " + getCurrentTime("Europe/London");
    }
}
