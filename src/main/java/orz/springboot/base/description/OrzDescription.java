package orz.springboot.base.description;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashSet;
import java.util.Map;

public class OrzDescription {
    private final LinkedHashSet<String> titleSet;
    private final LinkedHashSet<String> valueSet;
    private String string;

    protected OrzDescription(LinkedHashSet<String> titleSet, LinkedHashSet<String> valueSet) {
        this.titleSet = titleSet == null ? new LinkedHashSet<>() : titleSet;
        this.valueSet = valueSet == null ? new LinkedHashSet<>() : valueSet;
    }

    protected String stringify() {
        if (string == null) {
            var titles = titleSet.isEmpty() ? null : String.join(", ", titleSet);
            var values = valueSet.isEmpty() ? null : String.join(", ", valueSet);
            if (StringUtils.isNotBlank(titles) && StringUtils.isNotBlank(values)) {
                string = titles + ": " + values;
            } else if (StringUtils.isNotBlank(titles)) {
                string = titles;
            } else if (StringUtils.isNotBlank(values)) {
                string = values;
            } else {
                string = "";
            }
        }
        return string;
    }

    @Override
    public String toString() {
        return stringify();
    }

    public OrzDescription merge(OrzDescription... descriptions) {
        if (descriptions == null || descriptions.length == 0) {
            return this;
        }
        var newTitleSet = new LinkedHashSet<>(titleSet);
        var newValueSet = new LinkedHashSet<>(valueSet);
        for (OrzDescription description : descriptions) {
            if (description == null) {
                continue;
            }
            if (!description.titleSet.isEmpty()) {
                newTitleSet.addAll(description.titleSet);
            }
            if (!description.valueSet.isEmpty()) {
                newValueSet.addAll(description.valueSet);
            }
        }
        return new OrzDescription(newTitleSet, newValueSet);
    }

    public OrzDescription titles(String... titles) {
        if (titles == null || titles.length == 0) {
            return this;
        }
        var newTitleSet = new LinkedHashSet<>(titleSet);
        newTitleSet.addAll(OrzDescriptionUtils.buildDescriptionTitleSet(titles));
        return new OrzDescription(newTitleSet, valueSet);
    }

    public OrzDescription values(String k1, Object v1) {
        return valuesPairs(k1, v1);
    }

    public OrzDescription values(String k1, Object v1, String k2, Object v2) {
        return valuesPairs(k1, v1, k2, v2);
    }

    public OrzDescription values(String k1, Object v1, String k2, Object v2, String k3, Object v3) {
        return valuesPairs(k1, v1, k2, v2, k3, v3);
    }

    public OrzDescription values(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4) {
        return valuesPairs(k1, v1, k2, v2, k3, v3, k4, v4);
    }

    public OrzDescription values(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5) {
        return valuesPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
    }

    public OrzDescription values(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6) {
        return valuesPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
    }

    public OrzDescription values(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7) {
        return valuesPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
    }

    public OrzDescription values(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8) {
        return valuesPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
    }

    public OrzDescription values(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9) {
        return valuesPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
    }

    public OrzDescription values(String k1, Object v1, String k2, Object v2, String k3, Object v3, String k4, Object v4, String k5, Object v5, String k6, Object v6, String k7, Object v7, String k8, Object v8, String k9, Object v9, String k10, Object v10) {
        return valuesPairs(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
    }

    public OrzDescription valuesMap(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return this;
        }
        var newValueSet = new LinkedHashSet<>(valueSet);
        newValueSet.addAll(OrzDescriptionUtils.buildDescriptionValueSet(map));
        return new OrzDescription(titleSet, newValueSet);
    }

    public OrzDescription valuesPairs(Object... pairs) {
        if (pairs == null || pairs.length == 0) {
            return this;
        }
        var newValueSet = new LinkedHashSet<>(valueSet);
        newValueSet.addAll(OrzDescriptionUtils.buildDescriptionValueSet(pairs));
        return new OrzDescription(titleSet, newValueSet);
    }
}
