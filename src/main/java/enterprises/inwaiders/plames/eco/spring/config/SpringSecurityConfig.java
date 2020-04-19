package enterprises.inwaiders.plames.eco.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
    
	public SpringSecurityConfig() {
		super();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        
		http	
			.csrf().disable();

		http
			.authorizeRequests()
			.antMatchers("/resources/**", "/web/controller/**", "/api/**", "/self/**", "/register", "/register_action").permitAll();
	
		http
			.authorizeRequests()
			.antMatchers("/**").authenticated();
		
		http
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
		
		
		http
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login").deleteCookies("JSESSIONID")
			.invalidateHttpSession(true); 
	}
}
