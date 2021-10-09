package com.shoestore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoestore.entity.User;
import com.shoestore.service.SecurityService;
import com.shoestore.service.UserService;
import com.shoestore.utility.MailConstructor;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/registration")
	public String registration(Model model) {
		if(securityService.isAuthenticated()) {
			return "redirect:/";
		}
		model.addAttribute("userForm", new User());
		return "create-accounts";
	}
	
	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "create-accounts";
		}
		
		userService.save(userForm);
		securityService.autoLogin(userForm.getUsername(), userForm.getPassword());
		
		return "redirect:/index";
	}
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if(securityService.isAuthenticated()) {
			return "redirect:/";
		}
		
		if(error != null) {
			model.addAttribute("error", "Invalid Username or Password");
		}
		if(logout != null) {
			model.addAttribute("message", "You have been logged out successfully");
		}
		
		return "login";
	}
	@GetMapping("/forgot-password")
	public String forgotPassword(Model model) {
		return "forgot-password";
	}
	
	@PostMapping("/forgot-password")
	public String forgotPassword(HttpServletRequest request, 
			@ModelAttribute("email") String email,
			Model model) {
		 User usr = userService.findByEmail(email);
		 if(usr != null) {
			 String msg = "Kindly click on the link below to reset your password: http://localhost:8080";
			 String subject = "Sporty Shoes :  Password Reset";
			 SimpleMailMessage sender = mailConstructor.buildEmailSender(email, subject, msg);
			 mailSender.send(sender);
			 model.addAttribute("msg", "Instructions on how to reset your password has been sent to your email");
		 }else {
			 model.addAttribute("err", "Email does not exist");
		 }
		 return "forgot-password";
		
	}
	
	@GetMapping("/men")
	public String shoesForMen(Model model) {
		return "men";
	}
	
	@GetMapping("/women")
	public String shoesForWomen(Model model) {
		return "women";
	}
	@GetMapping("/checkout")
	public String checkout(Model model) {
		return "checkingout";
	}
	
}
