package com.wildcodeschool.projectWithSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/css/**" ).permitAll()
                .antMatchers( "/" ).permitAll()
                .antMatchers( "/avengers/assemble" ).access( "hasRole('USER')" )
                .antMatchers( "/secret-bases" ).access( "hasRole('ADMIN')" )
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .csrf().disable();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser( "Steve" )
                    .password( encoder.encode( "CHAMPION" ) )
                    .roles( "USER" )
                .and()
                .withUser( "Nickflerken" )
                    .password( encoder.encode( "DIRECTOR" ) )
                    .roles( "ADMIN" );
    }
}
