package orz.springboot.alarm;

import org.springframework.core.Ordered;
import orz.springboot.alarm.model.OrzAlarmBo;

public interface OrzAlarmExecutor extends Ordered {
    @Override
    default int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    void alarm(OrzAlarmBo bo);
}
