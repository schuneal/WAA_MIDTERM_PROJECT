package edu.mum.coffee.controller;

import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.dom4j.util.UserDataAttribute;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.ServletContextAware;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@Controller
public class HomeController implements ServletContextAware {
	@Resource
	private PersonService personService;
	
	private ServletContext context;

	@GetMapping({ "/", "/index", "/home" })
	public String homePage() {
		return "home";
	}

	@GetMapping({ "/secure" })
	public String securePage(@AuthenticationPrincipal final UserDetails userdetails, Model model,HttpSession session) {
		
		// get user name here ...
		String username = userdetails.getUsername();
		Collection<? extends GrantedAuthority> roles = userdetails.getAuthorities();
		GrantedAuthority arole = roles.stream().findFirst().get();
		String role = arole.toString();
		System.out.println("Role: "+role);
		System.out.println("Username: "+username);
		
		
		//Get person object by email
		Person person = personService.findByEmail(username).get(0);
		model.addAttribute("person", person);
		session.setAttribute("person", person);
		System.out.println("First Name: "+person.getFirstName());
				
		if (role.equals("ROLE_USER")) {
			return "user-page";
		} else {
			return "admin-page";
		}
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		this.context = servletContext;
		
	}
}
