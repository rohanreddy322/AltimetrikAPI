
package com.travel.dto;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "provider", "branch_id", "location", "airport", "address", "cars" })
public class CarResult {

	@JsonProperty("provider")
	private Provider provider;
	@JsonProperty("branch_id")
	private String branchId;
	@JsonProperty("location")
	private Location location;
	@JsonProperty("airport")
	private String airport;
	@JsonProperty("address")
	private Address address;
	@JsonProperty("cars")
	private List<Car> cars = null;

	@JsonProperty("provider")
	public Provider getProvider() {
		return provider;
	}

	@JsonProperty("provider")
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@JsonProperty("branch_id")
	public String getBranchId() {
		return branchId;
	}

	@JsonProperty("branch_id")
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	@JsonProperty("location")
	public Location getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(Location location) {
		this.location = location;
	}

	@JsonProperty("airport")
	public String getAirport() {
		return airport;
	}

	@JsonProperty("airport")
	public void setAirport(String airport) {
		this.airport = airport;
	}

	@JsonProperty("address")
	public Address getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(Address address) {
		this.address = address;
	}

	@JsonProperty("cars")
	public List<Car> getCars() {
		return cars;
	}

	@JsonProperty("cars")
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
