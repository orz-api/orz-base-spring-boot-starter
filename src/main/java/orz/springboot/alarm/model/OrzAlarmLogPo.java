package orz.springboot.alarm.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OrzAlarmLogPo {
    private final String event;
    private final String reason;
    private final List<String> stacks;
    private final Map<String, Object> params;
}
