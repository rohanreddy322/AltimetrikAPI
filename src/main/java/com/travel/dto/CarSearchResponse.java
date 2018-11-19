
package com.travel.dto;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "results" })
public class CarSearchResponse {

	@JsonProperty("results")
	private List<CarResult> results = null;

	@JsonProperty("results")
	public List<CarResult> getResults() {
		return results;
	}

	@JsonProperty("results")
	public void setResults(List<CarResult> results) {
		this.results = results;
	}

}
