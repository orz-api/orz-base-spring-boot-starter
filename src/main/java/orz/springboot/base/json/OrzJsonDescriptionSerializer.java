package orz.springboot.base.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import orz.springboot.base.description.OrzDescription;

import java.io.IOException;

public class OrzJsonDescriptionSerializer extends JsonSerializer<OrzDescription> {
    @Override
    public void serialize(OrzDescription value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.toString());
    }
}
