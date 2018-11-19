
package com.travel.dto;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "acriss_code", "transmission", "fuel", "air_conditioning", "category", "type" })
public class VehicleInfo {

	@JsonProperty("acriss_code")
	private String acrissCode;
	@JsonProperty("transmission")
	private String transmission;
	@JsonProperty("fuel")
	private String fuel;
	@JsonProperty("air_conditioning")
	private Boolean airConditioning;
	@JsonProperty("category")
	private String category;
	@JsonProperty("type")
	private String type;

	@JsonProperty("acriss_code")
	public String getAcrissCode() {
		return acrissCode;
	}

	@JsonProperty("acriss_code")
	public void setAcrissCode(String acrissCode) {
		this.acrissCode = acrissCode;
	}

	@JsonProperty("transmission")
	public String getTransmission() {
		return transmission;
	}

	@JsonProperty("transmission")
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	@JsonProperty("fuel")
	public String getFuel() {
		return fuel;
	}

	@JsonProperty("fuel")
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	@JsonProperty("air_conditioning")
	public Boolean getAirConditioning() {
		return airConditioning;
	}

	@JsonProperty("air_conditioning")
	public void setAirConditioning(Boolean airConditioning) {
		this.airConditioning = airConditioning;
	}

	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

}
