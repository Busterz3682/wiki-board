package com.side.wiki.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.side.wiki.vo.UserVO;

public class UserAuthHandler extends HandlerInterceptorAdapter {

	//관리자권한이 필요한 페이지 요청이 들어왔을 때 요청을 가로채 확인할 인터셉터.
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//세션에서 로그인 데이터를 얻은 후 확인
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("user");
		System.out.println(vo);
		if(vo == null) { //로그인이 안되어있으면
			response.sendRedirect(request.getContextPath() + "/user/loginPage");
			return false;
		} else if(!vo.getGrade().equals("admin")) { //관리자가 아니면
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('권한이 없습니다.'); history.go(-1);</script>");
            out.flush(); 
			return false;
		} else {
			return true;
		}
		
	}
	
}