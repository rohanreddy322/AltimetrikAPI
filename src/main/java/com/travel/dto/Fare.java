
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
@JsonPropertyOrder({ "total_price", "price_per_adult", "restrictions" })
public class Fare {

	@JsonProperty("total_price")
	private String totalPrice;
	@JsonProperty("price_per_adult")
	private PricePerAdult pricePerAdult;
	@JsonProperty("restrictions")
	private Restrictions restrictions;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("total_price")
	public String getTotalPrice() {
		return totalPrice;
	}

	@JsonProperty("total_price")
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	@JsonProperty("price_per_adult")
	public PricePerAdult getPricePerAdult() {
		return pricePerAdult;
	}

	@JsonProperty("price_per_adult")
	public void setPricePerAdult(PricePerAdult pricePerAdult) {
		this.pricePerAdult = pricePerAdult;
	}

	@JsonProperty("restrictions")
	public Restrictions getRestrictions() {
		return restrictions;
	}

	@JsonProperty("restrictions")
	public void setRestrictions(Restrictions restrictions) {
		this.restrictions = restrictions;
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
