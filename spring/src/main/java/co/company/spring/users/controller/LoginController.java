package co.company.spring.users.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login")//로그인페이지로 이동
	public String loginForm() {
		return "user/login";
	}
	@PostMapping("/login")//로그인처리
	public String login(HttpSession session) {
		session.setAttribute("loginId","user");
		//로그인처리
		
		return "redirect:/empSelectM";
	}
	@GetMapping("/logout")//로그아웃
	public String logout(HttpSession session) {
		session.invalidate();//로그아웃처리
		return "user/login";
	}
}
