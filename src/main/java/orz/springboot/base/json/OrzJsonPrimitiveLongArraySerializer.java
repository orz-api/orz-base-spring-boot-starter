package orz.springboot.base.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;

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

    @Override
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType type) throws JsonMappingException {
        var itemVisitor = visitor.expectArrayFormat(type);
        if (itemVisitor != null) {
            itemVisitor.itemsFormat(JsonFormatTypes.STRING);
        }
    }
}
