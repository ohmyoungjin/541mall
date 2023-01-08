package api.mall.web.jwt.service;

import api.mall.domain.Member;
import api.mall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }


    /**
     * 중복 회원 검증 로직
     */
    public void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByUser(member.getUserId());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원 입니다.");
        }
    }

    /**
     * 회원 전체 찾기
     */
    public List<Member> findMember() {
        return memberRepository.findAll();
    }
}
