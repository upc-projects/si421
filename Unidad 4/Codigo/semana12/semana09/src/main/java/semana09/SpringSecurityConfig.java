package semana09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	private UserDetailsService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder amb) throws Exception {
		amb
			.userDetailsService(userService)
			.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		
		return new BCryptPasswordEncoder();
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
					.antMatchers("/", "/libro/**", "/contacto").permitAll()
					.antMatchers("/admin/**").hasAuthority("Admin")
					.antMatchers("/usuario/**").hasAuthority("Usuario")
					.anyRequest().authenticated()
                .and()
                .formLogin()
					.loginPage("/admin/login").failureUrl("/admin/login?error=true")
					.permitAll()
					.usernameParameter("correo")
					.passwordParameter("clave")
					.defaultSuccessUrl("/admin/dashboard")
					.and().
				logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
					.permitAll();
					
    }
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/static/**", "/css/**", "/js/**", "/images/**");
	}	
}
