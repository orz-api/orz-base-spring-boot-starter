package orz.springboot.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static orz.springboot.base.OrzBaseUtils.message;

public class UtilsTests {
    @Test
    public void test() {
        assertEquals("test", message("test"));
        assertEquals("test: a=[b] c=[d]", message("test", "a", "b", "c", "d"));
        assertEquals("test: a=[b] c=[d] e", message("test", "a", "b", "c", "d", "e"));
        assertEquals("a=[b] c=[d] e", message(null, "a", "b", "c", "d", "e"));
    }
}
