package com.side.wiki.document.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class TestController {

	//�α���������
	@GetMapping("/kakao")
	public String kakaoLogin() {
		return "kakaoLogin";
	}
	
	//�α��� ����?
	@GetMapping("/isLogin")
	public String isLogin(@RequestParam("code") String code, Model model) {
		model.addAttribute("test", code);
		System.out.println(code);
		return "isLogin";
	}
}
