package org.proto1.dto;

public class UnitOfMeasurementDTO extends DTO {

	private static final long serialVersionUID = 6376088966271169163L;

	private Long uomId;
	private String uomShortName;
	private String uomFullName;

	public Long getUomId() {
		return uomId;
	}

	public void setUomId(Long uomId) {
		this.uomId = uomId;
	}

	public String getUomShortName() {
		return uomShortName;
	}

	public void setUomShortName(String uomShortName) {
		this.uomShortName = uomShortName;
	}

	public String getUomFullName() {
		return uomFullName;
	}

	public void setUomFullName(String uomFullName) {
		this.uomFullName = uomFullName;
	}

}
