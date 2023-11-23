package orz.springboot.base;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

import java.util.Properties;

public interface OrzBaseStartupListener extends Ordered {
    default void onInitialized(SpringApplication application) {
    }

    default void onApplicationContextPrepared(ConfigurableApplicationContext context) {
    }

    default Properties getDefaultProperties() {
        return null;
    }

    @Override
    default int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
