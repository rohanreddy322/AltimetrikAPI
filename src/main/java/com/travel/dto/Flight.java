
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
@JsonPropertyOrder({ "departs_at", "arrives_at", "origin", "destination", "marketing_airline", "operating_airline",
		"flight_number", "aircraft", "booking_info" })
public class Flight {

	@JsonProperty("departs_at")
	private String departsAt;
	@JsonProperty("arrives_at")
	private String arrivesAt;
	@JsonProperty("origin")
	private Origin origin;
	@JsonProperty("destination")
	private Destination destination;
	@JsonProperty("marketing_airline")
	private String marketingAirline;
	@JsonProperty("operating_airline")
	private String operatingAirline;
	@JsonProperty("flight_number")
	private String flightNumber;
	@JsonProperty("aircraft")
	private String aircraft;
	@JsonProperty("booking_info")
	private BookingInfo bookingInfo;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("departs_at")
	public String getDepartsAt() {
		return departsAt;
	}

	@JsonProperty("departs_at")
	public void setDepartsAt(String departsAt) {
		this.departsAt = departsAt;
	}

	@JsonProperty("arrives_at")
	public String getArrivesAt() {
		return arrivesAt;
	}

	@JsonProperty("arrives_at")
	public void setArrivesAt(String arrivesAt) {
		this.arrivesAt = arrivesAt;
	}

	@JsonProperty("origin")
	public Origin getOrigin() {
		return origin;
	}

	@JsonProperty("origin")
	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	@JsonProperty("destination")
	public Destination getDestination() {
		return destination;
	}

	@JsonProperty("destination")
	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	@JsonProperty("marketing_airline")
	public String getMarketingAirline() {
		return marketingAirline;
	}

	@JsonProperty("marketing_airline")
	public void setMarketingAirline(String marketingAirline) {
		this.marketingAirline = marketingAirline;
	}

	@JsonProperty("operating_airline")
	public String getOperatingAirline() {
		return operatingAirline;
	}

	@JsonProperty("operating_airline")
	public void setOperatingAirline(String operatingAirline) {
		this.operatingAirline = operatingAirline;
	}

	@JsonProperty("flight_number")
	public String getFlightNumber() {
		return flightNumber;
	}

	@JsonProperty("flight_number")
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	@JsonProperty("aircraft")
	public String getAircraft() {
		return aircraft;
	}

	@JsonProperty("aircraft")
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}

	@JsonProperty("booking_info")
	public BookingInfo getBookingInfo() {
		return bookingInfo;
	}

	@JsonProperty("booking_info")
	public void setBookingInfo(BookingInfo bookingInfo) {
		this.bookingInfo = bookingInfo;
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
