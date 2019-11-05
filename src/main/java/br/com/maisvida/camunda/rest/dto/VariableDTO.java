package br.com.maisvida.camunda.rest.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableDTO {

	private String name;

	private String type;

	private Object value;

	private Map<String, Object> valueInfo;

	public String getType() {

		return type;
	}

	public void setType(String type) {

		this.type = type;
	}

	public Object getValue() {

		return value;
	}

	public void setValue(Object value) {

		this.value = value;
	}

	public Map<String, Object> getValueInfo() {

		return valueInfo;
	}

	public void setValueInfo(Map<String, Object> valueInfo) {

		this.valueInfo = valueInfo;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	@Override
	public String toString() {

		return "VariableDTO [name=" + name + ", type=" + type + ", value=" + value + ", valueInfo=" + valueInfo + "]";
	}

}
