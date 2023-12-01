package Hello.SpringProjectHelloSpring.service;

import Hello.SpringProjectHelloSpring.domain.Member;
import Hello.SpringProjectHelloSpring.repository.MemberRepository;
import Hello.SpringProjectHelloSpring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository; // new로 신규 할당하면 테스트때 새로운 repository 객체가 생성되게 됨

    @BeforeEach
    public void beforeEach() { // memberrepository 할당하기 , 테스트는 독립 시행이므로 이렇게
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);

    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void 중복_회원_예외() throws IOException {
        // Given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));// 예외가 발생해야 함
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

}