package com.shoestore.utility;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.shoestore.entity.User;


@Component
public class MailConstructor {
	@Autowired
	private Environment env;
	
	public SimpleMailMessage constructResetTokenEmail(
			String contextPath, Locale locale, String token, User user, String password
			) {
		String url = contextPath + "/create-account?token="+token;
		String msg = "\nPlease click on this link to verify your email account and edit your profile. Your Password is \n"+password;
		SimpleMailMessage sender = new SimpleMailMessage();
		sender.setTo(user.getEmail());
		sender.setSubject("Sporty Shoes - New User");
		sender.setText(url+msg);
		sender.setFrom(env.getProperty("support.email"));
		return sender;
	}
	
	public SimpleMailMessage buildEmailSender(String email,String subject, String msg) {
		SimpleMailMessage sender = new SimpleMailMessage();
		sender.setTo(email);
		sender.setSubject(subject);
		sender.setText(msg);
		sender.setFrom(env.getProperty("support.email"));
		return sender;
	}
	
}
