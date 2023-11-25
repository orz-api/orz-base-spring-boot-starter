package orz.springboot.alarm.exception;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import static orz.springboot.base.description.OrzDescriptionUtils.descValues;

@Getter
public class OrzAlarmException extends RuntimeException {
    private final String event;
    private final String uuid;
    private final String summary;
    private final Map<String, Object> payload;

    public OrzAlarmException(String event) {
        this(event, null, null, null);
    }

    public OrzAlarmException(String event, Map<String, Object> payload) {
        this(event, null, payload, null);
    }

    public OrzAlarmException(String event, String summary, Map<String, Object> payload) {
        this(event, summary, payload, null);
    }

    public OrzAlarmException(String event, String summary, Map<String, Object> payload, Throwable cause) {
        this(event, UUID.randomUUID().toString(), summary, payload, cause);
    }

    protected OrzAlarmException(String event, String uuid, String summary, Map<String, Object> payload, Throwable cause) {
        super(descValues("event", event, "uuid", uuid, "summary", summary).valuesMap(payload).toString(), cause);
        this.event = event;
        this.uuid = uuid;
        this.summary = summary;
        this.payload = payload == null ? null : Collections.unmodifiableMap(payload);
    }
}
