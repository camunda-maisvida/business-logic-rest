package br.com.maisvida.camunda.rest.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultWrapper {

	private ProcessInstanceDto processInstance;

	private List<VariableDTO> variables = new ArrayList<>();

	public ProcessInstanceDto getProcessInstance() {

		return processInstance;
	}

	public void setProcessInstance(ProcessInstanceDto processInstance) {

		this.processInstance = processInstance;
	}

	public List<VariableDTO> getVariables() {

		return variables;
	}

	public void setVariables(Map<String, VariableDTO> variablesMap) {

		if(variablesMap != null && !variablesMap.isEmpty()) {			
			variablesMap.forEach((k,v) -> {v.setName(k);});
			this.variables = new ArrayList<>(variablesMap.values());
		}else {
			
			this.variables = new ArrayList<VariableDTO>();
		}

	}

	public void setVariables(VariableDTO[] variables) {
		
		this.variables = variables != null ? Arrays.asList(variables) : new ArrayList<VariableDTO>();
	}

	public void setVariables(List<VariableDTO> variables) {
		
		this.variables = variables != null ? variables : new ArrayList<VariableDTO>();
	}

	@Override
	public String toString() {

		return "ResultWrapper [processInstance=" + processInstance + ", \n# " + variables.stream().map(VariableDTO::toString).collect(Collectors.joining("\n# ")) + "]";
	}

}
