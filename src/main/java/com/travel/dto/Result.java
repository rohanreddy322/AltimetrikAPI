
package com.travel.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "itineraries", "fare" })
public class Result {

	@JsonProperty("itineraries")
	private List<Itinerary> itineraries = null;
	@JsonProperty("fare")
	private Fare fare;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("itineraries")
	public List<Itinerary> getItineraries() {
		return itineraries;
	}

	@JsonProperty("itineraries")
	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}

	@JsonProperty("fare")
	public Fare getFare() {
		return fare;
	}

	@JsonProperty("fare")
	public void setFare(Fare fare) {
		this.fare = fare;
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
