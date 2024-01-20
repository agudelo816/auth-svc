package com.agudelo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WsConfigurerAdapter {

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable().authorizeRequests().antMatchers("/api/auth/login").
	 * permitAll().anyRequest() .authenticated().and().httpBasic(); }
	 */
}
