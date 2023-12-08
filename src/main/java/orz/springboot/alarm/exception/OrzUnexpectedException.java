package orz.springboot.alarm.exception;

import java.util.Map;

import static orz.springboot.base.OrzBaseUtils.hashMap;

public class OrzUnexpectedException extends OrzAlarmException {
    public OrzUnexpectedException() {
        this(null, (Map<String, Object>) null, null);
    }

    public OrzUnexpectedException(String summary) {
        this(summary, (Map<String, Object>) null, null);
    }

    public OrzUnexpectedException(Throwable cause) {
        this(null, (Map<String, Object>) null, cause);
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

    public OrzUnexpectedException(String k1, Object v1, Throwable cause) {
        this(hashMap(k1, v1), cause);
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, Throwable cause) {
        this(hashMap(k1, v1, k2, v2), cause);
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3, Throwable cause) {
        this(hashMap(k1, v1, k2, v2, k3, v3), cause);
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, Throwable cause) {
        this(hashMap(k1, v1, k2, v2, k3, v3, k4, v4), cause);
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, Throwable cause) {
        this(hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5), cause);
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, Throwable cause) {
        this(hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6), cause);
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, Throwable cause) {
        this(hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7), cause);
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, Throwable cause) {
        this(hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8), cause);
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, Throwable cause) {
        this(hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9), cause);
    }

    public OrzUnexpectedException(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10, Throwable cause) {
        this(hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10), cause);
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

    public OrzUnexpectedException(String summary, String k1, Object v1) {
        this(summary, hashMap(k1, v1));
    }

    public OrzUnexpectedException(String summary, String k1, Object v1, String k2, Object v2) {
        this(summary, hashMap(k1, v1, k2, v2));
    }

    public OrzUnexpectedException(String summary, String k1, Object v1, String k2, Object v2, String k3, Object v3) {
        this(summary, hashMap(k1, v1, k2, v2, k3, v3));
    }

    public OrzUnexpectedException(String summary, String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4) {
        this(summary, hashMap(k1, v1, k2, v2, k3, v3, k4, v4));
    }

    public OrzUnexpectedException(String summary, String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5) {
        this(summary, hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5));
    }

    public OrzUnexpectedException(String summary, String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6) {
        this(summary, hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6));
    }

    public OrzUnexpectedException(String summary, String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7) {
        this(summary, hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7));
    }

    public OrzUnexpectedException(String summary, String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8) {
        this(summary, hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8));
    }

    public OrzUnexpectedException(String summary, String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9) {
        this(summary, hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9));
    }

    public OrzUnexpectedException(String summary, String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10) {
        this(summary, hashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10));
    }
}
