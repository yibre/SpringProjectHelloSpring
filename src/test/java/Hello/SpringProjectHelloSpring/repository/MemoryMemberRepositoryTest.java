package Hello.SpringProjectHelloSpring.repository;
import Hello.SpringProjectHelloSpring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get(); // Optional에서 바로 꺼낼땐 get을 쓸 수 있음
        System.out.println("result=" + (result == member));
        Assertions.assertEquals(result, member);
    }
}
