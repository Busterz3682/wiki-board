package com.side.wiki.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.side.wiki.user.service.UserService;
import com.side.wiki.vo.UserVO;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	//로그인페이지
	@GetMapping("/loginPage")
	public String userLoginPage() {
		return "/user/login";
	}
	
	//로그인
	@PostMapping("/login")
	public void userLogin(String email, String password, HttpSession session, Model model) {
		System.out.println("로그인요청");
		// 로그인 요청이 들어요면 로그인하려는 아이디와 일치하는 vo객체를 꺼내옴
		UserVO vo = userService.userLogin(email);
		String encPassword = vo.getPassword();// db에서 꺼내온 암호화된 비밀번호
		// 모델객체에 담아 인터셉터로 보냄
		model.addAttribute("rawPassword", password); // 사용자가 입력한 암호화되지 않은 비밀번호
		model.addAttribute("encPassword", encPassword); // 비교를위한 암호화된 비밀번호
		model.addAttribute("user", vo); // 세션생성을 위한 vo객체도 보냄
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes ra) {
		System.out.println("/user/logout/: GET");
		userService.logout(session);
		ra.addFlashAttribute("msg", "logoutSuccess");
		return "redirect:/";
	}
	
	//회원가입페이지
	@GetMapping("/join")
	public String userJoinPage() {
		return "/user/join";
	}
	
	//회원가입
	@PostMapping("/join")
	public String userJoin(UserVO vo) {
		vo.setPassword(passwordEncoder.encode(vo.getPassword()));
		userService.userJoin(vo);
		return "redirect:/";
	}
	
	//가입여부
	@ResponseBody
	@PostMapping("/idCheck") 
	public String idCheck(String email) {
		if(userService.idCheck(email) == 0) {
			return "ok";
		} else {
			return "exist";
		}
	}
	
	
	//메일인증
	@ResponseBody
	@PostMapping("/mailCheck")
	public String mailCheck(String email) {
		System.out.println("메일체크");
		// 인증번호생성
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
//		System.out.println(checkNum);
		// 전송될메일관련
		String setFrom = "jashome.master@gmail.com";
		String toMail = email;
		String title = "회원가입 인증 이메일 입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 " + checkNum + "입니다." + "<br>"
				+ "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			return "notvalid";
		}
		String code = Integer.toString(checkNum);
		System.out.println(code);
		return code;
	}
}
