package orz.springboot.base;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import orz.springboot.alarm.exception.OrzAlarmException;

import java.util.*;

public class OrzBaseUtils {
    private static ConfigurableApplicationContext appContext;

    static void setAppContext(ConfigurableApplicationContext appContext) {
        OrzBaseUtils.appContext = appContext;
    }

    public static ConfigurableApplicationContext getAppContext() {
        return Objects.requireNonNull(OrzBaseUtils.appContext);
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

    public static void assertion(boolean expressionRst, String expressionStr) {
        if (!expressionRst) {
            throw new OrzAlarmException("@ORZ_ASSERTION_ERROR", hashMap("expression", expressionStr));
        }
    }

    public static <K, V> LinkedHashMap<K, V> hashMapPairs(Object... pairs) {
        if (pairs == null || pairs.length == 0) {
            return new LinkedHashMap<>();
        }
        if (pairs.length % 2 != 0) {
            throw new IllegalArgumentException("pairs length must be even");
        }
        var map = new LinkedHashMap<>();
        for (int i = 0; i < pairs.length; i += 2) {
            var k = pairs[i];
            if (k == null) {
                throw new IllegalArgumentException("null key at index " + i);
            }
            var v = pairs[i + 1];
            map.put(k, v);
        }
        // noinspection unchecked
        return (LinkedHashMap<K, V>) map;
    }

    public static <K, V> LinkedHashMap<K, V> hashMap(K k1, V v1) {
        return hashMapPairs(k1, v1);
    }

    public static <K, V> LinkedHashMap<K, V> hashMap(K k1, V v1, K k2, V v2) {
        return hashMapPairs(k1, v1, k2, v2);
    }

    public static <K, V> LinkedHashMap<K, V> hashMap(K k1, V v1, K k2, V v2, K k3, V v3) {
        return hashMapPairs(k1, v1, k2, v2, k3, v3);
    }

    public static <K, V> LinkedHashMap<K, V> hashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return hashMapPairs(k1, v1, k2, v2, k3, v3, k4, v4);
    }

    public static <K, V> LinkedHashMap<K, V> hashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return hashMapPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
    }

    public static <K, V> LinkedHashMap<K, V> hashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        return hashMapPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
    }

    public static <K, V> LinkedHashMap<K, V> hashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        return hashMapPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
    }

    public static <K, V> LinkedHashMap<K, V> hashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        return hashMapPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
    }

    public static <K, V> LinkedHashMap<K, V> hashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        return hashMapPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
    }

    public static <K, V> LinkedHashMap<K, V> hashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        return hashMapPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
    }

    public static <K, V> Map<K, V> copyImmutableMap(Map<K, V> map) {
        if (map == null) {
            return null;
        }
        // 不可使用 Map.copyOf，因为 Map.copyOf 不允许 value 为 null
        return Collections.unmodifiableMap(new LinkedHashMap<>(map));
    }

    public static void setRequestAttribute(String name, Object value) {
        var requestAttributes = Objects.requireNonNull(RequestContextHolder.getRequestAttributes());
        requestAttributes.setAttribute(name, value, RequestAttributes.SCOPE_REQUEST);
    }

    public static <T> T getRequestAttribute(String name, Class<T> cls) {
        // noinspection unchecked
        return (T) Optional.ofNullable(RequestContextHolder.getRequestAttributes())
                .map(requestAttributes -> requestAttributes.getAttribute(name, RequestAttributes.SCOPE_REQUEST))
                .filter(cls::isInstance)
                .orElse(null);
    }
}
