package webclothes.spring.config;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import webclothes.spring.service.UserDetailsServiceImpl;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
	        .antMatchers("/users").authenticated()
	        .anyRequest().permitAll()
            .and()
            .formLogin()
//            	.loginPage("/login")
            	.usernameParameter("taiKhoan")
            	.defaultSuccessUrl("/page_sanpham")
            .permitAll()
            .and()
            .logout().permitAll()
            .and()
            .rememberMe().tokenRepository(persistentTokenRepository())
            .and()
            .exceptionHandling().accessDeniedPage("/403")
            ;
    }

	private PersistentTokenRepository persistentTokenRepository() {
		// TODO Auto-generated method stub
		return null;
	}
}