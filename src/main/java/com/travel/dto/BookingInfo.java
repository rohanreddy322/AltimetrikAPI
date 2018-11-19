
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
@JsonPropertyOrder({ "travel_class", "booking_code", "seats_remaining" })
public class BookingInfo {

	@JsonProperty("travel_class")
	private String travelClass;
	@JsonProperty("booking_code")
	private String bookingCode;
	@JsonProperty("seats_remaining")
	private Integer seatsRemaining;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("travel_class")
	public String getTravelClass() {
		return travelClass;
	}

	@JsonProperty("travel_class")
	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}

	@JsonProperty("booking_code")
	public String getBookingCode() {
		return bookingCode;
	}

	@JsonProperty("booking_code")
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	@JsonProperty("seats_remaining")
	public Integer getSeatsRemaining() {
		return seatsRemaining;
	}

	@JsonProperty("seats_remaining")
	public void setSeatsRemaining(Integer seatsRemaining) {
		this.seatsRemaining = seatsRemaining;
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
