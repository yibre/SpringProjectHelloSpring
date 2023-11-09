package Hello.SpringProjectHelloSpring.repository;

import Hello.SpringProjectHelloSpring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 동시성 문제를 고려해서 Atomic, Long 등을 해야 하지만 여기선 단순하게 감
    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 아이디는 저절로 저장하기
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // nullable이면
    }

    @Override
    public Optional<Member> findByName(String name) {
        store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
