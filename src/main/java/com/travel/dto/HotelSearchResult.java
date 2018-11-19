
package com.travel.dto;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "property_code", "property_name", "location", "address", "total_price", "min_daily_rate",
		"contacts", "amenities", "awards", "images", "rooms", "_links" })
public class HotelSearchResult {

	@JsonProperty("property_code")
	private String propertyCode;
	@JsonProperty("property_name")
	private String propertyName;
	@JsonProperty("location")
	private Location location;
	@JsonProperty("address")
	private Address address;
	@JsonProperty("total_price")
	private TotalPrice totalPrice;
	@JsonProperty("min_daily_rate")
	private MinDailyRate minDailyRate;
	@JsonProperty("contacts")
	private List<Contact> contacts = null;
	@JsonProperty("amenities")
	private List<Amenity> amenities = null;
	@JsonProperty("awards")
	private List<Award> awards = null;
	@JsonProperty("images")
	private List<Object> images = null;
	@JsonProperty("rooms")
	private List<Room> rooms = null;
	@JsonProperty("_links")
	private Links links;

	@JsonProperty("property_code")
	public String getPropertyCode() {
		return propertyCode;
	}

	@JsonProperty("property_code")
	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	@JsonProperty("property_name")
	public String getPropertyName() {
		return propertyName;
	}

	@JsonProperty("property_name")
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	@JsonProperty("location")
	public Location getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(Location location) {
		this.location = location;
	}

	@JsonProperty("address")
	public Address getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(Address address) {
		this.address = address;
	}

	@JsonProperty("total_price")
	public TotalPrice getTotalPrice() {
		return totalPrice;
	}

	@JsonProperty("total_price")
	public void setTotalPrice(TotalPrice totalPrice) {
		this.totalPrice = totalPrice;
	}

	@JsonProperty("min_daily_rate")
	public MinDailyRate getMinDailyRate() {
		return minDailyRate;
	}

	@JsonProperty("min_daily_rate")
	public void setMinDailyRate(MinDailyRate minDailyRate) {
		this.minDailyRate = minDailyRate;
	}

	@JsonProperty("contacts")
	public List<Contact> getContacts() {
		return contacts;
	}

	@JsonProperty("contacts")
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@JsonProperty("amenities")
	public List<Amenity> getAmenities() {
		return amenities;
	}

	@JsonProperty("amenities")
	public void setAmenities(List<Amenity> amenities) {
		this.amenities = amenities;
	}

	@JsonProperty("awards")
	public List<Award> getAwards() {
		return awards;
	}

	@JsonProperty("awards")
	public void setAwards(List<Award> awards) {
		this.awards = awards;
	}

	@JsonProperty("images")
	public List<Object> getImages() {
		return images;
	}

	@JsonProperty("images")
	public void setImages(List<Object> images) {
		this.images = images;
	}

	@JsonProperty("rooms")
	public List<Room> getRooms() {
		return rooms;
	}

	@JsonProperty("rooms")
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@JsonProperty("_links")
	public Links getLinks() {
		return links;
	}

	@JsonProperty("_links")
	public void setLinks(Links links) {
		this.links = links;
	}

}