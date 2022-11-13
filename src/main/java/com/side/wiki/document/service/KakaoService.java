package com.side.wiki.document.service;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestParam;

public interface KakaoService {
	
	public String getToken(@RequestParam("code") String code);
	
	public HashMap<String, Object> getUserInfo (String access_Token);
	
}
