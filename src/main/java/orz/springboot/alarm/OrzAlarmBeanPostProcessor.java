package orz.springboot.alarm;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

@Component
public class OrzAlarmBeanPostProcessor implements BeanPostProcessor, Ordered {
    private final OrzAlarmManager alarmManager;

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
