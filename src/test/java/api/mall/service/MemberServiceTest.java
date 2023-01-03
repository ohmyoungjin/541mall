package api.mall.service;

import api.mall.domain.Member;
import api.mall.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
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
        Member member = new Member("maeng2");
        
        //when
        Long joinId = memberService.join(member);

        //then
        assertThat(member).isEqualTo(memberRepository.findOne(joinId));
        
    }

    @Test
    public void 중복회원() throws Exception {
        //given
        Member member1 = new Member("maeng2");
        Member member2 = new Member("maeng2");
        //when
        memberService.join(member1);

        //then
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> memberService.join(member2));
    }
}