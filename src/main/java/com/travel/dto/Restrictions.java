
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
@JsonPropertyOrder({ "refundable", "change_penalties" })
public class Restrictions {

	@JsonProperty("refundable")
	private Boolean refundable;
	@JsonProperty("change_penalties")
	private Boolean changePenalties;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("refundable")
	public Boolean getRefundable() {
		return refundable;
	}

	@JsonProperty("refundable")
	public void setRefundable(Boolean refundable) {
		this.refundable = refundable;
	}

	@JsonProperty("change_penalties")
	public Boolean getChangePenalties() {
		return changePenalties;
	}

	@JsonProperty("change_penalties")
	public void setChangePenalties(Boolean changePenalties) {
		this.changePenalties = changePenalties;
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
