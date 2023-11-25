package orz.springboot.alarm.exception;

import java.util.Map;

public class OrzUnexpectedException extends OrzAlarmException {
    public OrzUnexpectedException() {
        this(null, null, null);
    }

    public OrzUnexpectedException(Throwable cause) {
        this(null, null, cause);
    }

    public OrzUnexpectedException(Map<String, Object> payload) {
        this(null, payload, null);
    }

    public OrzUnexpectedException(String summary, Map<String, Object> payload) {
        this(summary, payload, null);
    }

    public OrzUnexpectedException(String summary, Map<String, Object> payload, Throwable cause) {
        super("@ORZ_UNEXPECTED_ERROR", summary, payload, cause);
    }
}
