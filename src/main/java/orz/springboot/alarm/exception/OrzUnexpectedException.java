package orz.springboot.alarm.exception;

import java.util.Map;

import static orz.springboot.base.OrzBaseUtils.hashMap;

public class OrzUnexpectedException extends OrzAlarmException {
    public OrzUnexpectedException() {
        this(null, null, null);
    }

    public OrzUnexpectedException(Throwable cause) {
        this(null, null, cause);
    }

    public OrzUnexpectedException(Map<String, Object> payload) {
        this(null, payload, null);
    }

    public OrzUnexpectedException(Map<String, Object> payload, Throwable cause) {
        this(null, payload, cause);
    }

    public OrzUnexpectedException(String summary, Map<String, Object> payload) {
        this(summary, payload, null);
    }

    public OrzUnexpectedException(String summary, Map<String, Object> payload, Throwable cause) {
        super("@ORZ_UNEXPECTED_ERROR", summary, payload, cause);
    }

    public OrzUnexpectedException(String k1, Object v1) {
        this(hashMap(k1, v1));
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2) {
        this(hashMap(k1, v1, k2, v2));
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3) {
        this(hashMap(k1, v1, k2, v2, k3, v3));
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4) {
        this(hashMap(k1, v1, k2, v2, k3, v3, k4, v4));
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5) {
        this(hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5));
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6) {
        this(hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6));
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7) {
        this(hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7));
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8) {
        this(hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8));
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9) {
        this(hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9));
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10) {
        this(hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10));
    }
}
