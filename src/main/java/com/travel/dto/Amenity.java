
package com.travel.dto;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "amenity", "ota_code", "description" })
public class Amenity {

	@JsonProperty("amenity")
	private String amenity;
	@JsonProperty("ota_code")
	private Integer otaCode;
	@JsonProperty("description")
	private String description;

	@JsonProperty("amenity")
	public String getAmenity() {
		return amenity;
	}

	@JsonProperty("amenity")
	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}

	@JsonProperty("ota_code")
	public Integer getOtaCode() {
		return otaCode;
	}

	@JsonProperty("ota_code")
	public void setOtaCode(Integer otaCode) {
		this.otaCode = otaCode;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

}
