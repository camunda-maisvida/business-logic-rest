package br.com.maisvida.camunda.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.maisvida.camunda.rest.dto.ProcessInstanceDto;
import br.com.maisvida.camunda.rest.dto.ResultWrapper;
import br.com.maisvida.camunda.rest.dto.VariableDTO;

@RestController
public class ProcessInstanceLoggerRest {

	private final Logger logger = LoggerFactory.getLogger(ProcessInstanceLoggerRest.class);

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/process-instance/{processInstanceId}")
	public ResponseEntity<Object> processInstanceLog(@PathVariable("processInstanceId") final String processInstanceId) throws URISyntaxException {

		System.out.println("processInstanceId: " + processInstanceId);
		final URI uriProcessInstance = new URI("http://localhost:8080/engine-rest/process-instance/" + processInstanceId);
		final URI uriVariables = new URI(uriProcessInstance.toString() + "/variables");

		

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + getBaseicAuth());
		HttpEntity<String> request = new HttpEntity<String>(headers);
		
		final ResponseEntity<ProcessInstanceDto> processInstance = this.restTemplate.exchange(uriProcessInstance, 
				HttpMethod.GET, 
				request, 
				ProcessInstanceDto.class);

		final ResponseEntity<Map<String, VariableDTO>> variables = this.restTemplate.exchange(uriVariables, 
				HttpMethod.GET, 
				request, 
				new ParameterizedTypeReference<Map<String, VariableDTO>>(){});
		
		final ResultWrapper result = new ResultWrapper();
		result.setProcessInstance(processInstance.getBody());
		result.setVariables(variables.getBody());

		this.logger.info(">>>>>> "+result.toString());
		return ResponseEntity.ok().body(result);
	}
	
	private String getBaseicAuth() {
		String plainCreds = "admin:qwe123";
		byte[] plainCredsBytes = plainCreds.getBytes();
		String base64Creds = Base64.getEncoder().encodeToString(plainCredsBytes);
		return base64Creds;
	}
		
}
