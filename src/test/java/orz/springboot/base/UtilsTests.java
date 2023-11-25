package orz.springboot.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static orz.springboot.base.description.OrzDescriptionUtils.desc;

public class UtilsTests {
    @Test
    public void testDescriptionUtils() {
        assertEquals("test: a(`b`), c(`d`)", desc("test", "a", "b", "c", "d"));
        assertEquals("test: a(`b`), c(`d`), e(`null`)", desc("test", "a", "b", "c", "d", "e", null));
        assertEquals("a(`b`), c(`d`), e(`null`)", desc(null, "a", "b", "c", "d", "e", null));
    }
}
