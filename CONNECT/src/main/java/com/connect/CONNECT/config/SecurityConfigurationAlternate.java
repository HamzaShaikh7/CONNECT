package com.connect.CONNECT.config;

//@Component
//@EnableWebSecurity
//@Profile("dev")
//@Configuration
//public class SecurityConfigurationAlternate {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    // Define the SecurityFilterChain bean
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorize -> authorize
//                        .antMatchers("/journal/**", "/user/**").authenticated()
//                        .antMatchers("/admin/**").hasRole("ADMIN")
//                        .anyRequest().permitAll()
//                )
//                .httpBasic(withDefaults()) // Enable HTTP Basic authentication
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless session
//                )
//                .csrf(csrf -> csrf.disable()); // Disable CSRF protection
//
//        return http.build();
//    }
//
//    // Define the AuthenticationManager bean
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder())
//                .and()
//                .build();
//    }
//
//    // Define the PasswordEncoder bean
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
//
