package orz.springboot.base.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class OrzJsonPrimitiveLongArraySerializer extends JsonSerializer<long[]> {
    @Override
    public void serialize(long[] value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartArray();
        for (var i : value) {
            gen.writeString(String.valueOf(i));
        }
        gen.writeEndArray();
    }
}
