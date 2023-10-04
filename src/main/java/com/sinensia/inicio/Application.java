package com.sinensia.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

/**
 * Clase de configuracion, añadimos el @Bean de RestTemplate para poder
 * utilizarlo en nuestro @Service
 * 
 * @author Sergio
 * @see com.sinensia.controller.PedidoController
 */
@EntityScan(basePackages = "com.sinensia.model")
@EnableJpaRepositories(basePackages = "com.sinensia.dao")
@SpringBootApplication(scanBasePackages = { "com.sinensia.service", "com.sinensia.controller" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
