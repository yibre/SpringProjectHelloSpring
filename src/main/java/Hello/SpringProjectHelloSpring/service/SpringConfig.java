package Hello.SpringProjectHelloSpring.service;

import Hello.SpringProjectHelloSpring.repository.JdbcMemberRepository;
// import Hello.SpringProjectHelloSpring.repository.JdbcTemplateMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import Hello.SpringProjectHelloSpring.repository.MemberRepository;
import Hello.SpringProjectHelloSpring.repository.MemoryMemberRepository;
import Hello.SpringProjectHelloSpring.service.MemberService;

import javax.sql.DataSource;
import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {

        this.dataSource = dataSource;
        this.em = em;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {

        return new JpaMemberRepository(em);
    }
}