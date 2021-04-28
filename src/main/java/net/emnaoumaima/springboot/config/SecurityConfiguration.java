package net.emnaoumaima.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.emnaoumaima.springboot.service.UserService;


@Configurable
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf()
	     .ignoringAntMatchers("/api/client/**")
	     .and()
	     .authorizeRequests()
	        .antMatchers("/api/client/**").permitAll();
		
		http.csrf()
	     .ignoringAntMatchers("/api/ticket/**")
	     .and()
	     .authorizeRequests()
	        .antMatchers("/api/ticket/**").permitAll();
		
		http.csrf()
	     .ignoringAntMatchers("/api/met/**")
	     .and()
	     .authorizeRequests()
	        .antMatchers("/api/met/**").permitAll();
		
		http.csrf()
	     .ignoringAntMatchers("/api/tableclient/**")
	     .and()
	     .authorizeRequests()
	        .antMatchers("/api/tableclient/**").permitAll();
		
		http.csrf()
	     .ignoringAntMatchers("/api/compose/**")
	     .and()
	     .authorizeRequests()
	        .antMatchers("/api/compose/**").permitAll();
		
		http.authorizeRequests().antMatchers(
				"/registration**",
					"/js/**",
					"/css/**",
					"/img/**").permitAll()
		.antMatchers("/api/client").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll();
	}
	
}
