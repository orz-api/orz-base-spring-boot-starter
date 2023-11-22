package orz.springboot.alarm.exception;

public class OrzAlarmException extends RuntimeException {
    public OrzAlarmException() {
        super();
    }

    public OrzAlarmException(String message) {
        super(message);
    }

    public OrzAlarmException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrzAlarmException(Throwable cause) {
        super(cause);
    }
}
