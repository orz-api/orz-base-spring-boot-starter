package orz.springboot.base;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

import java.time.Duration;
import java.util.Properties;

public interface OrzBaseStartupListener extends Ordered {
    default void onInitialized(SpringApplication application) {
    }

    default void onContextPrepared(ConfigurableApplicationContext context) {
    }

    default void onContextLoaded(ConfigurableApplicationContext context) {
    }

    default void onContextRefreshed(ApplicationContext context) {
    }

    default void onStarted(ConfigurableApplicationContext context, Duration timeTaken) {
    }

    default Properties getDefaultProperties() {
        return null;
    }

    @Override
    default int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
