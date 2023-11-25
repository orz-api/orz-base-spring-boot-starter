package orz.springboot.base;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.core.annotation.AnnotationUtils;
import orz.springboot.base.annotation.OrzFullyQualifier;

import javax.annotation.Nonnull;

import static orz.springboot.base.description.OrzDescriptionUtils.desc;

@Slf4j
public class OrzBaseBeanNameGenerator implements BeanNameGenerator {
    private final String projectPackagePrefix;

    public OrzBaseBeanNameGenerator(Class<?> applicationClass) {
        this.projectPackagePrefix = applicationClass.getPackageName() + ".";
    }

    @Nonnull
    @Override
    public String generateBeanName(@Nonnull BeanDefinition definition, @Nonnull BeanDefinitionRegistry registry) {
        var name = (String) null;
        if (StringUtils.isBlank(definition.getBeanClassName())) {
            name = FullyQualifiedAnnotationBeanNameGenerator.INSTANCE.generateBeanName(definition, registry);
        } else {
            var beanClass = (Class<?>) null;
            try {
                beanClass = Class.forName(definition.getBeanClassName());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            var annotation = AnnotationUtils.findAnnotation(beanClass, OrzFullyQualifier.class);
            if (annotation != null) {
                name = FullyQualifiedAnnotationBeanNameGenerator.INSTANCE.generateBeanName(definition, registry);
            } else {
                if (definition.getBeanClassName().startsWith(projectPackagePrefix)) {
                    name = AnnotationBeanNameGenerator.INSTANCE.generateBeanName(definition, registry);
                } else {
                    name = FullyQualifiedAnnotationBeanNameGenerator.INSTANCE.generateBeanName(definition, registry);
                }
            }
        }
        if (log.isDebugEnabled()) {
            log.debug(desc("generate bean name", "bean", definition.getBeanClassName(), "name", name));
        }
        return name;
    }
}
