package edu.mum.coffee.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.mum.coffee.domain.User;

public class MyUserPrincipal extends User implements UserDetails {
	
	public MyUserPrincipal(final User user) {
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		String role = getRole();
		List<String> roles = new ArrayList<>();
		roles.add(role);
//		SimpleGrantedAuthority k = new SimpleGrantedAuthority("Role_"+role);
		
		
		return roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_"+r)).collect(Collectors.toList());
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}
	
	public String getRole() {
		return super.getRole();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
