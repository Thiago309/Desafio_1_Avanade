package restiapi.projeto1.Config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * A classe ScurityConfig, configura a segurança da aplicação Spring Boot, definindo regras de autenticação e
 * autorização para os endpoints da API. O usuario e senha, encontrasse no arquivo application.properties.
 */

//  @Configuration Indica que esta classe é uma fonte de definições de beans para o contexto do Spring.
@Configuration
//  Define a classe de configuração de segurança.
public class SecurityConfig {
//  @Bean é um metodo retorna um bean gerenciado pelo Spring.
    @Bean
//  Define o bean SecurityFilterChain, que configura a cadeia de filtros de segurança da aplicação.
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//  Configura as regras de autorização para as requisições HTTP.
        http
                .authorizeHttpRequests(auth -> auth
                //  Especifica que qualquer requisição aos caminhos /swagger-ui/** e /v3/api-docs/** requer autenticação.
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").authenticated()
                //  Permite que todas as outras requisições sejam acessadas sem autenticação.
                        .anyRequest().permitAll()
                )
                .httpBasic()
                .and()
                /*  Desabilita a proteção contra CSRF (Cross-Site Request Forgery). Isso é comum em APIs RESTful,
                    onde o cliente é responsável por gerenciar a segurança das requisições.*/
                .csrf().disable();
        // Finaliza a configuração e retorna o objeto.
        return http.build();
    }
}