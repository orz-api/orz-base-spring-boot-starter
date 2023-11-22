package orz.springboot.alarm;

import org.springframework.stereotype.Component;
import orz.springboot.alarm.model.OrzAlarmBo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class OrzAlarmManager {
    private final List<OrzAlarmExecutor> alarmExecutorList = new ArrayList<>();

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
}
