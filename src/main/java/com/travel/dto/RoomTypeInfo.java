
package com.travel.dto;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "bed_type" })
public class RoomTypeInfo {

	@JsonProperty("bed_type")
	private String bedType;

	@JsonProperty("bed_type")
	public String getBedType() {
		return bedType;
	}

	@JsonProperty("bed_type")
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

}
