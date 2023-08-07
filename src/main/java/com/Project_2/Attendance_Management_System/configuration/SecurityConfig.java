
package com.Project_2.Attendance_Management_System.configuration;

        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.core.userdetails.User;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import org.springframework.security.crypto.password.PasswordEncoder;
        import org.springframework.security.provisioning.InMemoryUserDetailsManager;
        import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    //authentication
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin = User.withUsername("Uddhav")
                .password(encoder.encode("123"))
                .roles("ADMIN")
                .build();
        UserDetails facutly = User.withUsername("Chandan")
                .password(encoder.encode("abc"))
                .roles("FACULTY")
                .build();
        UserDetails student = User.withUsername("Sidharth")
                .password(encoder.encode("xyz"))
                .roles("STUDENT")
                .build();

        return new InMemoryUserDetailsManager(admin,facutly,student);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests().antMatchers("/**")
                .authenticated().and().formLogin().and().build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
