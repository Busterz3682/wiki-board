package com.side.wiki.document.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class TestController {

	//로그인페이지
	@GetMapping("/kakao")
	public String kakaoLogin() {
		return "kakaoLogin";
	}
	
	//로그인 검증?
	@GetMapping("/isLogin")
	public String isLogin(@RequestParam("code") String code, Model model) {
		model.addAttribute("test", code);
		System.out.println(code);
		return "isLogin";
	}
}
