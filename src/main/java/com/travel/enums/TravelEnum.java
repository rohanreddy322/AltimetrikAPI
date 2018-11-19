package com.travel.enums;

public enum TravelEnum {

	SEARCH_FLIGHT("https://api.sandbox.amadeus.com/v1.2/flights/low-fare-search"),
	SEARCH_HOTEL("https://api.sandbox.amadeus.com/v1.2/hotels/search-airport"),
	SEARCH_CAR("https://api.sandbox.amadeus.com/v1.2/cars/search-airport");

	private String value;

	private TravelEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
