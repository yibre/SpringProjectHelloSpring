package Hello.SpringProjectHelloSpring.service;

import Hello.SpringProjectHelloSpring.domain.Member;
import Hello.SpringProjectHelloSpring.repository.MemberRepository;
import Hello.SpringProjectHelloSpring.repository.MemoryMemberRepository;

import java.util.Optional;
import java.util.List;
public class MemberService {
    private final MemberRepository memberRepository = new
            MemoryMemberRepository();
    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}