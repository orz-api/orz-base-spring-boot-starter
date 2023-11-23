package orz.springboot.alarm.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OrzAlarmBo {
    private final String event;
    private final String summary;
    private final List<String> stacks;
    private final Map<String, Object> payload;
}
