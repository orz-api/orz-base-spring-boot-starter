package orz.springboot.alarm;

import jakarta.annotation.Nullable;
import org.apache.commons.lang3.exception.ExceptionUtils;
import orz.springboot.alarm.exception.OrzAlarmException;
import orz.springboot.base.OrzBaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrzAlarmUtils {
    private static OrzAlarmManager alarmManager;

    static OrzAlarmManager getAlarmManager() {
        if (alarmManager == null) {
            alarmManager = OrzBaseUtils.getAppContext().getBean(OrzAlarmManager.class);
        }
        return alarmManager;
    }

    static List<String> getStacks(Throwable throwable, int stacksMaxLines) {
        if (throwable == null) {
            return null;
        }
        var frames = ExceptionUtils.getStackFrames(throwable);
        var lines = Math.min(frames.length, stacksMaxLines);
        var stacks = new ArrayList<String>();
        for (int i = 0; i < lines; i++) {
            stacks.add(frames[i].trim());
        }
        if (frames.length > lines) {
            stacks.add("<" + (frames.length - lines) + " lines discarded>");
        }
        return List.copyOf(stacks);
    }

    public static void alarm(String event, @Nullable String uuid, @Nullable String summary, @Nullable Throwable throwable, @Nullable Map<String, Object> payload) {
        getAlarmManager().alarm(event, uuid, summary, throwable, payload);
    }

    public static void alarm(String event, @Nullable String summary, @Nullable Throwable throwable, @Nullable Map<String, Object> payload) {
        alarm(event, null, summary, throwable, payload);
    }

    public static void alarm(String event, @Nullable Throwable throwable, @Nullable Map<String, Object> payload) {
        alarm(event, null, throwable != null ? throwable.getMessage() : null, throwable, payload);
    }

    public static void alarm(String event) {
        alarm(event, null, null, null, null);
    }

    public static void alarm(OrzAlarmException exception, @Nullable Throwable topThrowable) {
        alarm(exception.getEvent(), exception.getUuid(), exception.getSummary(), topThrowable, exception.getPayload());
    }
}
