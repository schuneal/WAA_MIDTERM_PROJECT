package edu.mum.coffee.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.dom4j.util.UserDataAttribute;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@Controller
public class HomeController {
	@Resource
	private PersonService personService;

	@GetMapping({ "/", "/index", "/home" })
	public String homePage() {
		return "home";
	}

	@GetMapping({ "/secure" })
	public String securePage(@AuthenticationPrincipal final UserDetails userdetails, Model model) {
		
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
		System.out.println("First Name: "+person.getFirstName());
				
		if (role.equals("ROLE_USER")) {
			return "user-page";
		} else {
			return "admin-page";
		}
	}
}
