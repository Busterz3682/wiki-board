package com.side.wiki.controller;

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
public class KakaoController {
	
	@Autowired
	private KakaoService kakaoService;
	
	//카카오로그인
	@GetMapping("/kakao")
	public String kakaoLogin2() {
		return "kakaoLogin";
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
	
	//디자인 템플릿 체크
	@GetMapping("/designtest")
	public String designTest() {
		return "maintest";
	}
		
}
