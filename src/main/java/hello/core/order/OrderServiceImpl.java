package hello.core.order;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.discount.DiscountPolicy;
// import hello.core.discount.FixDiscountPolicy;
// import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
// import hello.core.member.MemoryMeberRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    // private final MemberRepository memberRepository = new
    // MemoryMeberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private final MemberRepository memberRepository; // DIP 지키기, 인터페이스에만 의존하도록 변경
    private final DiscountPolicy discountPolicy; // DIP 지키기, 인터페이스에만 의존하도록 변경

    // @Autowired
    // public void setMemberRepository(MemberRepository memberRepository) {
    // System.out.println("memberRepository = " + memberRepository);
    // this.memberRepository = memberRepository;
    // }

    // @Autowired
    // public void setDiscountPolicy(DiscountPolicy discountPolicy) {
    // System.out.println("discountPolicy = " + discountPolicy);
    // this.discountPolicy = discountPolicy;
    // }

    // lombok 사용시 final 이 붙은 생성자를 기분으로 밑처럼 만들어줌
    // public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy
    // discountPolicy) {
    // System.out.println("1. OrderServiceImpl.OrderServiceImpl()");
    // this.memberRepository = memberRepository;
    // this.discountPolicy = discountPolicy;
    // }

    @Override
    public Order creatOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
