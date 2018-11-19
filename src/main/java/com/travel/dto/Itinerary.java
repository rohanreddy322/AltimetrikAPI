
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
@JsonPropertyOrder({ "outbound", "inbound" })
public class Itinerary {

	@JsonProperty("outbound")
	private Outbound outbound;
	@JsonProperty("inbound")
	private Inbound inbound;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("outbound")
	public Outbound getOutbound() {
		return outbound;
	}

	@JsonProperty("outbound")
	public void setOutbound(Outbound outbound) {
		this.outbound = outbound;
	}

	@JsonProperty("inbound")
	public Inbound getInbound() {
		return inbound;
	}

	@JsonProperty("inbound")
	public void setInbound(Inbound inbound) {
		this.inbound = inbound;
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
