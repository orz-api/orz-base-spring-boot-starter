package orz.springboot.alarm;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import orz.springboot.alarm.model.OrzAlarmBo;
import orz.springboot.base.OrzBaseUtils;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class OrzAlarmManager {
    private final OrzAlarmProps props;
    private final List<OrzAlarmExecutor> alarmExecutorList = new ArrayList<>();

    public OrzAlarmManager(OrzAlarmProps props) {
        this.props = props;
    }

    public void registerExecutor(OrzAlarmExecutor executor) {
        if (alarmExecutorList.contains(executor)) {
            return;
        }
        alarmExecutorList.add(executor);
    }

    public void alarm(OrzAlarmBo bo) {
        alarmExecutorList.stream()
                .sorted(Comparator.comparing(OrzAlarmExecutor::getOrder))
                .forEach(executor -> executor.alarm(bo));
    }

    public void alarm(String event, String uuid, String summary, Throwable throwable, Map<String, Object> payload) {
        alarm(new OrzAlarmBo(
                StringUtils.defaultIfBlank(event, "@ORZ_ALARM_EVENT_EMPTY"),
                StringUtils.defaultIfBlank(uuid, UUID.randomUUID().toString()),
                LocalDateTime.now(),
                StringUtils.defaultIfBlank(summary, null),
                OrzAlarmUtils.getStacks(throwable, props.getStacksMaxLines()),
                OrzBaseUtils.copyImmutableMap(payload)
        ));
    }
}
