package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.controller;

import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.authentication.WebSecurityConfig;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    public static boolean success = false;

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/member/")
    public String homepage(Model model) {
        model.addAttribute("PREFIX", WebSecurityConfig.getPrefixURL());
        model.addAttribute("LOGGED_IN", WebSecurityConfig.isLoggedIn());
        model.addAttribute("member", memberRepository.findBySessionId(WebSecurityConfig.getMyId()));
    	return "member/index";
    }

    @GetMapping("/member/my-information")
    public String myInformatonView(Model model) {
        model.addAttribute("PREFIX", WebSecurityConfig.getPrefixURL());
        model.addAttribute("LOGGED_IN", WebSecurityConfig.isLoggedIn());
        model.addAttribute("info", memberRepository.findBySessionId(WebSecurityConfig.getMyId()));
        model.addAttribute("success", success);
        success = false;
        return "member/myInformationView";
    }

    @GetMapping("/member/my-information/edit")
    public String myInformatonEdit(Model model) {
        model.addAttribute("PREFIX", WebSecurityConfig.getPrefixURL());
        model.addAttribute("LOGGED_IN", WebSecurityConfig.isLoggedIn());
        model.addAttribute("member", memberRepository.findBySessionId(WebSecurityConfig.getMyId()));
        return "member/myInformationEdit";
    }
}
