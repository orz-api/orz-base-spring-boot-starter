package orz.springboot.base.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

@Component
public class OrzJsonLongModule extends SimpleModule {
    public OrzJsonLongModule() {
        addSerializer(Long.class, new OrzJsonLongSerializer());
        addSerializer(long.class, new OrzJsonLongSerializer());
        addSerializer(long[].class, new OrzJsonPrimitiveLongArraySerializer());
    }
}
