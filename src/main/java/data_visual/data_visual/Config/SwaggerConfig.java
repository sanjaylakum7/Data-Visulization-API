package data_visual.data_visual.Config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

		@Bean
		public OpenAPI springSwaggerConfig(){
				return new OpenAPI().info(new Info().title("Data Visualization Application").description("Backend APIs for " +
								"Data " +
								"Visualization App").version("v1.0.0").contact(new Contact().name("Sanjay Lakum").email(
												"sanjaylakum431@gmail.com")).license(new License().name("Licence").url("/"))).externalDocs(new ExternalDocumentation().description("Data Visualization Application Documentation")
								.url("http://localhost:8080/swagger-ui/index.html"));
		}
}
