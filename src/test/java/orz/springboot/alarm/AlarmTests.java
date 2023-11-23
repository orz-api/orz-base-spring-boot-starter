package orz.springboot.alarm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import orz.springboot.base.App;

import java.util.stream.Stream;

import static orz.springboot.alarm.OrzAlarmUtils.alarm;
import static orz.springboot.base.OrzBaseUtils.newHashMap;

@SpringBootTest(classes = App.class)
public class AlarmTests {
    @Test
    public void test() {
        var list = Stream.of(1, null, 2).toList();
        System.out.println(list);

        alarm("test", "test", new RuntimeException(), newHashMap(
                "test", "test",
                "cls", AlarmTests.class,
                "obj", new Object(),
                "null", null
        ));
        alarm("test", "test", new RuntimeException(), newHashMap(
                "test", "test",
                "cls", AlarmTests.class,
                "model", new TestModel(),
                "obj", new Object()
        ));
        alarm("test");
    }

    public static class TestModel {
        public TestModel getModel() {
            return this;
        }
    }
}
