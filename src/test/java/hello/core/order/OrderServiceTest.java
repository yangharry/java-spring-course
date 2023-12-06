package hello.core.order;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
// import hello.core.member.MemberServiceImpl;

class OrderServiceTest {
    // MemberService memberService = new MemberServiceImpl();
    // OrderService orderService = new OrderServiceImpl();

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig config = new AppConfig();
        memberService = config.memberService();
        orderService = config.orderService();
    }

    @Test
    void creatOrder() {

        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.creatOrder(member.getId(), "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
