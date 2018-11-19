
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
@JsonPropertyOrder({ "airport", "terminal" })
public class Destination {

	@JsonProperty("airport")
	private String airport;
	@JsonProperty("terminal")
	private String terminal;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("airport")
	public String getAirport() {
		return airport;
	}

	@JsonProperty("airport")
	public void setAirport(String airport) {
		this.airport = airport;
	}

	@JsonProperty("terminal")
	public String getTerminal() {
		return terminal;
	}

	@JsonProperty("terminal")
	public void setTerminal(String terminal) {
		this.terminal = terminal;
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
