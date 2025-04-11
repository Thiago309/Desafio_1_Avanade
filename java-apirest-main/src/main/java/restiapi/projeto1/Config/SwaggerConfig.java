package restiapi.projeto1.Config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Este código configura a documentação da API utilizando o Springdoc OpenAPI, que integra o Swagger 2.8.5
 * ao Spring Boot de forma automática.
 *
 * @author Thiago Vinicius
 * @Version 3.0
 * @since 10/04/2025
*/

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API - Gerenciador de Alugueis")
                        .version("3.0.0")
                        .description("Registros de Alugueis de Automoveis"));
    }
}