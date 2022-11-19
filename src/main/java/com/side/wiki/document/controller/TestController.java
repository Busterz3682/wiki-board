package com.side.wiki.document.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.side.wiki.document.service.KakaoService;

@Controller
@RequestMapping("/")
public class TestController {
	
	@Autowired
	private KakaoService kakaoService;

	//로그인페이지
	@GetMapping("/kakao2")
	public String kakaoLogin() {
		return "kakaoLogin";
	}
	
	//카카오로그인2
	@GetMapping("/kakao")
	public String kakaoLogin2() {
		return "kakaoLogin2";
	}
	
	//로그인 검증?
	@GetMapping("/isLogin")
	public String isLogin(@RequestParam("code") String code, Model model) {
		String access_Token = kakaoService.getToken(code);
		System.out.println(access_Token);
		System.out.println("-------------");
		HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);
		System.out.println("test controller : "+ userInfo);
		model.addAttribute("info", userInfo);
		return "isLogin";
	}
		
}
