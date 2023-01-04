package api.mall.web.controller;

import api.mall.domain.Address;
import api.mall.domain.Member;
import api.mall.domain.Order;
import api.mall.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String createUser(@ModelAttribute("member") Member member) {
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String addUser(@Valid MemberForm memberForm, BindingResult bindingResult) {

        log.info("memberForm={}", memberForm);

        Member member = Member.builder()
                .userId(memberForm.getUserId())
                .password(memberForm.getPassword())
                .name(memberForm.getName())
                .build();


        Long createId = memberService.join(member);

        if (createId == null) {
            System.out.println("오지 않습니까?");
            bindingResult.reject("CreateUserFail", "이미 존재하는 회원 입니다.");
            return "redirect:members/addMemberForm";
        }

        return "redirect:/";
    }
}
