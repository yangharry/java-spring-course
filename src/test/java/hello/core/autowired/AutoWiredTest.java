package hello.core.autowired;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Member;
import io.micrometer.common.lang.Nullable;

public class AutoWiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

        ((ConfigurableApplicationContext) ac).close();
    }

    static class TestBean {

        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setBean2(@Nullable Member nobean2) {
            System.out.println("noBean2 = " + nobean2);
        }

        @Autowired
        public void setBean3(Optional<Member> nobean3) {
            System.out.println("noBean3 = " + nobean3);
        }

    }
}
