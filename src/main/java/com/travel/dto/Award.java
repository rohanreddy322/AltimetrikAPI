
package com.travel.dto;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "provider", "rating" })
public class Award {

	@JsonProperty("provider")
	private String provider;
	@JsonProperty("rating")
	private String rating;

	@JsonProperty("provider")
	public String getProvider() {
		return provider;
	}

	@JsonProperty("provider")
	public void setProvider(String provider) {
		this.provider = provider;
	}

	@JsonProperty("rating")
	public String getRating() {
		return rating;
	}

	@JsonProperty("rating")
	public void setRating(String rating) {
		this.rating = rating;
	}

}
