package raksh.login.form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import raksh.login.form.dto.LoginDTO;
import raksh.login.form.service.LoginServiceDAO;

@Component
@RequestMapping("/")
public class LoginController {
	@Autowired
	private LoginServiceDAO service;
	
	public LoginController() {
		System.out.println("created"+this.getClass().getSimpleName());
	}
	@RequestMapping("/SignUp.do")
	public String toSave(LoginDTO dto, ModelMap map) {
		try {
			System.out.println("invoked onSignup");
			boolean check = this.service.validateAndSave(dto);
			if (check) {
				map.addAttribute("Signup.jsp", "Data saved");
			} else {
				map.addAttribute("Signup.jsp", "Data not saved");
			}
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "SignUp";
	}
}
