package orz.springboot.alarm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import orz.springboot.alarm.exception.OrzAlarmException;
import orz.springboot.alarm.exception.OrzUnexpectedException;
import orz.springboot.base.App;

import static orz.springboot.alarm.OrzAlarmUtils.alarm;
import static orz.springboot.base.OrzBaseUtils.assertion;
import static orz.springboot.base.OrzBaseUtils.hashMap;

@Slf4j
@SpringBootTest(classes = App.class)
public class AlarmTests {
    @Test
    public void test() {
        alarm("test", "test", new RuntimeException(), hashMap(
                "test", "test",
                "cls", AlarmTests.class,
                "obj", new Object(),
                "null", null
        ));
        alarm("test", "test", new RuntimeException(), hashMap(
                "test", "test",
                "cls", AlarmTests.class,
                "model", new TestModel(),
                "obj", new Object()
        ));
        alarm("test");

        try {
            throw new OrzAlarmException("test", hashMap(
                    "test", "test",
                    "cls", AlarmTests.class,
                    "model", new TestModel(),
                    "obj", new Object()
            ));
        } catch (OrzAlarmException e) {
            log.error("alarm", e);
            alarm(e, e);
        }

        try {
            throw new OrzUnexpectedException();
        } catch (OrzAlarmException e) {
            log.error("unexpected", e);
            alarm(e, e);
        }

        try {
            assertion(false, "a == b");
        } catch (OrzAlarmException e) {
            log.error("assertion", e);
            alarm(e, e);
        }
    }

    public static class TestModel {
        public TestModel getModel() {
            return this;
        }
    }
}
