package com.side.wiki.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.side.wiki.vo.UserVO;

public class UserLoginSuccessHandler extends HandlerInterceptorAdapter {

	//��ȣȭ�� ��й�ȣ �񱳸� ���� ����������
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//�α��� ��û ���� ���ͼ��ͷ� �̵��Ǹ�
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("�α��� ���ͼ���");
		
		//modelAndView ��ü�� �ִ� �� �����Ͱ� map�� �������� ��ȯ.
		ModelMap mv = modelAndView.getModelMap();
		System.out.println("ȸ������: " + mv.get("user"));
		String encPassword = (String) mv.get("encPassword");// ��Ʈ�ѷ����� �޾ƿ� ��ȣȭ�� ��й�ȣ
		String rawPassword = (String) mv.getAttribute("rawPassword"); // ��Ʈ�ѷ����� �޾ƿ� ����ڰ� �Է��� ��ȣȭ���� ���� ��й�ȣ
		UserVO vo = (UserVO) mv.get("user"); // ��Ʈ�ѷ����� �޾ƿ� vo
		Boolean match = passwordEncoder.matches(rawPassword, encPassword); // ��й�ȣ�� ��ġ�ϸ� true, ����ġ�� false ��ȯ
		if(match) { //��ȣȭ��й�ȣ, ������Էº�й�ȣ ��ġ
			System.out.println("�α��� ���� ���� ");
			//�α��� ������ ȸ������ ���� �����͸� �����ؼ� �α��� ������ �ϰ� �� ��.
			HttpSession session = request.getSession();
			session.setAttribute("user", vo);
			//������������ ����
			modelAndView.setViewName("/home");
		} else if(!match) { // ��й�ȣ ����ġ
			System.out.println("�α��� ���� ���� ");
			modelAndView.addObject("msg", "loginFail");
			modelAndView.setViewName("/user/loginfail");
		}
	}
}
