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

    @Value("${logging.config}")
    private String loggingConfig;

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

        // default by META-INF/orz/0000_orz_base.properties
        assertEquals("./log", loggingFilePath);

        // default by META-INF/orz/0000_orz_base.properties
        assertEquals("classpath:logback-orz.xml", loggingConfig);

        // default by META-INF/orz/0000_orz_base.properties
        assertEquals("non_null", jacksonDefaultPropertyInclusion);

        // override by application.yml
        assertEquals("false", jacksonDeserializationAcceptEmptyStringAsNullObject);

        // default by META-INF/orz/0000_orz_base.properties
        assertEquals("false", jacksonSerializationFailOnEmptyBeans);
    }
}
