package orz.springboot.base.description;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;

public class OrzDescriptionUtils {
    protected static LinkedHashSet<String> buildDescriptionTitleSet(String... titles) {
        var result = new LinkedHashSet<String>();
        if (titles == null) {
            return result;
        }
        for (String title : titles) {
            if (StringUtils.isNotBlank(title)) {
                result.add(title);
            }
        }
        return result;
    }

    protected static LinkedHashSet<String> buildDescriptionValueSet(Object... pairs) {
        if (pairs.length % 2 != 0) {
            throw new IllegalArgumentException("pairs length must be even");
        }
        var result = new LinkedHashSet<String>();
        for (int i = 0; i < pairs.length; i += 2) {
            var k = pairs[i];
            if (k == null) {
                throw new IllegalArgumentException("null key at index " + i);
            }
            if (!(k instanceof String)) {
                throw new IllegalArgumentException("non-string key at index " + i);
            }
            var v = pairs[i + 1];
            result.add(k + "(`" + toString(v) + "`)");
        }
        return result;
    }

    protected static LinkedHashSet<String> buildDescriptionValueSet(Map<String, Object> map) {
        var result = new LinkedHashSet<String>();
        if (map == null || map.isEmpty()) {
            return result;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            var k = entry.getKey();
            if (k == null) {
                throw new IllegalArgumentException("null key");
            }
            var v = entry.getValue();
            result.add(k + "(`" + toString(v) + "`)");
        }
        return result;
    }

    public static String toString(Object object) {
        if (object instanceof Object[] array) {
            return Arrays.toString(array);
        }
        if (object instanceof boolean[] array) {
            return Arrays.toString(array);
        }
        if (object instanceof byte[] array) {
            return Arrays.toString(array);
        }
        if (object instanceof char[] array) {
            return Arrays.toString(array);
        }
        if (object instanceof double[] array) {
            return Arrays.toString(array);
        }
        if (object instanceof float[] array) {
            return Arrays.toString(array);
        }
        if (object instanceof int[] array) {
            return Arrays.toString(array);
        }
        if (object instanceof long[] array) {
            return Arrays.toString(array);
        }
        if (object instanceof short[] array) {
            return Arrays.toString(array);
        }
        return String.valueOf(object);
    }

    public static OrzDescription descTitles(String... titles) {
        return new OrzDescription(buildDescriptionTitleSet(titles), null);
    }

    public static OrzDescription descValues(String k1, Object v1) {
        return new OrzDescription(null, buildDescriptionValueSet(k1, v1));
    }

    public static OrzDescription descValues(String k1, Object v1, String k2, Object v2) {
        return new OrzDescription(null, buildDescriptionValueSet(k1, v1, k2, v2));
    }

    public static OrzDescription descValues(String k1, Object v1, String k2, Object v2, String k3, Object v3) {
        return new OrzDescription(null, buildDescriptionValueSet(k1, v1, k2, v2, k3, v3));
    }

    public static OrzDescription descValues(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4) {
        return new OrzDescription(null, buildDescriptionValueSet(k1, v1, k2, v2, k3, v3, k4, v4));
    }

    public static OrzDescription descValues(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5) {
        return new OrzDescription(null, buildDescriptionValueSet(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5));
    }

    public static OrzDescription descValues(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6) {
        return new OrzDescription(null, buildDescriptionValueSet(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6));
    }

    public static OrzDescription descValues(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7) {
        return new OrzDescription(null, buildDescriptionValueSet(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7));
    }

    public static OrzDescription descValues(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8) {
        return new OrzDescription(null, buildDescriptionValueSet(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8));
    }

    public static OrzDescription descValues(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9) {
        return new OrzDescription(null, buildDescriptionValueSet(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9));
    }

    public static OrzDescription descValues(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10) {
        return new OrzDescription(null, buildDescriptionValueSet(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10));
    }

    public static OrzDescription descValuesMap(Map<String, Object> map) {
        return new OrzDescription(null, buildDescriptionValueSet(map));
    }

    public static OrzDescription descValuesPairs(Object... pairs) {
        return new OrzDescription(null, buildDescriptionValueSet(pairs));
    }

    public static String desc(String title) {
        return new OrzDescription(buildDescriptionTitleSet(title), null).toString();
    }

    public static String desc(String title, String k1, Object v1) {
        return new OrzDescription(buildDescriptionTitleSet(title), buildDescriptionValueSet(k1, v1)).toString();
    }

    public static String desc(String title, String k1, Object v1, String k2, Object v2) {
        return new OrzDescription(buildDescriptionTitleSet(title), buildDescriptionValueSet(k1, v1, k2, v2)).toString();
    }

    public static String desc(String title, String k1, Object v1, String k2, Object v2, String k3, Object v3) {
        return new OrzDescription(buildDescriptionTitleSet(title), buildDescriptionValueSet(k1, v1, k2, v2, k3, v3)).toString();
    }

    public static String desc(String title, String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4) {
        return new OrzDescription(buildDescriptionTitleSet(title), buildDescriptionValueSet(k1, v1, k2, v2, k3, v3, k4, v4)).toString();
    }

    public static String desc(String title, String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5) {
        return new OrzDescription(buildDescriptionTitleSet(title), buildDescriptionValueSet(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5)).toString();
    }

    public static String desc(String title, String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6) {
        return new OrzDescription(buildDescriptionTitleSet(title), buildDescriptionValueSet(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6)).toString();
    }

    public static String desc(String title, String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7) {
        return new OrzDescription(buildDescriptionTitleSet(title), buildDescriptionValueSet(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7)).toString();
    }

    public static String desc(String title, String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8) {
        return new OrzDescription(buildDescriptionTitleSet(title), buildDescriptionValueSet(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8)).toString();
    }

    public static String desc(String title, String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9) {
        return new OrzDescription(buildDescriptionTitleSet(title), buildDescriptionValueSet(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9)).toString();
    }

    public static String desc(String title, String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10) {
        return new OrzDescription(buildDescriptionTitleSet(title), buildDescriptionValueSet(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10)).toString();
    }

    public static String desc(String title, Map<String, Object> map) {
        return new OrzDescription(buildDescriptionTitleSet(title), buildDescriptionValueSet(map)).toString();
    }
}
