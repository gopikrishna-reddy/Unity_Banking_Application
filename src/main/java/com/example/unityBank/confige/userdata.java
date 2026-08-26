package com.example.unityBank.confige;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class userdata {
    @Bean

    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
public UserDetailsService userDetails(PasswordEncoder encoder){
        UserDetails admin= User.builder().username("admin").password(encoder.encode("Gopi@123")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(admin);

}
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
http.csrf(csrf->csrf.disable()).authorizeHttpRequests(auth-> auth.requestMatchers("/admin/all").hasRole("ADMIN")
        .requestMatchers("/admin/add").permitAll().anyRequest().authenticated()).formLogin(Customizer.withDefaults());
return http.build();
}


}
