
package com.travel.dto;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "type", "price" })
public class RateObj {

	@JsonProperty("type")
	private String type;
	@JsonProperty("price")
	private Price price;

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("price")
	public Price getPrice() {
		return price;
	}

	@JsonProperty("price")
	public void setPrice(Price price) {
		this.price = price;
	}

}
