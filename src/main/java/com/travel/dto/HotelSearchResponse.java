
package com.travel.dto;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "results" })
public class HotelSearchResponse {

	@JsonProperty("results")
	private List<HotelSearchResult> results = null;

	@JsonProperty("results")
	public List<HotelSearchResult> getResults() {
		return results;
	}

	@JsonProperty("results")
	public void setResults(List<HotelSearchResult> results) {
		this.results = results;
	}

}
