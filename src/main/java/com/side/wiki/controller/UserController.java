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

	//�α���������
	@GetMapping("/loginPage")
	public String userLoginPage() {
		return "/user/login";
	}
	
	//�α���
	@PostMapping("/login")
	public void userLogin(String email, String password, HttpSession session, Model model) {
		System.out.println("�α��ο�û");
		// �α��� ��û�� ����� �α����Ϸ��� ���̵�� ��ġ�ϴ� vo��ü�� ������
		UserVO vo = userService.userLogin(email);
		String encPassword = vo.getPassword();// db���� ������ ��ȣȭ�� ��й�ȣ
		// �𵨰�ü�� ��� ���ͼ��ͷ� ����
		model.addAttribute("rawPassword", password); // ����ڰ� �Է��� ��ȣȭ���� ���� ��й�ȣ
		model.addAttribute("encPassword", encPassword); // �񱳸����� ��ȣȭ�� ��й�ȣ
		model.addAttribute("user", vo); // ���ǻ����� ���� vo��ü�� ����
	}
	
	//�α׾ƿ�
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes ra) {
		System.out.println("/user/logout/: GET");
		userService.logout(session);
		ra.addFlashAttribute("msg", "logoutSuccess");
		return "redirect:/";
	}
	
	//ȸ������������
	@GetMapping("/join")
	public String userJoinPage() {
		return "/user/join";
	}
	
	//ȸ������
	@PostMapping("/join")
	public String userJoin(UserVO vo) {
		vo.setPassword(passwordEncoder.encode(vo.getPassword()));
		userService.userJoin(vo);
		return "redirect:/";
	}
	
	//���Կ���
	@ResponseBody
	@PostMapping("/idCheck") 
	public String idCheck(String email) {
		if(userService.idCheck(email) == 0) {
			return "ok";
		} else {
			return "exist";
		}
	}
	
	
	//��������
	@ResponseBody
	@PostMapping("/mailCheck")
	public String mailCheck(String email) {
		System.out.println("����üũ");
		// ������ȣ����
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
//		System.out.println(checkNum);
		// ���۵ɸ��ϰ���
		String setFrom = "jashome.master@gmail.com";
		String toMail = email;
		String title = "ȸ������ ���� �̸��� �Դϴ�.";
		String content = "Ȩ�������� �湮���ּż� �����մϴ�." + "<br><br>" + "���� ��ȣ�� " + checkNum + "�Դϴ�." + "<br>"
				+ "�ش� ������ȣ�� ������ȣ Ȯ�ζ��� �����Ͽ� �ּ���.";
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
