package orz.springboot.base;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@ConfigurationProperties(prefix = "orz.base")
public class OrzBaseProps {
    public JsonConfig json = new JsonConfig();

    @Data
    public static class JsonConfig {
        private boolean longAsString = true;
    }
}
