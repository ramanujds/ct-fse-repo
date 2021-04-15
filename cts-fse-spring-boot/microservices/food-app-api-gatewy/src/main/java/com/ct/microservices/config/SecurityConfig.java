package com.ct.microservices.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ct.microservices.filter.AuthFilter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

@Autowired
private UserDetailsService userDetailsService;

@Autowired
private AuthFilter filter;

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("rahul")
//			.password("12345")
//			.roles("USER")
//			.and()
//			.withUser("tushar")
//			.password("abcd")
//			.roles("ADMIN");
//		
//	}
	
	@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
		auth.userDetailsService(userDetailsService);
		
		
		}
	
	@Bean
	public AuthenticationManager getAuthenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
					.authorizeRequests()
					.antMatchers("/admin/**").hasRole("ADMIN")
					
					.antMatchers("/user/**").hasAnyRole("USER","ADMIN")
					.antMatchers("/cart/**").hasAnyRole("USER","ADMIN")
					.antMatchers("/public/**").permitAll()
					.anyRequest()
					.authenticated();
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
