package com.ecommerce.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication()
	.withUser("admin")
	.password("admin123")
	.roles("ADMIN")
	.and()
	.withUser("user")
	.password("user")
	.roles("USER");
	
	}
	

	//no password encoder used
	@Bean
	public PasswordEncoder getpassword() {
		return NoOpPasswordEncoder.getInstance();
	}
	//authorization
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers("/adminlogin").hasRole("ADMIN")
		//	.antMatchers("/access2").hasRole("USER")
		//	.antMatchers("/access3").hasAnyRole("ADMIN","USER")
			.antMatchers("/").permitAll().and().formLogin();
		}

}
