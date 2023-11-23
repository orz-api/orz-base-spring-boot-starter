package orz.springboot.alarm;

import org.apache.commons.lang3.exception.ExceptionUtils;
import orz.springboot.base.OrzBaseUtils;

import javax.annotation.Nullable;
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

    public static void alarm(String event, @Nullable String summary, @Nullable Throwable throwable, @Nullable Map<String, Object> payload) {
        getAlarmManager().alarm(event, summary, throwable, payload);
    }

    public static void alarm(String event) {
        alarm(event, null, null, null);
    }
}
