package formation.sopra.formationSpringBoot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// utilisé pour les resources en acces direct
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images/**", "/css/**");
	}

	@Override
	// les acces au resources
	// le mode d'authentification
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		
		http.antMatcher("/api/**")
				.csrf().ignoringAntMatchers("/api/**")
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeHttpRequests()
					.antMatchers(HttpMethod.GET,"/api/personnage/**").permitAll()
					.antMatchers("/api/**").authenticated()
				.and()
				.httpBasic();
//			.and()
//			.antMatcher("/**")
//				.authorizeHttpRequests()
//					.antMatchers("/personnage/**").permitAll()
//					.antMatchers("/compagnon/**").hasAnyRole("COMPAGNON","ADMIN")
//					.anyRequest().authenticated()
//				.and()	
//				.formLogin();
		// @formatter:on
	}

//	@Autowired
//	private DataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	// la methode d'authentification
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// authentification en memoire
//		// @formatter:off
//		auth.inMemoryAuthentication()
//				.withUser("olivier").password("{noop}olivier").roles("ADMIN","COMPAGNON")
//				.and()
//				.withUser("compagnon").password("{noop}compagnon").roles("COMPAGNON")
//				.and()
//				.withUser("user").password("{noop}user").roles("USER");
//		// @formatter:on

		// authentification avec requetes sql
//		// @formatter:off
//		auth.jdbcAuthentication()
//				.dataSource(dataSource)
//					.usersByUsernameQuery("select login,password,enable from users where login=?")
//					.authoritiesByUsernameQuery("select login,roles from users_roles ur join users u on ur.user_id=u.id where login=?");
//		// @formatter:on

		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
