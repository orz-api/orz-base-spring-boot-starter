package orz.springboot.base;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.Nullable;
import java.util.*;

public class OrzBaseUtils {
    private static ConfigurableApplicationContext appContext;

    static void setAppContext(ConfigurableApplicationContext appContext) {
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

    public static <T extends Throwable> Optional<T> getException(Class<T> instanceClass, Throwable top) {
        T result = null;

        Throwable throwable = top;
        for (int i = 0; i < 10; i++) {
            if (instanceClass.isInstance(throwable)) {
                // noinspection unchecked
                result = (T) throwable;
                break;
            }

            if (throwable.getCause() != null) {
                throwable = throwable.getCause();
            } else {
                break;
            }
        }

        return Optional.ofNullable(result);
    }

    public static <K, V> Map<K, V> newHashMapWithPairs(Object... pairs) {
        if (pairs == null || pairs.length == 0) {
            return new HashMap<>();
        }
        if (pairs.length % 2 != 0) {
            throw new IllegalArgumentException("pairs length must be even");
        }
        var map = new HashMap<>();
        for (int i = 0; i < pairs.length; i += 2) {
            var k = pairs[i];
            if (k == null) {
                throw new IllegalArgumentException("null key at index " + i);
            }
            var v = pairs[i + 1];
            map.put(k, v);
        }
        // noinspection unchecked
        return (Map<K, V>) map;
    }

    public static <K, V> Map<K, V> newHashMap(K k1, V v1) {
        return newHashMapWithPairs(k1, v1);
    }

    public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2) {
        return newHashMapWithPairs(k1, v1, k2, v2);
    }

    public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2, K k3, V v3) {
        return newHashMapWithPairs(k1, v1, k2, v2, k3, v3);
    }

    public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return newHashMapWithPairs(k1, v1, k2, v2, k3, v3, k4, v4);
    }

    public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return newHashMapWithPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
    }

    public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        return newHashMapWithPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
    }

    public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        return newHashMapWithPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
    }

    public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        return newHashMapWithPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
    }

    public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        return newHashMapWithPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
    }

    public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        return newHashMapWithPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
    }

    public static <K, V> Map<K, V> copyImmutableMap(Map<K, V> map) {
        if (map == null) {
            return null;
        }
        // 不可使用 Map.copyOf，因为 Map.copyOf 不允许 value 为 null
        return Collections.unmodifiableMap(new HashMap<>(map));
    }
}
