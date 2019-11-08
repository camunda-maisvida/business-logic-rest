package br.com.maisvida.camunda.rest.dto;

public class ProcessInstanceDto {

	private String id;

	private String definitionId;

	private String businessKey;

	private String caseInstanceId;

	private boolean ended;

	private boolean suspended;

	private String tenantId;

	public ProcessInstanceDto() {

	}

	public String getId() {

		return id;
	}

	public String getDefinitionId() {

		return definitionId;
	}

	public String getBusinessKey() {

		return businessKey;
	}

	public String getCaseInstanceId() {

		return caseInstanceId;
	}

	public boolean isEnded() {

		return ended;
	}

	public boolean isSuspended() {

		return suspended;
	}

	public String getTenantId() {

		return tenantId;
	}

	@Override
	public String toString() {

		return "ProcessInstanceDto [id=" + id + ", definitionId=" + definitionId + ", businessKey=" + businessKey + ", caseInstanceId=" + caseInstanceId + ", ended=" + ended + ", suspended=" + suspended + ", tenantId=" + tenantId + "]";
	}

}
