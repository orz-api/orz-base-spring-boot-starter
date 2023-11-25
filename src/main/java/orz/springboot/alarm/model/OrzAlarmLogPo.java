package orz.springboot.alarm.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class OrzAlarmLogPo {
    private final String event;
    private final String uuid;
    private final LocalDateTime time;
    private final String summary;
    private final List<String> stacks;
    private final Map<String, Object> payload;
}
