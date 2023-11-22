package orz.springboot.alarm;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@ConfigurationProperties(prefix = "orz.alarm")
public class OrzAlarmProps {
    private int stacksMaxLines = 10;
}
