package orz.springboot.alarm;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import orz.springboot.alarm.model.OrzAlarmBo;
import orz.springboot.alarm.model.OrzAlarmLogPo;

@Slf4j
@Component
public class OrzAlarmLogExecutor implements OrzAlarmExecutor {
    private static final Logger logger = LoggerFactory.getLogger("orz-alarm");

    private final ObjectMapper objectMapper;

    public OrzAlarmLogExecutor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @SneakyThrows
    @Override
    public void alarm(OrzAlarmBo bo) {
        var po = new OrzAlarmLogPo(bo.getEvent(), bo.getSummary(), bo.getStacks(), bo.getParams());
        logger.error(objectMapper.writeValueAsString(po));
    }
}
