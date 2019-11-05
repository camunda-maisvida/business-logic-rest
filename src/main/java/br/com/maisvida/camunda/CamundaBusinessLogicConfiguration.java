package br.com.maisvida.camunda;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CamundaBusinessLogicConfiguration {

	@Bean
	public RestTemplate getRestTemplate() {

		return new RestTemplate();
	}
}
