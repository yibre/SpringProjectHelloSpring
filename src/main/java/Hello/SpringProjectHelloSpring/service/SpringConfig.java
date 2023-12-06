package Hello.SpringProjectHelloSpring.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import Hello.SpringProjectHelloSpring.repository.MemberRepository;
import Hello.SpringProjectHelloSpring.repository.MemoryMemberRepository;
import Hello.SpringProjectHelloSpring.service.MemberService;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {

        return new MemoryMemberRepository();
    }
}