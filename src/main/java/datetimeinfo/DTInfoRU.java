package datetimeinfo;

public class DTInfoRU extends DateTimeInfo{
    public String getGreetingMessage(){
        return "текущая дата и время в москве: " + getCurrentTime("Europe/Moscow");
    }
}
