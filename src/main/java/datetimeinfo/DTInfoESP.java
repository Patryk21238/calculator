package dateTimeInfo;

public class DTInfoESP extends DateTimeInfo {
    public String getGreetingMessage() {
        return "Fecha y hora actual en moscú : " + getCurrentTime("Europe/Madrid");
    }
}
