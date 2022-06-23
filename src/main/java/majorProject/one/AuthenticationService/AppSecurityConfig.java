package majorProject.one.AuthenticationService;

import majorProject.one.AuthenticationService.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserAuthnService userAuthnService;
    @Autowired
    private MyPasswordEncoder passWordEncoder;
    @Autowired
    private UserRepository userrepo;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth
                .userDetailsService(userAuthnService)
                .passwordEncoder(passWordEncoder)
                .and()
                .inMemoryAuthentication()
                .passwordEncoder(passWordEncoder)
                .withUser("admin")
                .authorities("ADMIN")
                .password(passWordEncoder.encode("password"));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/user/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/transaction/**")
                .authenticated()
                .and()
                .csrf()
                .disable();
    }
}
