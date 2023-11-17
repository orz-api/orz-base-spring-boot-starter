package orz.springboot.base;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AppTests {
    @Value("${logging.file.path}")
    private String loggingFilePath;

    @Value("${spring.jackson.default-property-inclusion}")
    private String jacksonDefaultPropertyInclusion;

    @Value("${spring.jackson.deserialization.accept-empty-string-as-null-object}")
    private String jacksonDeserializationAcceptEmptyStringAsNullObject;

    @Value("${spring.jackson.serialization.fail-on-empty-beans}")
    private String jacksonSerializationFailOnEmptyBeans;

    @Test
    void contextLoads() {
        assertDoesNotThrow(() -> {
            OrzBaseUtils.getAppContext();
        });

        // default by orz/0000_orz_base.properties
        assertEquals("./log", loggingFilePath);

        // override by application.yml
        assertEquals("always", jacksonDefaultPropertyInclusion);

        // default by orz/0000_orz_base.properties
        assertEquals("true", jacksonDeserializationAcceptEmptyStringAsNullObject);

        // default by orz/0000_orz_base.properties
        assertEquals("false", jacksonSerializationFailOnEmptyBeans);
    }
}
