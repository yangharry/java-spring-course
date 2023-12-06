package hello.core.scan.filter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.context.annotation.ComponentScan.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean(BeanA.class);
        assertThat(beanA).isNotNull();

        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean(BeanB.class));

        ((ConfigurableApplicationContext) ac).close();
    }

    @Configuration
    @ComponentScan(includeFilters = @Filter(type = FilterType.ANNOTATION, // 기본 값 없어두 뎀
            value = MyIncludeComponent.class), excludeFilters = @Filter(type = FilterType.ANNOTATION, value = MyExcludeComponent.class))
    static class ComponentFilterAppConfig {

    }
}
