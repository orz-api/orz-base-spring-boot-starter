package orz.springboot.alarm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import orz.springboot.base.App;

import java.util.Map;

@SpringBootTest(classes = App.class)
public class AlarmTests {
    @Autowired
    private OrzAlarm alarm;

    @Test
    public void test() {
        alarm.alarm("test", "test", new RuntimeException(), Map.of("test", "test"));
    }
}
