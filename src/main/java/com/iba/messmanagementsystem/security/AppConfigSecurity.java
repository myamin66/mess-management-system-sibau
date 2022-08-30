package com.iba.messmanagementsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class AppConfigSecurity extends WebSecurityConfigurerAdapter {

    @Qualifier("myUserDetailService")
    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/show/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/").permitAll();
        http.authorizeRequests().antMatchers("/css/**").permitAll(); //Adding this line solved it.anyRequest().fullyAuthenticated()
        http.authorizeRequests().antMatchers("/img/**").permitAll(); //Adding this line solved it.anyRequest().fullyAuthenticated()
        http.authorizeRequests().antMatchers("/vendor/**").permitAll(); //Adding this line solved it.anyRequest().fullyAuthenticated()
        http.authorizeRequests().antMatchers("/js/**").permitAll(); //Adding this line solved it.anyRequest().fullyAuthenticated()
        
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/sign_up").permitAll()
                .and().authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout().invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher((RequestMatcher) new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/logout-success").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and().headers().frameOptions().disable().and().csrf().disable();
    }
}
