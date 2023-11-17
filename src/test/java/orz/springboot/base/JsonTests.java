package orz.springboot.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JsonTests {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testLongField() throws JsonProcessingException {
        String result;
        var model = new TestModel1(
                "1", 2L, 3L,
                Arrays.asList(1L, 2L, 3L),
                new Long[]{3L, 4L, 5L},
                new long[]{6L, 7L, 8L}
        );

        result = objectMapper.writeValueAsString(1L);
        assertEquals(result, "\"1\"");

        result = objectMapper.writeValueAsString(model);
        assertEquals(result, "{\"field1\":\"1\",\"field2\":\"2\",\"field3\":\"3\",\"field4\":[\"1\",\"2\",\"3\"],\"field5\":[\"3\",\"4\",\"5\"],\"field6\":[\"6\",\"7\",\"8\"]}");

        assertEquals(objectMapper.readValue(result, TestModel1.class), model);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class TestModel1 {
        private String field1;
        private Long field2;
        private long field3;
        private List<Long> field4;
        private Long[] field5;
        private long[] field6;
    }
}
