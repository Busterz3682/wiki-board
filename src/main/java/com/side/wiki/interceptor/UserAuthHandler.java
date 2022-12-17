package com.side.wiki.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.side.wiki.vo.UserVO;

public class UserAuthHandler extends HandlerInterceptorAdapter {

	//�����ڱ����� �ʿ��� ������ ��û�� ������ �� ��û�� ����ä Ȯ���� ���ͼ���.
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//���ǿ��� �α��� �����͸� ���� �� Ȯ��
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("user");
		System.out.println(vo);
		if(vo == null) { //�α����� �ȵǾ�������
			response.sendRedirect(request.getContextPath() + "/user/loginPage");
			return false;
		} else if(!vo.getGrade().equals("admin")) { //�����ڰ� �ƴϸ�
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('������ �����ϴ�.'); history.go(-1);</script>");
            out.flush(); 
			return false;
		} else {
			return true;
		}
		
	}
	
}