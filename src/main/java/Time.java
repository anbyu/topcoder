public class Time {
    public String whatTime(int seconds) {
        return seconds / 3600 + ":" + seconds / 60 % 60 + ":" + seconds % 60;
    }
}
