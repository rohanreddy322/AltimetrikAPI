
package com.travel.dto;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "vehicle_info", "rates", "images", "estimated_total" })
public class Car {

	@JsonProperty("vehicle_info")
	private VehicleInfo vehicleInfo;
	@JsonProperty("rates")
	private List<RateObj> rates = null;
	@JsonProperty("images")
	private List<Image> images = null;
	@JsonProperty("estimated_total")
	private EstimatedTotal estimatedTotal;

	@JsonProperty("vehicle_info")
	public VehicleInfo getVehicleInfo() {
		return vehicleInfo;
	}

	@JsonProperty("vehicle_info")
	public void setVehicleInfo(VehicleInfo vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}

	@JsonProperty("rates")
	public List<RateObj> getRates() {
		return rates;
	}

	@JsonProperty("rates")
	public void setRates(List<RateObj> rates) {
		this.rates = rates;
	}

	@JsonProperty("images")
	public List<Image> getImages() {
		return images;
	}

	@JsonProperty("images")
	public void setImages(List<Image> images) {
		this.images = images;
	}

	@JsonProperty("estimated_total")
	public EstimatedTotal getEstimatedTotal() {
		return estimatedTotal;
	}

	@JsonProperty("estimated_total")
	public void setEstimatedTotal(EstimatedTotal estimatedTotal) {
		this.estimatedTotal = estimatedTotal;
	}

}
