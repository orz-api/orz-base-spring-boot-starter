package orz.springboot.base;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

import static orz.springboot.base.OrzBaseUtils.message;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class OrzBaseAppRunListener implements SpringApplicationRunListener {
    private static final String STARTUP_LISTENER_PATTERN = "classpath*:META-INF/orz/*_startup_listener.imports";
    private static final String PROPERTIES_PATTERN = "classpath*:META-INF/orz/*.properties";

    private final List<OrzBaseStartupListener> startupListenerList;

    public OrzBaseAppRunListener(SpringApplication application) {
        startupListenerList = loadStartupListenerList();
        initialized(application);
        configureBeanNameGenerator(application);
        configureDefaultProperties(application);
    }

    protected void initialized(SpringApplication application) {
        startupListenerList.forEach(l -> l.onInitialized(application));
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        OrzBaseUtils.setAppContext(context);
        startupListenerList.forEach(l -> l.onApplicationContextPrepared(context));
    }

    protected void configureBeanNameGenerator(SpringApplication application) {
        application.setBeanNameGenerator(new OrzBaseBeanNameGenerator(application.getMainApplicationClass()));
    }

    @SneakyThrows
    protected void configureDefaultProperties(SpringApplication application) {
        application.setDefaultProperties(loadDefaultProperties());
    }

    @SneakyThrows
    protected List<OrzBaseStartupListener> loadStartupListenerList() {
        var listenerList = new ArrayList<OrzBaseStartupListener>();
        var resolver = new PathMatchingResourcePatternResolver();
        Stream.of(resolver.getResources(STARTUP_LISTENER_PATTERN))
                .sorted(Comparator.comparing(OrzBaseAppRunListener::getResourceName))
                .forEach(resource -> listenerList.addAll(readStartupListenerResource(resource)));
        listenerList.sort(Comparator.comparing(OrzBaseStartupListener::getOrder));
        return Collections.unmodifiableList(listenerList);
    }

    protected Map<String, Object> loadDefaultProperties() throws IOException {
        var resourcePropertiesList = Stream.of(new PathMatchingResourcePatternResolver().getResources(PROPERTIES_PATTERN))
                .sorted(Comparator.comparing(OrzBaseAppRunListener::getResourceName).reversed())
                .map(OrzBaseAppRunListener::readPropertiesResource)
                .toList();

        var startupListenerPropertiesList = startupListenerList.stream()
                .map(OrzBaseStartupListener::getDefaultProperties)
                .filter(Objects::nonNull)
                .toList();

        // 因为优先级高的属性应覆盖优先级低的，所以要反向遍历
        var result = new HashMap<String, Object>();
        for (var i = resourcePropertiesList.size() - 1; i >= 0; i--) {
            var properties = resourcePropertiesList.get(i);
            for (Object key : Collections.list(properties.propertyNames())) {
                result.put((String) key, properties.get(key));
            }
        }
        for (var i = startupListenerPropertiesList.size() - 1; i >= 0; i--) {
            var properties = startupListenerPropertiesList.get(i);
            for (Object key : Collections.list(properties.propertyNames())) {
                result.put((String) key, properties.get(key));
            }
        }
        System.out.println(result);
        return result;
    }

    @SneakyThrows
    protected static List<OrzBaseStartupListener> readStartupListenerResource(Resource resource) {
        var listenerList = Arrays.stream(resource.getContentAsString(StandardCharsets.UTF_8).split("\n"))
                .map(String::trim)
                .filter(StringUtils::isNotBlank)
                .map(OrzBaseAppRunListener::constructObject)
                .map(OrzBaseStartupListener.class::cast)
                .toList();
        if (listenerList.isEmpty()) {
            log.warn(message("load startup listener empty", "resource", resource));
        } else {
            listenerList.forEach(l -> log.info(message("load startup listener", "resource", resource, "listener", l.getClass(), "order", l.getOrder())));
        }
        return listenerList;
    }

    @SneakyThrows
    protected static Properties readPropertiesResource(Resource resource) {
        var properties = new Properties();
        properties.load(resource.getInputStream());
        if (properties.isEmpty()) {
            log.warn(message("load properties empty", "resource", resource));
        } else {
            properties.forEach((key, value) -> log.info(message("load properties", "resource", resource, "key", key, "value", value)));
        }
        return properties;
    }

    protected static String getResourceName(Resource resource) {
        return StringUtils.defaultIfBlank(resource.getFilename(), "unknown");
    }

    @SneakyThrows
    protected static Object constructObject(String className) {
        return Class.forName(className).getConstructor().newInstance();
    }
}