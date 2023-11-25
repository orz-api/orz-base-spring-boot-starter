package orz.springboot.base.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;
import orz.springboot.base.description.OrzDescription;

@Component
public class OrzJsonModule extends SimpleModule {
    public OrzJsonModule() {
        addSerializer(Long.class, new OrzJsonLongSerializer());
        addSerializer(long.class, new OrzJsonLongSerializer());
        addSerializer(long[].class, new OrzJsonPrimitiveLongArraySerializer());
        addSerializer(OrzDescription.class, new OrzJsonDescriptionSerializer());
    }
}
