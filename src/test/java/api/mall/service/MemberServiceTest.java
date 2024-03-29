package api.mall.service;

import api.mall.domain.Member;
import api.mall.repository.MemberRepository;
import api.mall.web.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = Member.builder()
                .userId("id")
                .build();
        
        //when
        Long joinId = memberService.join(member);

        //then
        assertThat(member).isEqualTo(memberRepository.findOne(joinId));
        
    }

    @Test
    public void 중복회원() throws Exception {
        //given
        Member member1 = Member.builder()
                .userId("id")
                .build();
        Member member2 = Member.builder()
                .userId("id")
                .build();
        //when
        memberService.join(member1);

        //then
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> memberService.join(member2));
    }
}