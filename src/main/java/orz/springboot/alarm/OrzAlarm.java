package orz.springboot.alarm;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;
import orz.springboot.alarm.model.OrzAlarmBo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class OrzAlarm {
    private final OrzAlarmProps alarmProps;
    private final OrzAlarmManager alarmManager;

    public OrzAlarm(OrzAlarmProps alarmProps, OrzAlarmManager alarmManager) {
        this.alarmProps = alarmProps;
        this.alarmManager = alarmManager;
    }

    public void alarm(String event, String summary, Throwable throwable, Map<String, Object> params) {
        alarmManager.alarm(new OrzAlarmBo(event, summary, getStacks(throwable), Map.copyOf(params)));
    }

    private List<String> getStacks(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        var frames = ExceptionUtils.getStackFrames(throwable);
        var lines = Math.min(frames.length, alarmProps.getStacksMaxLines());
        var stacks = new ArrayList<String>();
        for (int i = 0; i < lines; i++) {
            stacks.add(frames[i].trim());
        }
        if (frames.length > lines) {
            stacks.add("<" + (frames.length - lines) + " lines discarded>");
        }
        return List.copyOf(stacks);
    }
}
