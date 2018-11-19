
package com.travel.dto;

import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "total_fare", "tax" })
public class PricePerAdult {

	@JsonProperty("total_fare")
	private String totalFare;
	@JsonProperty("tax")
	private String tax;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("total_fare")
	public String getTotalFare() {
		return totalFare;
	}

	@JsonProperty("total_fare")
	public void setTotalFare(String totalFare) {
		this.totalFare = totalFare;
	}

	@JsonProperty("tax")
	public String getTax() {
		return tax;
	}

	@JsonProperty("tax")
	public void setTax(String tax) {
		this.tax = tax;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
