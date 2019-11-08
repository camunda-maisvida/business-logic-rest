package br.com.maisvida.camunda.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableWrapper {

	@JsonProperty("variables")
	private List<VariableDTO> variables;

	public List<VariableDTO> getVariables() {

		return variables;
	}

	public void setVariables(List<VariableDTO> variables) {

		this.variables = variables;
	}

}
