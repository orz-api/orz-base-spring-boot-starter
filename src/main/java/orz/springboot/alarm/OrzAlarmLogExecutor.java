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

import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public void alarm(OrzAlarmBo bo) {
        try {
            logger.error(objectMapper.writeValueAsString(new OrzAlarmLogPo(bo.getEvent(), bo.getUuid(), bo.getTime(), bo.getSummary(), bo.getStacks(), bo.getPayload())));
        } catch (Exception e) {
            writeFallback(bo, e);
        }
    }

    @SneakyThrows
    private void writeFallback(OrzAlarmBo bo, Exception e) {
        var payload = bo.getPayload().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> (Object) String.valueOf(entry.getValue())));
        payload.put("@OrzAlarmLogExecutorException", OrzAlarmUtils.getStacks(e, 4));
        logger.error(objectMapper.writeValueAsString(new OrzAlarmLogPo(bo.getEvent(), bo.getUuid(), bo.getTime(), bo.getSummary(), bo.getStacks(), payload)));
    }
}
