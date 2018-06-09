package edu.mum.coffee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import edu.mum.coffee.repository.UserRepository;
import edu.mum.coffee.service.MyUserDetailService;

@Configuration
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.sessionManagement()
 			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
		http
				.authorizeRequests()
				.antMatchers("/", "/home", "/index").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.permitAll()
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/")
				.permitAll();

		http.csrf().disable();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService)
				.passwordEncoder(new PasswordEncoder() {

					@Override
					public String encode(CharSequence charseq) {
						// TODO Auto-generated method stub
						return charseq.toString();
					}

					@Override
					public boolean matches(CharSequence arg0, String arg1) {
						// TODO Auto-generated method stub
						return true;
					}

				});


//		auth.inMemoryAuthentication().withUser("akassa@mum.edu").password("pw").roles("ADMIN");
	}
}