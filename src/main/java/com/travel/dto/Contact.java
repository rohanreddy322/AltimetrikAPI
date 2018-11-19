
package com.travel.dto;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "type", "detail" })
public class Contact {

	@JsonProperty("type")
	private String type;
	@JsonProperty("detail")
	private String detail;

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("detail")
	public String getDetail() {
		return detail;
	}

	@JsonProperty("detail")
	public void setDetail(String detail) {
		this.detail = detail;
	}

}
