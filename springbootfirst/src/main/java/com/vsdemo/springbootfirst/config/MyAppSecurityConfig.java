package com.vsdemo.springbootfirst.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vsdemo.springbootfirst.Services.DoctorService;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyAppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DoctorService doctorService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/**");
        
         	
         
    }
    @Override
	protected void configure(HttpSecurity http) throws Exception {
    	http
    		.csrf()
    		.disable()
    		.cors()
    		.disable();
	}
//    @Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(doctorService);
//	}
    

}
