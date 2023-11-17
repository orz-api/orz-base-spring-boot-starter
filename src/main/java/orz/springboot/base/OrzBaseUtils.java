package orz.springboot.base;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.Nullable;
import java.util.Objects;

public class OrzBaseUtils {
    private static ConfigurableApplicationContext appContext;

    public static void setAppContext(ConfigurableApplicationContext appContext) {
        OrzBaseUtils.appContext = appContext;
    }

    public static ConfigurableApplicationContext getAppContext() {
        return Objects.requireNonNull(OrzBaseUtils.appContext);
    }

    public static String message(@Nullable String reason, Object... args) {
        var builder = new StringBuilder();
        if (StringUtils.isNotBlank(reason)) {
            builder.append(reason);
        }
        if (args != null && args.length > 0) {
            if (StringUtils.isNotBlank(reason)) {
                builder.append(": ");
            }
            for (int i = 0; i < args.length; i += 2) {
                if (i + 1 < args.length) {
                    builder.append(args[i]).append("=[").append(args[i + 1]).append("]");
                } else {
                    builder.append(args[i]);
                }
                if (i + 2 < args.length) {
                    builder.append(" ");
                }
            }
        }
        return builder.toString();
    }

    public static void check(boolean expressionRst, String expressionStr) {
        if (!expressionRst) {
            throw new IllegalArgumentException(message("check failed", "expression", expressionStr));
        }
    }
}
