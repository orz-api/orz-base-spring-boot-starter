package orz.springboot.alarm;

import jakarta.annotation.Nonnull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class OrzAlarmBeanPostProcessor implements BeanPostProcessor, Ordered {
    private final OrzAlarmManager alarmManager;

    @Lazy
    public OrzAlarmBeanPostProcessor(OrzAlarmManager alarmManager) {
        this.alarmManager = alarmManager;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public Object postProcessAfterInitialization(@Nonnull Object bean, @Nonnull String beanName) throws BeansException {
        if (bean instanceof OrzAlarmExecutor executor) {
            alarmManager.registerExecutor(executor);
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
