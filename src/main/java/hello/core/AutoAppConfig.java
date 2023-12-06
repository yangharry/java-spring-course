package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// import hello.core.member.MemberRepository;
// import hello.core.member.MemoryMemberRepository;

import static org.springframework.context.annotation.ComponentScan.*;

// import org.springframework.context.annotation.Bean;

@Configuration
@ComponentScan(excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

    // @Bean("memoryMemberRepository") // 수동 등록 할경우 우선권을 가지지만 spring boot 에서는 충돌이 나게
    // 바뀜.
    // MemberRepository memberRepository() {
    // return new MemoryMemberRepository();
    // }
}
