package orz.springboot.base;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;

import static orz.springboot.base.OrzBaseUtils.message;

@Slf4j
public class OrzBaseAppRunListener implements SpringApplicationRunListener {
    private static final String PROPERTIES_PATTERN = "classpath*:/orz/*.properties";

    @SneakyThrows
    public OrzBaseAppRunListener(SpringApplication application) {
        application.setDefaultProperties(loadDefaultProperties());
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        OrzBaseUtils.setAppContext(context);
    }

    private static Map<String, Object> loadDefaultProperties() throws IOException {
        var props = new HashMap<String, Object>();
        var resolver = new PathMatchingResourcePatternResolver();
        Stream.of(resolver.getResources(PROPERTIES_PATTERN))
                .sorted(Comparator.comparing(OrzBaseAppRunListener::getResourceName))
                .forEach(resource -> props.putAll(loadProperties(resource)));
        return props;
    }

    private static String getResourceName(Resource resource) {
        return StringUtils.defaultIfBlank(resource.getFilename(), "unknown");
    }

    @SneakyThrows
    private static Map<String, Object> loadProperties(Resource resource) {
        log.info(message("load properties", "resource", resource));
        var props = new HashMap<String, Object>();
        var properties = new Properties();
        properties.load(resource.getInputStream());
        for (var entity : properties.entrySet()) {
            props.put((String) entity.getKey(), entity.getValue());
        }
        return props;
    }
}